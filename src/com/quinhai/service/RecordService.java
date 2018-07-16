package com.quinhai.service;

import java.util.Date;

import com.quinhai.dao.RecordDAO;
import com.quinhai.entity.Category;
import com.quinhai.entity.Record;


public class RecordService {
	static RecordDAO rdao = new RecordDAO();

	public void add(int spend, Category c, String comment, Date date) {
		Record r = new Record();
		r.setSpend(spend);
		r.setCid(c.getId());
		r.setComment(comment);
		r.setDate(date);
		rdao.add(r);
	}


}
