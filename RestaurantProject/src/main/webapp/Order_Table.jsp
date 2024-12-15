<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Model.BEAN.Tables" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="Model.BEAN.User" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh Sách Bàn</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 20px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            background-color: #fff;
        }
        th, td {
            padding: 12px 15px;
            text-align: center;
        }
        th {
            background-color: #007BFF;
            color: white;
            text-transform: uppercase;
            font-size: 14px;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #d1e7fd;
        }
        td {
            font-size: 14px;
            color: #333;
        }
        a {
            text-decoration: none;
            color: white;
            background-color: #28a745;
            padding: 6px 12px;
            border-radius: 4px;
        }
        a.disabled {
            background-color: #ccc;
            cursor: not-allowed;
        }
        a:hover:not(.disabled) {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <h1>Danh Sách Bàn</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID Bàn</th>
                <th>Số Bàn</th>
                <th>Trạng Thái</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
        <%
            // Lấy thông tin người dùng từ session
            User user = (User) session.getAttribute("user");
            if (user == null) {
                out.println("<script>alert('Vui lòng đăng nhập!'); window.location.href='Login.jsp';</script>");
                return;
            }

            // Lấy ngày hiện tại
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String currentDate = sdf.format(new Date());

            List<Tables> list = (List<Tables>) request.getAttribute("tablesList");
            if (list != null) {
                for (Tables table : list) {
        %>
            <tr>
                <td><%= table.getId() %></td>
                <td><%= table.getNumber() %></td>
                <td><%= table.getStatus_id() == 1 ? "Còn Trống" : "Đã Đặt" %></td>
                <td>
                    <% if (table.getStatus_id() == 1) { %>
                        <!-- Form Đặt Bàn -->
                        <form action="BookingController?action=order" method="post">
                            <!-- Các input ẩn để truyền các tham số -->
                            <input type="hidden" name="user_id" value="<%= user.getId() %>">
                            <input type="hidden" name="table_id" value="<%= table.getId() %>">
                            <input type="hidden" name="status_id" value="5">
                            <input type="hidden" name="date" value="<%= currentDate %>">
                            <button type="submit">Đặt Bàn</button>
                        </form>
                    <% } else { %>
                        <!-- Vô hiệu hóa nút nếu bàn đã được đặt -->
                        <a class="disabled">Đã Đặt</a>
                    <% } %>
                </td>
            </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="4" style="text-align: center;">Không có dữ liệu</td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <a href="Index_Tables.jsp">Quay lại trang chủ</a>
</body>
</html>
