package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;

import Model.BEAN.Food;
import Model.BEAN.Order;
import Model.BEAN.OrderFood;
import Model.BEAN.Tables;
import Model.BO.FoodBO;
import Model.BO.OrderBO;
import Model.BO.OrderFoodBO;
import Model.BO.TablesBO;
import jakarta.servlet.RequestDispatcher;

@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "index":
			index(request, response);
			break;
		case "create":
			create(request, response);
			break;
		case "edit":
			edit(request, response);
			break;
		case "delete":
			delete(request, response);
			break;
		case "search":
			search(request, response);
			break;
		case "manager":
			manager(request, response);
			break;
		case "orderdetail":
			orderdetail(request, response);
			break;
		default:
			index(request, response);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "create":
			create(request, response);
			break;
		case "edit":
			edit(request, response);
			break;
		case "search":
			search(request, response);
			break;
		case "delete":
			delete(request, response);
			break;
		default:
			response.sendRedirect("OrderController?action=index");
			break;
		}
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Order> orderList = OrderBO.getAllOrder();
		request.setAttribute("orderList", orderList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("OrderIndex.jsp");
		dispatcher.forward(request, response);
	}

	private void manager(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Order> orderList = OrderBO.getAllOrder();
		request.setAttribute("orderList", orderList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("OrderManager.jsp");
		dispatcher.forward(request, response);
	}

	private void orderdetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		ArrayList<OrderFood> orderFoodList = OrderFoodBO.getOrderFoodByOrderId(id);
		Order order = OrderBO.getOrderById(id);
		request.setAttribute("orderFoodList", orderFoodList);
		request.setAttribute("order", order);
		RequestDispatcher dispatcher = request.getRequestDispatcher("OrderDetailManager.jsp");
		dispatcher.forward(request, response);
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();

		if (method.equalsIgnoreCase("GET")) {
			ArrayList<Food> foodList = FoodBO.getAllFood();
			ArrayList<Tables> tableList = (ArrayList<Tables>) TablesBO.getAllTables();
			request.setAttribute("foodList", foodList);
			request.setAttribute("tableList", tableList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("OrderCreate.jsp");
			dispatcher.forward(request, response);
		} else if (method.equalsIgnoreCase("POST")) {
			Long tableId = Long.parseLong(request.getParameter("tableId").trim());
			String payment = request.getParameter("payment").trim();
			Double total = Double.parseDouble(request.getParameter("total").trim());
			String orderDetail = request.getParameter("orderFood").trim();
			Order order = new Order(null, tableId, payment, total);
			OrderBO.addOrder(order, orderDetail);
			response.sendRedirect("FoodController?action=index");
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();

		if (method.equalsIgnoreCase("GET")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Order order = OrderBO.getOrderById(id);

			request.setAttribute("order", order);
			RequestDispatcher dispatcher = request.getRequestDispatcher("OrderEdit.jsp");
			dispatcher.forward(request, response);
		} else if (method.equalsIgnoreCase("POST")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Long tableId = Long.parseLong(request.getParameter("tableId"));
			String payment = request.getParameter("payment").trim();
			Double total = Double.parseDouble(request.getParameter("total").trim());

			Order order = new Order(id, tableId, payment, total);
			OrderBO.updateOrder(order);

			response.sendRedirect("OrderController?action=index");
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		OrderBO.deleteOrder(id);

		response.sendRedirect("OrderController?action=manager");
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();

		if (method.equalsIgnoreCase("GET")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("OrderSearch.jsp");
			dispatcher.forward(request, response);
		} else if (method.equalsIgnoreCase("POST")) {
			String searchBy = request.getParameter("searchBy");
			String searchString = request.getParameter("searchString");

			ArrayList<Order> orderList = OrderBO.searchByCol(searchBy, searchString);
			request.setAttribute("orderList", orderList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("OrderIndex.jsp");
			dispatcher.forward(request, response);
		}
	}
}
