package dao;

import java.util.List;

import models.Item;

public interface IItemDAO {
	Item findOneItemById (String id);
	List<Item> findAllItem ();
	Item addNewItem(String name, String id);
	Item deleteOneItem (String id);
	Item updateOneItem (String id, String newName);
}
