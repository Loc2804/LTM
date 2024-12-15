package Model.BO;

import java.util.ArrayList;

import Model.BEAN.Order;
import Model.BEAN.OrderFood;
import Model.DAO.OrderFoodDAO;

public class OrderFoodBO {

	// Thêm mới một nhân viên
	public static void addOrderFood(ArrayList<OrderFood> orderFoods) {
		for (OrderFood item : orderFoods) {
			OrderFoodDAO.addOrderFood(item);
		}
	}

	// Cập nhật thông tin nhân viên
	public static void updateOrderFood(OrderFood orderFood) {
		OrderFoodDAO.updateOrderFood(orderFood);
	}

	// Xóa nhân viên theo ID
	public static void deleteOrderFood(Long id) {
		OrderFoodDAO.deleteOrderFood(id);
	}

	// Tìm kiếm nhân viên theo cột và giá try tìm kiếm
	public static ArrayList<OrderFood> searchByCol(String searchBy, String searchString) {
		return OrderFoodDAO.searchByCol(searchBy, searchString);
	}

	// Lấy thông tin nhân viên theo ID
	public static OrderFood getOrderFoodById(Long id) {
		return OrderFoodDAO.getOrderFoodById(id);
	}

	// Lấy thông tin nhân viên theo ID
	public static ArrayList<OrderFood> getOrderFoodByOrderId(Long id) {

		ArrayList<OrderFood> orderFoods = OrderFoodDAO.getOrderFoodByOrderId(id);
		for (OrderFood itemFood : orderFoods) {
			itemFood.setFood(FoodBO.getFoodById(itemFood.getFoodId()));
			itemFood.setOrder(OrderBO.getOrderById(itemFood.getOrderId()));
		}
		return orderFoods;
	}

	// Lấy danh sách tất cả nhân viên
	public static ArrayList<OrderFood> getAllOrderFood() {
		return OrderFoodDAO.getAllOrderFood();
	}
}
