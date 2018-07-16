package com.quinhai.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.query.Query;

import com.quinhai.entity.Category;
import com.quinhai.entity.Record;
import com.quinhai.util.DAOUtil;
import com.quinhai.util.DateUtil;

public class RecordDAO extends DAOUtil{
	public void delete(int id) {
		super.delete(id, Record.class);
	}
	
	public List<?> getList() {
		return super.getList(Record.class);
	}
	
	public Record getById(int id) {
		return (Record)getById(id, Record.class);
	};
	
	public int getTotal() {
		return super.getTotal(Record.class);
	};
	
	public List<Record> list(int cid) {
		getConnection();
		
		String hql = "FROM Record WHERE cid = " + cid;
		List<Record> data = (List<Record>)session.createQuery(hql).list();
		
		session.close();
		return data;
	}
	
    public List<Record> list(Date day) {
    	getConnection();
    	
    	String hql = "FROM Record WHERE date = '" + day + "'";
    	List<Record> data = (List<Record>)session.createQuery(hql).list();
    	
    	session.close();
		return data;
    }
    
    public List<Record> list(Date start, Date end) {
    	getConnection();
    	
    	String hql = "FROM Record WHERE date >= ?1 AND date <= ?2";
    	Query<?> q = session.createQuery(hql);
    	q.setParameter(1, start);
    	q.setParameter(2, end);
    	
    	List<Record> data = (List<Record>)q.list();
    	
    	session.close();
    	return data;
    }
    
    public List<Record> listThisMonth(){
    	return list(DateUtil.monthBegin(),DateUtil.monthEnd());
    }

    public List<Record> listToday(){
        return list(DateUtil.today());
    }
}
