package services;

import java.util.List;

import models.Item;

public interface IItemService {
	List<Item> findAllItem ();
	Item addNewItem (String name);
	Item deleteOneItem (String id);
	Item updateOneItem (String id, String newName);
}
