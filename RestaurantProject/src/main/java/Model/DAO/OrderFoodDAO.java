package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.BEAN.OrderFood;

public class OrderFoodDAO {

	// Thêm một nhân viên mới
	public static void addOrderFood(OrderFood orderFood) {
		String query = String.format("INSERT INTO order_food (order_id, food_id , number) VALUES ( '%d', '%d', '%d')",
				orderFood.getOrderId(), orderFood.getFoodId(), orderFood.getNumber());
		ExecuteDB(query);
	}

	// Cập nhật thông tin
	public static void updateOrderFood(OrderFood orderFood) {
		String query = String.format(
				"UPDATE order_food SET order_id = '%d', food_id = '%d', number = '%d' WHERE id = '%d'",
				orderFood.getOrderId(), orderFood.getFoodId(), orderFood.getNumber(), orderFood.getId());
		ExecuteDB(query);
	}

	// Xóa nhân viên theo ID
	public static void deleteOrderFood(Long id) {
		String query = String.format("DELETE FROM order_food WHERE id = '%d'", id);
		ExecuteDB(query);
	}

	// Tìm kiếm nhân viên theo cột và giá trị
	public static ArrayList<OrderFood> searchByCol(String searchBy, String searchString) {
		String query = "";
		switch (searchBy) {
		case "id": {
			query = String.format("SELECT * FROM order_food WHERE %s = '%s'", searchBy, searchString);
			break;
		}
		default:
			query = "SELECT * FROM order_food";
		}

		return GetRecords(query);
	}

	// Lấy danh sách tất cả nhân viên
	public static ArrayList<OrderFood> getAllOrderFood() {
		String query = "SELECT * FROM order_food";
		return GetRecords(query);
	}

	// Lấy thông tin nhân viên theo ID
	public static OrderFood getOrderFoodById(Long id) {
		String query = String.format("SELECT * FROM order_food WHERE id = '%d'", id);
		ArrayList<OrderFood> orderfoods = GetRecords(query);

		if (orderfoods != null && !orderfoods.isEmpty()) {
			return orderfoods.get(0);
		} else {
			return null;
		}
	}

	public static ArrayList<OrderFood> getOrderFoodByOrderId(Long id) {
		String query = String.format("SELECT * FROM order_food WHERE order_id = '%d'", id);
		ArrayList<OrderFood> orderfoods = GetRecords(query);
		return orderfoods;
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
	public static ArrayList<OrderFood> GetRecords(String query) {
		ArrayList<OrderFood> list = new ArrayList<>();
		Connection connection = null;
		try {
			connection = FoodDAO.getConnection();

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				Long order_id = resultSet.getLong("order_id");
				Long food_id = resultSet.getLong("food_id");
				int number = resultSet.getInt("number");

				list.add(new OrderFood(id, order_id, food_id, number));
			}

			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
