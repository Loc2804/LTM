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
        margin: 0;
        padding: 0;
        overflow: hidden;
    }
    h1{
    	text-align: center;
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
        
        .navbar {
        background-color: #007BFF; /* Màu xanh chủ đạo */
        overflow: hidden;
        display: flex;
        justify-content: space-between;
        padding: 10px 20px;
    }
    .navbar a {
        color: white;
        text-decoration: none;
        padding: 8px 16px;
        font-size: 16px;
    }
    .navbar a:hover {
        background-color: #0056b3; /* Màu xanh đậm hơn khi hover */
        border-radius: 4px;
    }
    .links {
        display: flex;
        gap: 20px;
    }
    .content {
        margin: 20px;
    }
    .content a {
        display: inline-block;
        background-color: #007BFF; /* Màu nền xanh chủ đạo */
        color: white;
        text-decoration: none;
        padding: 10px 20px;
        border-radius: 5px;
        margin: 5px 0;
        font-size: 18px;
    }
    .content a:hover {
        background-color: #0056b3; /* Màu nền xanh đậm hơn khi hover */
    }
    .btn-logout {
        background-color: #007BFF; /* Màu nền xanh chủ đạo */
        color: white; /* Màu chữ */
        text-decoration: none;
        padding: 10px 20px; /* Khoảng cách bên trong */
        border: none; /* Bỏ viền */
        border-radius: 5px; /* Bo góc */
        font-size: 18px; /* Kích thước chữ */
        cursor: pointer; /* Thay đổi con trỏ khi hover */
    }

    .btn-logout:hover {
        background-color: #0056b3; /* Màu nền xanh đậm hơn khi hover */
    }

    .btn-logout:focus {
        outline: none; /* Bỏ viền focus mặc định */
    }
    .group-btn{
    	margin-top:10px;
    }
    .welcome-user{
    	display: flex;
    	gap:20px;
    }
    .welcome-user span{
	color: white;
	margin-top:7px;
	font-size: 20px;
	}
	.return{
		margin: 0 auto;
		text-decoration: none;
		width: 200px;
		height:30px;
		background-color: #007BFF; /* Màu nền xanh chủ đạo */
		display:flex;
		justify-content: center;
		align-items: center;
		border-radius: 10px;
	}
	.return a{
		text-decoration: none;
		 color: white; /* Màu chữ */
	}
    </style>
</head>
<body>
	<%
        	User user = (User) session.getAttribute("user");
        	if(user == null || user.getRole() == null){
        %>
      <div class="navbar">
       <div class="links">
         	<a href="WelcomeUser.jsp">Home Page</a> 
          	<a href="MenuUser.jsp">Menu</a> 
           	<a href="OrderTable.jsp">Order Table</a>
       </div>
        <div class="group-btn">
            <a href="Login.jsp">Đăng nhập</a>
            <a href="Register.jsp">Đăng ký</a>
        </div>
     </div>
        <% }
        	else{
        %>
        <div class="navbar">
	       <div class="links">
	          	<a href="WelcomeUser.jsp">Home Page</a> 
          		<a href="MenuUser.jsp">Menu</a> 
           	<a href="TablesController?action=order">Order Table</a>
           	<a href="BookingController?action=history">Order History</a>


	       </div>
	        <form action="AuthController" method="post">
	        	<div class="welcome-user">
	        		<span>Xin chào, <%=user.getFullName() %></span>
	            	<button class="btn-logout" type="submit">Đăng xuất</button>
	            	<input  type="hidden" value="logout" name="action">
	        	</div>
	        </form>
        </div>
       <%
        	}
       %>
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
                        <form action="BookingController?action=order" method="post" onsubmit="return confirmBooking(this);">
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
    
    <div class="return">
      <a href="WelcomeUser.jsp" >Return</a>
    </div>
  
    <script>
        function confirmBooking(form) {
            // Hiển thị thông báo thành công
            alert("Đặt bàn thành công!");
            // Tiếp tục gửi form
            return true;
        }
    </script>
</body>
</html>
