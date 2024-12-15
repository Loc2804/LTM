package Model.BO;

import java.util.ArrayList;

import Model.BEAN.Food;
import Model.BEAN.Status;
import Model.DAO.FoodDAO;

public class FoodBO {

	// Thêm mới một nhân viên
	public static void addFood(Food food) {
		FoodDAO.addFood(food);
	}

	// Cập nhật thông tin nhân viên
	public static void updateFood(Food food) {
		FoodDAO.updateFood(food);
	}

	// Xóa nhân viên theo ID
	public static void deleteFood(Long id) {
		FoodDAO.deleteFood(id);
	}

	// Tìm kiếm nhân viên theo cột và giá try tìm kiếm
	public static ArrayList<Food> searchByCol(String searchBy, String searchString) {
		ArrayList<Food> foods = FoodDAO.searchByCol(searchBy, searchString);
		for (Food item : foods) {
			item.setStatus((new StatusBO()).getStatusById(item.getStatusId()));
		}
		return foods;
	}

	// Lấy thông tin nhân viên theo ID
	public static Food getFoodById(Long id) {
		Food food = FoodDAO.getFoodById(id);
		food.setStatus((new StatusBO()).getStatusById(food.getStatusId()));
		return food;
	}

	// Lấy danh sách tất cả nhân viên
	public static ArrayList<Food> getAllFood() {
		ArrayList<Food> foods = FoodDAO.getAllFood();
		for (Food item : foods) {
			item.setStatus((new StatusBO()).getStatusById(item.getStatusId()));
		}
		return foods;
	}
}
