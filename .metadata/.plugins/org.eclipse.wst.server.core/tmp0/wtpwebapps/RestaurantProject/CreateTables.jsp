<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="Model.BEAN.Tables"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Bàn</title>
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
        .form-container {
            width: 80%;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        .form-container label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            color: #333;
        }
        .form-container input,
        .form-container select {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
        }
        .form-container input[type="submit"],
        .form-container input[type="reset"] {
            background-color: #007BFF;
            color: white;
            border: none;
            padding: 10px 15px;
            margin-right: 10px;
            border-radius: 4px;
            cursor: pointer;
        }
        .form-container input[type="submit"]:hover,
        .form-container input[type="reset"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Thêm Bàn</h1>
    <div class="form-container">
        <form action="TablesController?action=create" method="post" onsubmit="return validateForm()">
            <label for="id">ID Bàn:</label>
            <input type="text" id="id" name="id" onblur="checkTableId()" required placeholder="Nhập ID bàn">

            <label for="number">Số Bàn:</label>
            <input type="text" id="number" name="number" required placeholder="Nhập số bàn">

            <label for="status_id">Trạng Thái:</label>
			<select id="status_id" name="status_id" required>
			    <option value="" disabled selected>Chọn trạng thái</option>
			    <option value="1">Còn Trống</option>
			    <option value="2">Đã Được Đặt</option>
			</select>

            

            <input type="submit" value="Thêm">
            <input type="reset" value="Reset">
        </form>
    </div>

    <script>
        // Kiểm tra dữ liệu nhập vào
        function validateForm() {
            const id = document.getElementById('id').value.trim();
            const number = document.getElementById('number').value.trim();
            const status = document.getElementById('status_id').value.trim();

            if (!id || !number || !status) {
                alert("Vui lòng điền đầy đủ thông tin!");
                return false;
            }

            // Thêm kiểm tra nếu cần
            return true;
        }
    </script>

    <script>
        // Chuyển danh sách bàn từ server sang JSON
        const tablesList = [
            <% List<Tables> tablesList = (List<Tables>) request.getAttribute("tablesList");
               for (Tables table : tablesList) { %>
                {
                    ID: "<%=table.getId()%>",
                    Number: "<%=table.getNumber()%>",
                    Status: "<%=table.getStatus_id()%>"
                }<% if (!table.equals(tablesList.get(tablesList.size() - 1))) { %>,<% } %>
            <% } %>
        ];

        // Hàm kiểm tra trùng lặp ID bàn
        function checkTableId() {
            const tableIdInput = document.getElementById("id").value.trim();
            const isDuplicate = tablesList.some(table => table.ID === tableIdInput);

            if (isDuplicate) {
                alert("ID bàn đã tồn tại!");
                return false;
            }
            return true;
        }
    </script>
</body>
</html>
