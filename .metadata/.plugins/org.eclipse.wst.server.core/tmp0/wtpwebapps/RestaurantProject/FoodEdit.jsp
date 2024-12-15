<%@ page import="Model.BEAN.Food"%>
<!DOCTYPE html>
<html lang="vi">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update Food Information</title>
<style>
/* Style to align labels and inputs inline */
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

input {
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
		<h2>Edit Food</h2>
		<form action="FoodController?action=edit" method="post">
			<div class="form-group">
				<label for="foodId">Food ID:</label> <input type="text" id="foodId"
					name="id" value="${food.id}" required readonly>
			</div>

			<div class="form-group">
				<label for="foodName">Name:</label> <input type="text" id="foodName"
					name="food" value="${food.food}" required>
			</div>

			<div class="form-group">
				<label for="foodPrice">Price:</label> <input type="text"
					id="foodPrice" name="price" value="${food.price}" required>
			</div>

			<div class="form-group">
				<label for="foodDescription">Description:</label> <input type="text"
					id="foodDescription" name="description" value="${food.description}"
					required>
			</div>

			<div class="form-group">
				<label for="foodStatus">Status ID:</label> <input type="text"
					id="foodStatus" name="statusId" value="${food.statusId}" required>
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

</html>
