package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Model.BEAN.Role;
import Model.BEAN.Status;
import Model.BO.RoleBO;
import Model.BO.StatusBO;
import Model.BO.UserBO;

/**
 * Servlet implementation class RoleController
 */
@WebServlet("/RoleController")
public class RoleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleController() {
        super();
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
		String name = request.getParameter("name");
		String action = request.getParameter("action");
		
		RoleBO roleBO = new RoleBO();
		StatusBO statusBO = new StatusBO();
		UserBO bo = new UserBO();
		Role role = new Role();
		if(action.equals("add")) {
			role.setName(name);
			boolean check = roleBO.create(role);
			if(check) {
				request.getSession().setAttribute("listUser", bo.getAllUser());
				request.getSession().setAttribute("listRole", roleBO.getAllRole());
				request.getSession().setAttribute("listStatus", statusBO.getAllStatus());
    			RequestDispatcher rs = getServletContext().getRequestDispatcher("/ManageRole.jsp");
    			rs.forward(request, response);
			}
			else {
				 response.getWriter().println("False!");
			}
		}
		else if(action.equals("update")) {
			role.setName(name);
			long id = Long.parseLong(request.getParameter("id_up"));
			role.setId(id);
			boolean check = roleBO.update(role);
			if(check) {
				request.getSession().setAttribute("listUser", bo.getAllUser());
				request.getSession().setAttribute("listRole", roleBO.getAllRole());
				request.getSession().setAttribute("listStatus", statusBO.getAllStatus());
    			RequestDispatcher rs = getServletContext().getRequestDispatcher("/ManageRole.jsp");
    			rs.forward(request, response);
			}
			else {
				 response.getWriter().println("False!");
			}
		}
		else if(action.equals("delete")) {
			long id = Long.parseLong(request.getParameter("deleteId"));
			boolean check = roleBO.delete(id);
			if(check) {
				request.getSession().setAttribute("listUser", bo.getAllUser());
				request.getSession().setAttribute("listRole", roleBO.getAllRole());
				request.getSession().setAttribute("listStatus", statusBO.getAllStatus());
    			RequestDispatcher rs = getServletContext().getRequestDispatcher("/ManageRole.jsp");
    			rs.forward(request, response);
			}
			else {
				 response.getWriter().println("False!");
			}
		}
	}

}
