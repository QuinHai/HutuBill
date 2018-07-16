package com.quinhai.service;

import com.quinhai.dao.CategoryDAO;
import com.quinhai.dao.RecordDAO;
import com.quinhai.entity.*;
import java.util.*;

public class CategoryService {
	static CategoryDAO cdao = new CategoryDAO();
	static RecordDAO rdao = new RecordDAO();

	public List<Category> list() {
		List<Category> cs = cdao.getList();
		for (Category c : cs) {
			List<Record> rs = rdao.list(c.getId());
			c.setRecordNumber(rs.size());
		}
		Collections.sort(cs, (c1, c2) -> c2.getRecordNumber() - c1.getRecordNumber());

		return cs;
	}

	public void add(String name) {
		Category c = new Category();
		c.setName(name);
		cdao.add(c);
	}

	public void update(int id, String name) {
		Category c = new Category();
		c.setName(name);
		c.setId(id);
		cdao.update(c);
	}

	public void delete(int id) {
		cdao.delete(id);
	}
}
