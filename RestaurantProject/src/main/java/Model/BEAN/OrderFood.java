package Model.BEAN;

import javax.management.loading.PrivateClassLoader;

public class OrderFood {
	private Long id;
	private Long orderId;
	private Long foodId;
	private int number;
	private Food food;
	private Order order;

	public OrderFood() {

	}

	public OrderFood(Long id, Long orderId, Long foodId, int number) {
		this.id = id;
		this.orderId = orderId;
		this.foodId = foodId;
		this.number = number;
	}

	public OrderFood(Long orderId, Long foodId, int number) {
		this.orderId = orderId;
		this.foodId = foodId;
		this.number = number;
	}

	// Getter and Setter for orderId
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// Getter and Setter for orderId
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	// Getter and Setter for foodId
	public Long getFoodId() {
		return foodId;
	}

	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}

	// Getter and Setter for number
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	// Getter and Setter for Food
	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	// Getter and Setter for Order
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
