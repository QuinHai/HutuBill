package com.quinhai.service;

import org.hibernate.Session;

import com.quinhai.dao.ConfigDAO;
import com.quinhai.entity.Config;
import com.quinhai.util.DBUtil;

public class ConfigService {
	public static final String budget = "budget";
	public static final String mysqlPath = "mysqlPath";
	public static final String default_budget = "500";

	static ConfigDAO dao = new ConfigDAO();

	static {
		init();
	}

	private static void init(String key, String value) {
		Config config = dao.getByKey(key);
		if (config == null) {
			Config c = new Config();
			c.setKey_(key);
			c.setValue(value);
			dao.add(c);
		}
	}

	public static void init() {
		init(budget, default_budget);
		init(mysqlPath, "");
	}

	public String get(String key) {
		return dao.getByKey(key).getValue();
	}

	public void update(String key, String value) {
		Config config = dao.getByKey(key);
		config.setValue(value);
		dao.update(config);
	}

	public int getIntBudget() {
		return Integer.parseInt(get("budget"));
	}
}
