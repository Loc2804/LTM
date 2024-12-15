package Model.BO;

import java.util.ArrayList;
import java.util.Random;

import Model.BEAN.Order;
import Model.BEAN.OrderFood;
import Model.DAO.OrderDAO;

public class OrderBO {

	public static void addOrder(Order order, String orderDetail) {
		long id = System.currentTimeMillis();
		order.setId(id);
		OrderDAO.addOrder(order);

		ArrayList<OrderFood> orderFood = new ArrayList<>();
		String[] itemOrderDetail = orderDetail.split(":");
		for (String item : itemOrderDetail) {
			// Chia chuỗi item theo dấu "-" để lấy foodId và quantity
			String[] foodnum = item.split("-");
			// Thêm OrderFood vào danh sách
			orderFood.add(new OrderFood(id, Long.parseLong(foodnum[0]), Integer.parseInt(foodnum[1])));
		}

		OrderFoodBO.addOrderFood(orderFood);
		String string = null;
	}

	// Cập nhật thông tin nhân viên
	public static void updateOrder(Order order) {
		OrderDAO.updateOrder(order);
	}

	// Xóa nhân viên theo ID
	public static void deleteOrder(Long id) {
		OrderDAO.deleteOrder(id);
	}

	// Tìm kiếm nhân viên theo cột và giá trị tìm kiếm
	public static ArrayList<Order> searchByCol(String searchBy, String searchString) {
		ArrayList<Order> orders = OrderDAO.searchByCol(searchBy, searchString);
		for (Order item : orders) {
			item.setTable(TablesBO.getTableById(item.getTableId()));
		}
		return orders;
	}

	// Lấy thông tin nhân viên theo ID
	public static Order getOrderById(Long id) {
		Order order = OrderDAO.getOrderById(id);
		order.setTable(TablesBO.getTableById(order.getTableId()));
		return order;

	}

	// Lấy danh sách tất cả nhân viên
	public static ArrayList<Order> getAllOrder() {
		ArrayList<Order> orders = OrderDAO.getAllOrder();
		for (Order item : orders) {
			item.setTable(TablesBO.getTableById(item.getTableId()));
		}
		return orders;
	}
}
