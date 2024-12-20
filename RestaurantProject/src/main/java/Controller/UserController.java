package Controller;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.BEAN.Role;
import Model.BEAN.User;
import Model.BO.RoleBO;
import Model.BO.StatusBO;
import Model.BO.UserBO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullName = request.getParameter("fullName");
		String phonenumber = request.getParameter("phonenumber");
		String address = request.getParameter("address");	
		int age = 0;
		int role_id = request.getParameter("role") == null ? 0 : Integer.parseInt(request.getParameter("role"));
		String action = request.getParameter("action");
		
		RoleBO roleBO = new RoleBO();
		StatusBO statusBO = new StatusBO();
		
		User user = new User();
		Role role = roleBO.getRoleById(role_id);
		UserBO bo = new UserBO();
		if(action.equals("add")) {
			age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender").equals("male") ? "Nam" : "Nữ";
			user.setFullName(fullName); user.setGender(gender); user.setPassword(password);
			user.setAddress(address); user.setPhonenumber(phonenumber);
			user.setAge(age); user.setPassword(password);
			user.setUsername(username); user.setRole(role);
			boolean check = bo.create(user);
			if(check) {
				String name = bo.getUserByUsername(username).getFullName();
				User userNew = bo.getUserByUsername(username);
				request.getSession().setAttribute("listUser", bo.getAllUser());
				request.getSession().setAttribute("listRole", roleBO.getAllRole());
				request.getSession().setAttribute("listStatus", statusBO.getAllStatus());
    			RequestDispatcher rs = getServletContext().getRequestDispatcher("/ManageUser.jsp");
    			rs.forward(request, response);
			}
			else {
				 response.getWriter().println("False!");
			}
		}
		else if(action.equals("update")) {
			age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender").equals("male") ? "Nam" : "Nữ";
			long id = Long.parseLong(request.getParameter("id_up"));
			user.setFullName(fullName); user.setGender(gender); user.setPassword(password);
			user.setAddress(address); user.setPhonenumber(phonenumber); user.setId(id);
			user.setAge(age); user.setPassword(password);
			user.setUsername(username); user.setRole(role);		
			boolean check = bo.update(user);
			if(check) {
				String name = bo.getUserByUsername(username).getFullName();
				User userNew = bo.getUserByUsername(username);
				request.getSession().setAttribute("listUser", bo.getAllUser());
				request.getSession().setAttribute("listRole", roleBO.getAllRole());
				request.getSession().setAttribute("listStatus", statusBO.getAllStatus());
    			RequestDispatcher rs = getServletContext().getRequestDispatcher("/ManageUser.jsp");
    			rs.forward(request, response);
			}
			else {
				 response.getWriter().println("False!");
			}
		}
		else if(action.equals("delete")) {
			long id = Long.parseLong(request.getParameter("deleteId"));
			boolean check = bo.delete(id);
			if(check) {
				request.getSession().setAttribute("listUser", bo.getAllUser());
				request.getSession().setAttribute("listRole", roleBO.getAllRole());
				request.getSession().setAttribute("listStatus", statusBO.getAllStatus());
    			RequestDispatcher rs = getServletContext().getRequestDispatcher("/ManageUser.jsp");
    			rs.forward(request, response);
			}
			else {
				 response.getWriter().println("False!");
			}
		}

	}

}
