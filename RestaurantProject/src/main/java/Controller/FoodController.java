package Controller;

import java.io.IOException;
import java.util.ArrayList;

import Model.BEAN.Food;
import Model.BO.FoodBO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FoodController")
public class FoodController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FoodController() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "index":
			index(request, response);
			break;
		case "manager":
			manager(request, response);
			break;
		case "create":
			create(request, response);
			break;
		case "edit":
			edit(request, response);
			break;
		case "delete":
			delete(request, response);
			break;
		case "search":
			search(request, response);
			break;
		default:
			index(request, response);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "create":
			create(request, response);
			break;
		case "edit":
			edit(request, response);
			break;
		case "search":
			search(request, response);
			break;
		case "delete":
			delete(request, response);
			break;
		default:
			response.sendRedirect("FoodController?action=index");
			break;
		}
	}

	// Hiển thị danh sách nhân viên
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Food> foodList = FoodBO.getAllFood();
		request.setAttribute("foodList", foodList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FoodMenuStaff.jsp");
		dispatcher.forward(request, response);
	}

	// Hiển thị danh sách nhân viên
	private void manager(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Food> foodList = FoodBO.getAllFood();
		request.setAttribute("foodList", foodList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FoodManager.jsp");
		dispatcher.forward(request, response);
	}

	// Thêm Food mới
	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();

		if (method.equalsIgnoreCase("GET")) {
			// Lấy danh sách tất cả các món ăn
			ArrayList<Food> foodList = FoodBO.getAllFood();
			request.setAttribute("foodList", foodList);

			// Chuyển hướng đến trang FoodCreate.jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher("FoodCreate.jsp");
			dispatcher.forward(request, response);
		} else if (method.equalsIgnoreCase("POST")) {
			// Lấy dữ liệu từ form
			Long id = Long.parseLong(request.getParameter("id").trim());
			String foodName = request.getParameter("food").trim();
			Double price = Double.parseDouble(request.getParameter("price").trim());
			String description = request.getParameter("description").trim();
			Long statusId = Long.parseLong(request.getParameter("statusId").trim());

			// Tạo đối tượng Food
			Food food = new Food(id, foodName, price, description, statusId);

			// Gọi lớp xử lý nghiệp vụ để thêm món ăn
			FoodBO.addFood(food);

			// Chuyển hướng về trang danh sách
			response.sendRedirect("FoodController?action=manager");
		}
	}

	// Sửa thông tin nhân viên
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();

		if (method.equalsIgnoreCase("GET")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Food food = FoodBO.getFoodById(id);

			request.setAttribute("food", food);
			RequestDispatcher dispatcher = request.getRequestDispatcher("FoodEdit.jsp");
			dispatcher.forward(request, response);
		} else if (method.equalsIgnoreCase("POST")) {
			Long id = Long.parseLong(request.getParameter("id"));
			String food1 = request.getParameter("food").trim();
			Double price = Double.parseDouble(request.getParameter("price"));
			String description = request.getParameter("description").trim();
			Long statusId = Long.parseLong(request.getParameter("statusId"));

			Food food = new Food(id, food1, price, description, statusId);
			FoodBO.updateFood(food);

			response.sendRedirect("FoodController?action=manager");
		}
	}

	// Xóa nhân viên
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		FoodBO.deleteFood(id);

		response.sendRedirect("FoodController?action=manager");
	}

	// Tìm kiếm nhân viên
	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();

		if (method.equalsIgnoreCase("GET")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("FoodSearch.jsp");
			dispatcher.forward(request, response);
		} else if (method.equalsIgnoreCase("POST")) {
			String searchBy = request.getParameter("searchBy");
			String searchString = request.getParameter("searchString");

			ArrayList<Food> foodList = FoodBO.searchByCol(searchBy, searchString);
			request.setAttribute("foodList", foodList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("FoodIndex.jsp");
			dispatcher.forward(request, response);
		}
	}

}
