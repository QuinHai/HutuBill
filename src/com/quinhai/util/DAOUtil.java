package com.quinhai.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.quinhai.entity.Config;

public class DAOUtil {

	protected Session session;

	protected void getConnection() {
		session = DBUtil.getConnection();
	}
	
	public void add(Object obj) {
		getConnection();
		session.beginTransaction();
		
		session.save(obj);
		
		session.getTransaction().commit();
		session.close();
	};

	public void update(Object obj) {
		getConnection();
		session.beginTransaction();

		session.update(obj);

		session.getTransaction().commit();
		session.close();
	};

	public int getTotal(Class objClass) {
		List<?> list = getList(objClass);
		return list.size();
	};

	public void delete(int id, Class objClass) {
		getConnection();
		session.beginTransaction();

		session.delete(session.get(objClass, id));

		session.getTransaction().commit();
		session.close();
	}

	public List<?> getList(Class objClass) {
		getConnection();
		List<?> list = new ArrayList<>();

		String objName = objClass.getName();
		int i;
		for (i = objName.length()-1; i >= 0; i--)
			if (objName.charAt(i) == '.')
				break;

		String tableName = objName.substring(i+1);
		System.out.println(tableName);

		String hql = "FROM " + tableName;
		list = session.createQuery(hql).list();

		session.close();
		return list;
	};

	public Object getById(int id, Class objClass) {
		getConnection();
		return session.get(objClass, id);
	};

}
