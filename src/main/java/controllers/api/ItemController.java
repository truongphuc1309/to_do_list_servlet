package controllers.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Item;
import services.IItemService;
import utils.IReaderUtil;

@WebServlet(urlPatterns = {"/api"})
public class ItemController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IItemService itemService;
	
	@Inject
	private IReaderUtil readerUtil;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		List<Item> result = itemService.findAllItem();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(res.getOutputStream(), result);
	}
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		
		Item body =  readerUtil.<Item>reflectObject(req.getReader(), Item.class);
		Item result = itemService.addNewItem(body.getName());
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(res.getOutputStream(), result);
	}
	
	@Override 
	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		
		ObjectMapper mapper = new ObjectMapper();
		Item body =  readerUtil.<Item>reflectObject(req.getReader(), Item.class);
		Item result = itemService.updateOneItem(body.getId(), body.getName());
		mapper.writeValue(res.getOutputStream(), result);
	}
	
	@Override 
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		
		ObjectMapper mapper = new ObjectMapper();
		Item body =  readerUtil.<Item>reflectObject(req.getReader(), Item.class);
		Item result = itemService.deleteOneItem(body.getId());
		mapper.writeValue(res.getOutputStream(), result);
	}

}




