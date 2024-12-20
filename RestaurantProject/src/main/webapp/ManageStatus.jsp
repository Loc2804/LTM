<%@page import="Model.BEAN.Status"%>
<%@page import="java.util.List"%>
<%@page import="Model.BEAN.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Status</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<style>
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
}

h1, h2 {
    text-align: center;
    color: #0077b6;
}

a {
    text-decoration: none;
    color: white;
}

a:hover {
    background-color: #0056b3;
    border-radius: 4px;
}

button {
    cursor: pointer;
}

.navbar {
    background-color: #007BFF;
    display: flex;
    justify-content: space-between;
    padding: 10px 20px;
}

.navbar .links {
    display: flex;
    gap: 20px;
}

.navbar a {
    padding: 8px 16px;
    font-size: 16px;
}

.btn, .btn-logout {
    background-color: #007BFF;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    font-size: 18px;
}

.btn:hover, .btn-logout:hover {
    background-color: #0056b3;
}

.btn-logout:focus {
    outline: none;
}

.content {
    margin: 20px auto;
    width: 80%;
}

.form-container {
    background-color: #fff;
    padding: 30px;
    box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2);
    border-radius: 12px;
    width: 400px;
    margin: 20px auto;
}

label {
    font-weight: bold;
    display: block;
    margin-bottom: 8px;
}

.input-field, select {
    width: 100%;
    padding: 12px;
    margin: 8px 0 16px;
    border: 1px solid #ddd;
    border-radius: 8px;
    font-size: 14px;
}

.input-field:focus, select:focus {
    border-color: #0077b6;
    box-shadow: 0 0 5px rgba(0, 119, 182, 0.5);
    outline: none;
}

.form-buttons {
    display: flex;
    justify-content: space-between;
    margin-top: 20px;
}

/* Table */
.table-container {
    margin: 40px auto;
    width: 80%;
    border-collapse: collapse;
    text-align: left;
}

.table-container th, .table-container td {
    border: 1px solid #ccc;
    padding: 10px;
}

.table-container th {
    background-color:  #007BFF;
    color: white;
}

.action-icons {
    font-size: 18px;
    margin: 0 10px;
}

.action-icons.edit {
    color: #4CAF50;
}

.action-icons.delete {
    color: #FF5733;
}

.action-icons:hover {
    opacity: 0.7;
}

/* Responsive Design */
@media (max-width: 768px) {
    .form-container, .content {
        width: 90%;
        padding: 20px;
    }

    .btn {
        font-size: 14px;
        padding: 10px;
    }
}

.welcome-user span{
	color: white;
	font-size: 20px;
}

.btn-back{
	display:flex;
	align-items: center;
	justify-content: center;
	margin-bottom: 30px;
}

.icon-action{
	display: flex;
	
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
           <a href="WelcomeAdmin.jsp">Admin Page</a>
       </div>
        <div class="group-btn">
            <a href="Login.jsp">Đăng nhập</a>
            <a href="Register.jsp">Đăng ký</a>
        </div>
     </div>
     <div class="content">
       	<h1>Bạn cần đăng nhập để thực hiện chức năng này</h1>
   	</div>
        <% }
        	else{
        %>
        <div class="navbar">
	       <div class="links">
	           <a href="WelcomeUser.jsp">Home Page</a>
	           <a href="WelcomeAdmin.jsp">Admin Page</a>
	       </div>
	        <form action="AuthController" method="post">
	        	<div class="welcome-user">
	        		<span>Xin chào, <%=user.getFullName() %></span>
	            	<button class="btn-logout" type="submit">Đăng xuất</button>
	            	<input  type="hidden" value="logout" name="action">
	        	</div>
	        </form>
        </div>
        <div class="content">
       		<h1>Manage Status</h1>
   		</div>
   		<div class="form-container">
          <form action="StatusController" method="POST">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" class="input-field" placeholder="Enter status name" required onblur="checkName()">
			<input type="hidden" name="id_up"> 
            
			<button type="submit" class="btn btn-add" name="action" value="add">Thêm Mới</button>

            <button type="submit" class="btn btn-update" name="action" value="update">Cập Nhật</button>
            <button type="reset" class="btn btn-reset" onclick="resetForm()">Reset</button>
        </form>
    </div>
    <%
	    List<Status> list = (List<Status>) session.getAttribute("listStatus");
	    StringBuilder str = new StringBuilder();
	    str.append("[");
	    for (int i = 0; i < list.size(); i++) {
	        str.append("\"").append(list.get(i).getName()).append("\"");
	        if (i < list.size() - 1) {
	            str.append(", ");
	        }
	    }
	    str.append("]");
    %>
    <script type="text/javascript">
	    var existingUsername = <%= str.toString() %>;
	    function checkName() {
	    	
	        var idnv = document.getElementById('name').value;
	
	        if (existingUsername.includes(idnv)) {
	            alert("Status name existed !");
	
	            document.getElementById('name').value = "";
	            return false;  
	        }
	        return true; 
	    }
	</script>
   	<h2>List status</h2>
    <table class="table-container">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <% 
                if (list != null) {
                    for (Status u : list) {
            %>
            <tr>
                <td><%= u.getId() %></td>
                <td><%= u.getName() %></td>
                <td>
                	<div class="icon-action">
                		<button class="action-icons edit"  
                			onclick="fillInfo('<%= u.getId() %>','<%=u.getName() %>')"
                		>
                			<i class="fas fa-pencil-alt"></i>
                		</button>
                		<form action="StatusController" method="post">
                	    	<input type="hidden" name="deleteId" value="<%= u.getId() %>"> 
                			<button type="submit" value="delete" name="action" class="action-icons delete" onclick="setId('<%= u.getId() %>')"><i class="fas fa-trash-alt"></i></button>
                		</form>
                	</div>
                </td>
            </tr>
            <% 
                    }
                } else {
            %>
            <tr>
                <td colspan="3">Empty data</td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <div class="btn-back">
    	<a href="WelcomeAdmin.jsp"><button class="btn" >Return</button></a>
    </div>
    
	<script type="text/javascript">
		function fillInfo(id,name) {
			document.querySelector('input[name="id_up"]').value = id;
		 	document.querySelector('input[name="name"]').value = name;
		}
		function setId(id){
			document.querySelector('input[name="deleteId"]').value = id;
		}
		

	</script>
        <%
        	}
        %>
</body>
</html>