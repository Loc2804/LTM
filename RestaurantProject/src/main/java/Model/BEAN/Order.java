package Model.BEAN;

public class Order {
	private Long id;
	private Long tableId;
	private String payment;
	private Double total;

	private Tables table;

	// Constructor mặc định
	public Order() {
	}

	// Constructor có tham số
	public Order(Long id, Long tableId, String payment, Double total) {
		this.id = id;
		this.tableId = tableId;
		this.payment = payment;
		this.total = total;
	}

	// Getter và Setter cho id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// Getter và Setter cho tableId
	public Long getTableId() {
		return tableId;
	}

	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}

	// Getter và Setter cho payment
	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	// Getter và Setter cho total
	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	// Getter và Setter cho table
	public Tables getTable() {
		return table;
	}

	public void setTable(Tables table) {
		this.table = table;
	}
}
