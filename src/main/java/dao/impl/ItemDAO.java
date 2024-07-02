package dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.DAOAbstract;
import dao.IItemDAO;
import models.Item;

public class ItemDAO extends DAOAbstract implements IItemDAO {
	@Override
	public Item findOneItemById (String id) {
		Connection con = getConnection();
		Item result = null;

		if (con != null) {
			String query = "SELECT * FROM item WHERE id=?";
			try {
				PreparedStatement preSt = con.prepareStatement(query);
				preSt.setString(1, id);
		
				ResultSet rs = preSt.executeQuery();
				while (rs.next()) {
					id = rs.getString("id");
					String name = rs.getString("name");
					result = new Item(id, name);
				}
				
				con.close();
				preSt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return result;
	}
	
	
	@Override
	public List<Item> findAllItem() {
		List<Item> result = new ArrayList<Item>();
		Connection con = getConnection();

		if (con != null) {
			String query = "SELECT * FROM item";
			try {
				PreparedStatement preSt = con.prepareStatement(query);
				ResultSet rs = preSt.executeQuery();

				while (rs.next()) {
					String id = rs.getString("id");
					String name = rs.getString("name");
					Item item = new Item(id, name);
					result.add(item);
				}
				return result;
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return null;
	}

	@Override
	public Item addNewItem(String name, String id) {
		Connection con = getConnection();
		Item result = null;

		if (con != null) {
			String query = "INSERT INTO `item`(`name`, `id`) VALUES (? ,?)";
			try {
				PreparedStatement preSt = con.prepareStatement(query);
				preSt.setString(1, name);
				preSt.setString(2, id);
				if (preSt.executeUpdate() > 0) result = new Item(id, name);
				
				con.close();
				preSt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return result;
	}

	@Override
	public Item deleteOneItem(String id) {
		Connection con = getConnection();
		Item result = null;
		Item temp = findOneItemById(id);

		if (con != null) {
			String query = "DELETE FROM `item` WHERE id = ?";
			try {
				PreparedStatement preSt = con.prepareStatement(query);
				preSt.setString(1, id);
				
				if (preSt.executeUpdate() > 0) result = temp;
				con.close();
				preSt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return result;
	}

	@Override
	public Item updateOneItem(String id, String newName) {
		Connection con = getConnection();
		Item result = null;

		if (con != null) {
			String query = "UPDATE `item` SET `name`=? WHERE `id`=?";
			try {
				PreparedStatement preSt = con.prepareStatement(query);
				preSt.setString(1, newName);
				preSt.setString(2, id);
				
				if (preSt.executeUpdate() > 0) result = new Item(id, newName);
				con.close();
				preSt.close();

				return result;
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return result;
	}

}
