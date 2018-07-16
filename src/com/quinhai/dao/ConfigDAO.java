package com.quinhai.dao;

import java.util.List;

import com.quinhai.entity.Category;
import com.quinhai.entity.Config;
import com.quinhai.util.DAOUtil;

public class ConfigDAO extends DAOUtil {
	public Config getByKey(String key) {
		getConnection();
		session.beginTransaction();
		
		String hql = "FROM Config WHERE key_ = " + "'"+ key + "'";
		List<Config> c = (List<Config>) session.createQuery(hql).list();
		System.out.println(c.isEmpty() + " " + c);
		
		session.getTransaction().commit();
		session.close();
		if(!c.isEmpty()) {
			return c.get(0);
		}else {
			return null;
		}
	};

	public void delete(int id) {
		super.delete(id, Config.class);
	}

	public List<Config> getList() {
		return (List<Config>) super.getList(Config.class);
	}

	public Config getById(int id) {
		return (Config) getById(id, Config.class);
	};

	public int getTotal() {
		return super.getTotal(Config.class);
	};
}
