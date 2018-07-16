package com.quinhai.dao;

import java.util.List;

import com.quinhai.entity.Category;
import com.quinhai.util.DAOUtil;

public class CategoryDAO extends DAOUtil{

	public void delete(int id) {
		super.delete(id, Category.class);
	}
	
	public List<Category> getList() {
		return (List<Category>) super.getList(Category.class);
	}
	
	public Category getById(int id) {
		return (Category)getById(id, Category.class);
	};
	
	public int getTotal() {
		return super.getTotal(Category.class);
	};
}
