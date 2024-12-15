package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Model.BEAN.Order;

public class OrderDAO {

	// Thêm một đơn hàng mới
	public static void addOrder(Order order) {
		String query = String.format("INSERT INTO orders (id, table_id, payment, total) VALUES ('%d','%d', '%s', '%f')",
				order.getId(), order.getTableId(), order.getPayment(), order.getTotal());
		ExecuteDB(query);
	}

	// Cập nhật thông tin đơn hàng
	public static void updateOrder(Order order) {
		String query = String.format("UPDATE orders SET table_id = '%d', payment = '%s', total = '%f' WHERE id = '%d'",
				order.getTableId(), order.getPayment(), order.getTotal(), order.getId());
		ExecuteDB(query);
	}

	// Xóa đơn hàng theo ID
	public static void deleteOrder(Long id) {
		String query = String.format("DELETE FROM orders WHERE id = '%d'", id);
		ExecuteDB(query);
	}

	// Tìm kiếm đơn hàng theo cột và giá trị
	public static ArrayList<Order> searchByCol(String searchBy, String searchString) {
		String query = "";
		switch (searchBy) {
		case "id":
		case "table_id":
		case "total": {
			query = String.format("SELECT * FROM orders WHERE %s = '%s'", searchBy, searchString);
			break;
		}
		case "payment": {
			query = String.format("SELECT * FROM orders WHERE %s LIKE  '%%%s%%'", searchBy, searchString);
			break;
		}
		default:
			query = "SELECT * FROM orders";
		}
		return GetRecords(query);
	}

	// Lấy danh sách tất cả đơn hàng
	public static ArrayList<Order> getAllOrder() {
		String query = "SELECT * FROM orders";
		return GetRecords(query);
	}

	// Lấy thông tin đơn hàng theo ID
	public static Order getOrderById(Long id) {
		String query = String.format("SELECT * FROM orders WHERE id = '%d'", id);
		ArrayList<Order> orders = GetRecords(query);

		if (orders != null && !orders.isEmpty()) {
			return orders.get(0);
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
			connection = getConnection();

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
	public static ArrayList<Order> GetRecords(String query) {
		ArrayList<Order> list = new ArrayList<>();
		Connection connection = null;
		try {
			connection = getConnection();

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				Long table_id = resultSet.getLong("table_id");
				String payment = resultSet.getString("payment");
				Double total = resultSet.getDouble("total");

				list.add(new Order(id, table_id, payment, total)); // Truyền null cho statusId
			}

			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
