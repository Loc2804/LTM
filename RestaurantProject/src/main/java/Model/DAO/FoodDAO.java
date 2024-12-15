package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.BEAN.Food;

public class FoodDAO {

	// Thêm một nhân viên mới
	public static void addFood(Food food) {
		String query = String.format(
				"INSERT INTO food (food, price, description, status_id) VALUES ('%s', '%f', '%s', '%d')",
				food.getFood(), food.getPrice(), food.getDescription(), food.getStatusId());
		ExecuteDB(query);
	}

	// Cập nhật thông tin
	public static void updateFood(Food food) {
		String query = String.format(
				"UPDATE food SET food = '%s', price = '%f', description = '%s',status_id = '%d' WHERE id = '%d'",
				food.getFood(), food.getPrice(), food.getDescription(), food.getStatusId(), food.getId());
		ExecuteDB(query);
	}

	// Xóa nhân viên theo ID
	public static void deleteFood(Long id) {
		String query = String.format("DELETE FROM food WHERE id = '%d'", id);
		ExecuteDB(query);
	}

	// Tìm kiếm nhân viên theo cột và giá trị
	public static ArrayList<Food> searchByCol(String searchBy, String searchString) {
		String query = "";
		switch (searchBy) {
		case "id":
		case "price":
		case "status_id ": {
			query = String.format("SELECT * FROM food WHERE %s = '%s'", searchBy, searchString);
			break;
		}
		case "food":
		case "description": {
			query = String.format("SELECT * FROM food WHERE %s like '%%%s%%'", searchBy, searchString);
			break;
		}
		default:
			query = "SELECT * FROM Food";
		}

		return GetRecords(query);
	}

	// Lấy danh sách tất cả nhân viên
	public static ArrayList<Food> getAllFood() {
		String query = "SELECT * FROM Food";
		return GetRecords(query);
	}

	// Lấy thông tin nhân viên theo ID
	public static Food getFoodById(Long id) {
		String query = String.format("SELECT * FROM food WHERE id = '%d'", id);
		ArrayList<Food> foods = GetRecords(query);

		if (foods != null && !foods.isEmpty()) {
			return foods.get(0);
		} else {
			return null;
		}
	}

	// Phương thức kết nối cơ sở dữ liệu
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/restaurant"; // Thay bằng thông tin phù hợp
			String username = "root";
			String password = "";
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	// Thực thi truy vấn cơ sở dữ liệu
	public static int ExecuteDB(String query) {
		int status = 0;
		Connection connection = null;
		try {
			connection = FoodDAO.getConnection();

			Statement statement = connection.createStatement();

			status = statement.executeUpdate(query);

			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	// Lấy danh sách kết quả từ truy vấn
	public static ArrayList<Food> GetRecords(String query) {
		ArrayList<Food> list = new ArrayList<>();
		Connection connection = null;
		try {
			connection = FoodDAO.getConnection();

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String food = resultSet.getString("food");
				Double price = resultSet.getDouble("price");
				String description = resultSet.getString("description");
				Long status_id = resultSet.getLong("status_id");

				list.add(new Food(id, food, price, description, status_id));
			}

			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
