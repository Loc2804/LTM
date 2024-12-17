package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.BEAN.Booking;
import Model.BEAN.Tables;
import Model.BEAN.User;
import Model.BO.BookingBO;
import Model.BO.TablesBO;

@WebServlet("/BookingController")
public class BookingController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BookingController() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "index":
                index(request, response);
                break;
            case "create":
                create(request, response);
                break;
            case "update":
                edit(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "view":
                view(request, response);
                break;
            case "search":
            	search(request, response);
                break;
            case "order":
            	order(request, response);
                break;
            case "history":
            	history(request, response);
                break;
            case "confirm":
            	confirm(request, response);
                break;
            case "cancel":
            	cancel(request, response);
                break;
            case "finish":
            	finish(request, response);
                break;
            default:
                index(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "create":
                create(request, response);
                break;
            case "update":
                edit(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "view":
                view(request, response);
                break;
            case "search":
            	search(request, response);
                break;
            case "order":
            	order(request, response);
                break;
            case "history":
            	history(request, response); //m ctrl A từ bên m qua cho nhanh
                break;
            case "confirm":
            	confirm(request, response);
                break;
            case "cancel":
            	cancel(request, response);
                break;
            case "finish":
            	finish(request, response);
                break;
            default:
                response.sendRedirect("BookingController?action=index");
                break;
        }
    }

    // Liệt kê danh sách booking
    private void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Booking> bookingList = BookingBO.getAllBookings();
        request.setAttribute("bookingList", bookingList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Index_booking.jsp");
        dispatcher.forward(request, response);
    }

    // Tạo mới booking
    private void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getMethod();

        if (method.equalsIgnoreCase("GET")) {
        	// Lấy danh sách tất cả các bàn từ database qua BO
            List<Long> tablesList = TablesBO.getAllTablesId();

            request.setAttribute("tablesList", tablesList);
        	// Lấy danh sách tất cả các booking từ database qua BO
            List<Booking> bookingsList = BookingBO.getAllBookings();
         // Đưa danh sách booking vào request
            request.setAttribute("bookingsList", bookingsList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("CreateBooking.jsp");
            dispatcher.forward(request, response);
        } else if (method.equalsIgnoreCase("POST")) {
            long userId = Long.parseLong(request.getParameter("user_id"));
            long tableId = Long.parseLong(request.getParameter("table_id"));
            long statusId = Long.parseLong(request.getParameter("status_id"));
            String date = request.getParameter("date");

            Booking booking = new Booking();
            booking.setUser_id(userId);
            booking.setTable_id(tableId);
            booking.setStatus_id(statusId);
            booking.setDate(java.sql.Date.valueOf(date));
            updateTableStatus(tableId, statusId);
            BookingBO.create(booking);
            response.sendRedirect("BookingController?action=index");
        }
    }
    
    private void order(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getMethod();

        if (method.equalsIgnoreCase("GET")) {
        	// Lấy danh sách tất cả các bàn từ database qua BO
            List<Long> tablesList = TablesBO.getAllTablesId();

            request.setAttribute("tablesList", tablesList);
        	// Lấy danh sách tất cả các booking từ database qua BO
            List<Booking> bookingsList = BookingBO.getAllBookings();
         // Đưa danh sách booking vào request
            request.setAttribute("bookingsList", bookingsList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("CreateBooking.jsp");
            dispatcher.forward(request, response);
        } else if (method.equalsIgnoreCase("POST")) {
        	long userId = Long.parseLong(request.getParameter("user_id"));
            long tableId = Long.parseLong(request.getParameter("table_id"));
            long statusId = Long.parseLong(request.getParameter("status_id"));
            
            String date = request.getParameter("date");

            // Tạo một booking mới
            Booking booking = new Booking();
            booking.setUser_id(userId);
            booking.setTable_id(tableId);
            booking.setStatus_id(statusId);
            booking.setDate(java.sql.Date.valueOf(date));

            // Cập nhật trạng thái bàn và lưu booking
            
            BookingBO.create(booking);

           
            List<Booking> bookingsList = BookingBO.getAllBookings();
            request.setAttribute("bookingsList", bookingsList);

            // Chuyển đến trang ViewBookings.jsp để hiển thị danh sách booking
            RequestDispatcher dispatcher = request.getRequestDispatcher("HistoryBooking.jsp");
            dispatcher.forward(request, response);
            
        }
    }
    
    private void updateTableStatus(Long tableId, Long statusId) {
        // Giả sử bạn có một lớp DAO để tương tác với CSDL
        TablesBO tableBO = new TablesBO();
        tableBO.updateTableStatus(tableId, statusId);
    }

    // Cập nhật booking
    private void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getMethod();

        if (method.equalsIgnoreCase("GET")) {
        	// Lấy danh sách tất cả các bàn từ database qua BO
            List<Long> tablesList = TablesBO.getAllTablesId();

            request.setAttribute("tablesList", tablesList);
        	// Lấy danh sách tất cả các booking từ database qua BO
            List<Booking> bookingsList = BookingBO.getAllBookings();
         // Đưa danh sách booking vào request
            request.setAttribute("bookingsList", bookingsList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateBooking.jsp");
            dispatcher.forward(request, response);
        } else if (method.equalsIgnoreCase("POST")) {
            long id = Long.parseLong(request.getParameter("id"));
            long userId = Long.parseLong(request.getParameter("user_id"));
            long tableId = Long.parseLong(request.getParameter("table_id"));
            long statusId = Long.parseLong(request.getParameter("status_id"));
            String date = request.getParameter("date");

            Booking booking = new Booking();
            booking.setId(id);
            booking.setUser_id(userId);
            booking.setTable_id(tableId);
            booking.setStatus_id(statusId);
            booking.setDate(java.sql.Date.valueOf(date));
            
            
            BookingBO.update(booking);
            response.sendRedirect("BookingController?action=index");
        }
    }

    // Xóa booking
    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String method = request.getMethod();

        if (method.equalsIgnoreCase("GET")) {
        	// Lấy danh sách tất cả các booking từ database qua BO
            List<Booking> bookingsList = BookingBO.getAllBookings();
         // Đưa danh sách booking vào request
            request.setAttribute("bookingsList", bookingsList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("DeleteBooking.jsp");
            dispatcher.forward(request, response);
        } else if (method.equalsIgnoreCase("POST")) {
        	long bookingId = Long.parseLong(request.getParameter("id"));
            BookingBO.delete(bookingId);
            response.sendRedirect("BookingController?action=index");
        }
    }

 // Xem danh sách booking
    private void view(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy danh sách tất cả các booking từ database qua BO
        List<Booking> bookingsList = BookingBO.getAllBookings();

        // Kiểm tra xem danh sách booking có trống không
        if (bookingsList != null && !bookingsList.isEmpty()) {
            // Đưa danh sách booking vào request
            request.setAttribute("bookingsList", bookingsList);

            // Chuyển đến trang ViewBookings.jsp để hiển thị danh sách booking
            RequestDispatcher dispatcher = request.getRequestDispatcher("ViewBooking.jsp");
            dispatcher.forward(request, response);
        } else {
            // Nếu không có booking, chuyển hướng về trang danh sách
            response.sendRedirect("BookingController?action=index");
        }
    }

    
    private void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getMethod();

        if (method.equalsIgnoreCase("GET")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("SearchBooking.jsp");
            dispatcher.forward(request, response);
        } else if (method.equalsIgnoreCase("POST")) {
            String searchBy = request.getParameter("searchBy"); // Cột muốn tìm kiếm
            String keyword = request.getParameter("searchString"); // Từ khóa tìm kiếm

            List<Booking> bookingList = BookingBO.searchByCol(searchBy, keyword);
            request.setAttribute("bookingList", bookingList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("SearchBooking.jsp");
            dispatcher.forward(request, response);
        }
    }
    private void history(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Kiểm tra xem session có tồn tại hay không
        HttpSession session = request.getSession(false);
        if (session == null) {
            System.out.println("Session is null");
            response.sendRedirect("Login.jsp");
            return;
        } else {
            System.out.println("Session ID: " + session.getId());
        }

        // Lấy đối tượng user từ session
        User user = (User) session.getAttribute("user");
        if (user == null) {
            System.out.println("User is null or not logged in");
            response.sendRedirect("Login.jsp");
            return;
        } else {
            System.out.println("User found in session: ID = " + user.getId());
        }

        long userId = user.getId();

        // Lấy danh sách booking từ database
        List<Booking> bookingsList = null;
        try {
            System.out.println("Fetching bookings for user ID: " + userId);
            bookingsList = BookingBO.getBookingsByUserId(userId);
            if (bookingsList == null || bookingsList.isEmpty()) {
                System.out.println("No bookings found for user ID: " + userId);
            } else {
                System.out.println("Bookings found: " + bookingsList.size());
            }
        } catch (Exception e) {
            System.err.println("Error while fetching bookings: " + e.getMessage());
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while fetching bookings.");
            return;
        }

        // Kiểm tra và chuyển hướng phù hợp
        if (bookingsList != null && !bookingsList.isEmpty()) {
            request.setAttribute("bookingsList", bookingsList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("HistoryBooking.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("BookingController?action=index");
        }
    }




    
    private void confirm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getMethod();

        if (method.equalsIgnoreCase("GET")) {
            // Lấy danh sách tất cả các bàn từ database qua BO
            List<Long> tablesList = TablesBO.getAllTablesId();
            request.setAttribute("tablesList", tablesList);

            // Lấy danh sách tất cả các booking từ database qua BO
            List<Booking> bookingsList = BookingBO.getAllBookings();
            request.setAttribute("bookingsList", bookingsList);

            // Chuyển tiếp đến trang UpdateBooking.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("ConfirmBooking.jsp");
            dispatcher.forward(request, response);

        } else if (method.equalsIgnoreCase("POST")) {
            // Lấy ID của booking cần xác nhận
            long id = Long.parseLong(request.getParameter("id")); 

            // Tìm booking theo ID
            Booking booking = BookingBO.getBookingById(id);
            if (booking != null) {
                // Cập nhật statusId thành 6 (Confirm)
                booking.setStatus_id(6);
                long tableId = Long.parseLong(request.getParameter("table_id")); //do cai nay 1 trong 2 th ok do thang nay á
          
                long statusId_TB = 2;
                updateTableStatus(tableId, statusId_TB);
                // Cập nhật trong cơ sở dữ liệu
                BookingBO.update(booking);

                // Điều hướng về trang danh sách booking
                response.sendRedirect("BookingController?action=index");
            } else {
                // Nếu không tìm thấy booking, hiển thị lỗi
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Không tìm thấy booking với ID: " + id);
            }
        }
    }
    private void cancel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getMethod();

        if (method.equalsIgnoreCase("GET")) {
            // Lấy danh sách tất cả các bàn từ database qua BO
            List<Long> tablesList = TablesBO.getAllTablesId();
            request.setAttribute("tablesList", tablesList);

            // Lấy danh sách tất cả các booking từ database qua BO
            List<Booking> bookingsList = BookingBO.getAllBookings();
            request.setAttribute("bookingsList", bookingsList);

            // Chuyển tiếp đến trang UpdateBooking.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateBooking.jsp");
            dispatcher.forward(request, response);

        } else if (method.equalsIgnoreCase("POST")) {
            // Lấy ID của booking cần xác nhận
            long id = Long.parseLong(request.getParameter("id"));

            // Tìm booking theo ID
            Booking booking = BookingBO.getBookingById(id);
            if (booking != null) {
                // Cập nhật statusId thành 6 (Confirm)
                booking.setStatus_id(7);

                // Cập nhật trong cơ sở dữ liệu
                BookingBO.update(booking);

                // Điều hướng về trang danh sách booking
                List<Booking> bookingsList = BookingBO.getAllBookings();
                request.setAttribute("bookingsList", bookingsList);

                // Chuyển đến trang ViewBookings.jsp để hiển thị danh sách booking
                RequestDispatcher dispatcher = request.getRequestDispatcher("HistoryBooking.jsp");
                dispatcher.forward(request, response);
            } else {
                // Nếu không tìm thấy booking, hiển thị lỗi
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Không tìm thấy booking với ID: " + id);
            }
        }
    }
    private void finish(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getMethod();

        if (method.equalsIgnoreCase("GET")) {
            // Lấy danh sách tất cả các bàn từ database qua BO
            List<Long> tablesList = TablesBO.getAllTablesId();
            request.setAttribute("tablesList", tablesList);

            // Lấy danh sách tất cả các booking từ database qua BO
            List<Booking> bookingsList = BookingBO.getAllBookings();
            request.setAttribute("bookingsList", bookingsList);

            // Chuyển tiếp đến trang UpdateBooking.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateBooking.jsp");
            dispatcher.forward(request, response);

        } else if (method.equalsIgnoreCase("POST")) {
            // Lấy ID của booking cần xác nhận
            long id = Long.parseLong(request.getParameter("id"));

            // Tìm booking theo ID
            Booking booking = BookingBO.getBookingById(id);
            if (booking != null) {
                // Cập nhật statusId thành 6 (Confirm)
                booking.setStatus_id(8);
                long tableId = Long.parseLong(request.getParameter("table_id"));
                long statusId_TB = 1;
                updateTableStatus(tableId, statusId_TB);
                // Cập nhật trong cơ sở dữ liệu
                BookingBO.update(booking);

                // Điều hướng về trang danh sách booking
                response.sendRedirect("BookingController?action=index");
            } else {
                // Nếu không tìm thấy booking, hiển thị lỗi
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Không tìm thấy booking với ID: " + id);
            }
        }
    }

}
