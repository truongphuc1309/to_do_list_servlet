package controllers.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Item;
import services.IItemService;

@WebServlet(urlPatterns = { "/home" })

public class ItemController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private IItemService itemService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action == null) {
			List<Item> metaData = itemService.findAllItem();
			req.setAttribute("metaData", metaData);
			RequestDispatcher rd = req.getRequestDispatcher("/views/index.jsp");
			rd.forward(req, res);
		} else if (action.equals("delete")) {
			String id = req.getParameter("id");
			itemService.deleteOneItem(id);
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req, res);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		String action = req.getParameter("action");
		if (action == null) {
			String name = req.getParameter("name");
			itemService.addNewItem(name);
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req, res);
		} else if (action.equals("update")) {
			String id = req.getParameter("id");
			String newName = req.getParameter("name");
			itemService.updateOneItem(id, newName);
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req, res);

		}
	}
}
