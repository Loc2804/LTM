<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="Model.BEAN.Food"%>
<!DOCTYPE html>
<html lang="vi">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Thêm Food</title>
<style>
form {
	max-width: 400px;
}

.form-group {
	display: flex;
	align-items: center;
	justify-content: center;
	margin-bottom: 10px;
}

label {
	width: 120px;
	margin-right: 10px;
}

input, select {
	flex: 1;
	padding: 5px;
}

button {
	margin-right: 10px;
}

.contain {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	margin-bottom: 10px;
}
</style>
</head>

<body>
	<div class="contain">
		<h2>Thêm Food</h2>
		<form action="FoodController?action=create" method="post"
			onsubmit="return checkFoodId()">

			<div class="form-group">
				<label for="foodId">Mã Food:</label> <input type="text" id="foodId"
					name="id" required onblur="checkFoodId()">
			</div>

			<div class="form-group">
				<label for="foodName">Tên Food:</label> <input type="text"
					id="foodName" name="food" required>
			</div>

			<div class="form-group">
				<label for="price">Giá:</label> <input type="number" id="price"
					name="price" step="0.01" required>
			</div>

			<div class="form-group">
				<label for="description">Mô Tả:</label> <input type="text"
					id="description" name="description" required>
			</div>

			<div class="form-group">
				<label for="statusId">Mã Trạng Thái:</label> <input type="number"
					id="statusId" name="statusId" required>
			</div>

			<div class="form-group">
				<button type="submit">OK</button>
				<button type="reset">Reset</button>
			</div>
		</form>
	</div>
	<h2>
		<a href="FoodController?action=index">Back</a>
	</h2>
</body>

<script>
    // Danh sách food lấy từ server (JSON format)
    const foodList = [
        <%List<Food> foodList = (List<Food>) request.getAttribute("foodList");
if (foodList != null) {
	for (Food food : foodList) {%>
                {
                    id: "<%=food.getId()%>",
                    food: "<%=food.getFood()%>",
                    price: <%=food.getPrice()%>,
                    description: "<%=food.getDescription()%>",
                    statusId: <%=food.getStatusId()%>
                }<%if (!food.equals(foodList.get(foodList.size() - 1))) {%>,<%}%>
        <%}
}%>
    ];

    // Hàm kiểm tra trùng lặp ID của Food
    function checkFoodId() {
        const foodIdInput = document.getElementById("foodId").value.trim();
        const isDuplicate = foodList.some(food => food.id === foodIdInput);

        if (isDuplicate) {
            alert("Mã Food đã tồn tại!");
            return false;
        }
        return true;
    }
</script>

</html>
