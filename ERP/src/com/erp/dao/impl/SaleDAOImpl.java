package com.erp.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.erp.dao.SaleDAO;
import com.erp.pojo.Sale;

public class SaleDAOImpl implements SaleDAO {
	
	final int pageSize = 8;
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Sale doIns(Sale pojo) {
		Sale sale = null;
		Session  session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(pojo);
			
			session.getTransaction().commit();
			sale = this.findBySaleId(pojo.getSaleId());;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return sale;
	}

	@Override
	public boolean doDel(Long saleId) {
		boolean flag = false;
		Session  session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();
			Sale pojo = (Sale) session.get(Sale.class, saleId);
			pojo.setSaleDel(1);
			session.getTransaction().commit();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return flag;
	}

	@Override
	public boolean doBack(Long saleId) {
		boolean flag = false;
		Session  session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();
			Sale pojo = (Sale) session.get(Sale.class, saleId);
			pojo.setSaleDel(0);
			session.getTransaction().commit();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return flag;
	}
	
	@Override
	public boolean doUpd(Sale pojo) {
		boolean flag = false;
		Session  session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(pojo);
			session.getTransaction().commit();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return flag;
	}

	@Override
	public Sale findBySaleId(long saleId) {
		Sale sale = null;
		try {
			sale = (Sale) this.sessionFactory.getCurrentSession().get(Sale.class, saleId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sale;
	}
	
	@Override
	public boolean doCheckAll(Long saleId,double saleAll){
		boolean flag = false;
		Session  session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();
			Sale sale = (Sale) session.get(Sale.class, saleId);
			sale.setSaleAll(saleAll);
			sale.setSaleState(3);
			session.getTransaction().commit();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	@Override
	//起止时间有默认值，不用判空
	public List<Sale> findByFiveCondition(String saleName, long clientId, long empId, Date startDate, Date endDate,
			int saleState, int saleDel, int pageCurrent) {
		List<Sale> list = new ArrayList<Sale>();
		String hql = " from Sale s where saleDel = "+saleDel+" and saleName like '%"+saleName+"%' "
				+ " and saleDate>=? and saleDate<=? ";
		if(clientId != -99){
			hql += " and s.client.clientId =  "+clientId;
		}
		if(empId != -99){
			hql += " and s.emp.empId =  "+empId;
		}
		if(saleState != -99){
			hql += " and s.emp.saleState =  "+saleState;
		}
		try {
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			query.setDate(0, startDate);
			query.setDate(1, endDate);
			query.setFirstResult((pageCurrent-1)*pageSize);
			query.setMaxResults(pageSize);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int findCountByFiveCondition(String saleName, long clientId, long empId, Date startDate, Date endDate,
			int saleState ,int saleDel) {
		int count = 0;
		String hql = " select count(saleId) from Sale s where saleDel = "+saleDel+" and saleName like '%"+saleName+"%' "
				+ " and saleDate>=? and saleDate<=? ";
		if(clientId != -99){
			hql += " and s.client.clientId =  "+clientId;
		}
		if(empId != -99){
			hql += " and s.emp.empId =  "+empId;
		}
		if(saleState != -99){
			hql += " and s.emp.saleState =  "+saleState;
		}
		try {
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			query.setDate(0, startDate);
			query.setDate(1, endDate);
			count = Integer.parseInt(query.list().get(0).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean doOut(Long saleId) {
		boolean flag = false;
		Session  session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();
			Sale pojo = (Sale) session.get(Sale.class, saleId);
			pojo.setSaleState(2);
			session.getTransaction().commit();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return flag;
	}

}
