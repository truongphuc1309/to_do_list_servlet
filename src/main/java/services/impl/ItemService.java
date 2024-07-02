package services.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import dao.IItemDAO;
import models.Item;
import services.IItemService;

public class ItemService implements IItemService {

	@Inject
	private IItemDAO itemDao;

	@Override
	public List<Item> findAllItem() {
		return itemDao.findAllItem();
	}

	@Override
	public Item addNewItem(String name) {
		Random rd = new Random();
		int rdNumber = rd.nextInt(1000);
		Date date = new Date();
		long timeMilli = date.getTime();
		
		String id = "" + timeMilli + rdNumber;
		
		return itemDao.addNewItem(name, id);
	}

	@Override
	public Item deleteOneItem(String id) {
		return itemDao.deleteOneItem(id);
	}

	@Override
	public Item updateOneItem(String id, String newName) {
		newName = newName.trim();
		if (!newName.equals("")) {
			return itemDao.updateOneItem(id, newName);
		}
		
		return null;
	}

}
