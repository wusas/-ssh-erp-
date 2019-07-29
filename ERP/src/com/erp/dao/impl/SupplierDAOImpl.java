package com.erp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.erp.dao.SupplierDAO;
import com.erp.pojo.Supplier;

public class SupplierDAOImpl implements SupplierDAO {

	final int pageSize = 8;
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean doIns(Supplier pojo) {
		boolean flag = false;
		Session  session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(pojo);
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
	public boolean doDel(Long supplierId) {
		boolean flag = false;
		Session  session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();
			Supplier pojo = (Supplier) session.get(Supplier.class, supplierId);
			pojo.setSupplierDel(1);
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
	public boolean doUpd(Supplier pojo) {
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> findByNameGrade(String supplierName, int supplierGrade, int supplierDel, int pageCurrent) {
		List<Supplier> list = new ArrayList<Supplier>();
		String hql = " from Supplier where supplierDel = "+supplierDel+" and supplierName like '%"+supplierName+"%'";
		if(supplierGrade != -99){
			hql += " and supplierGrade =  "+supplierGrade;
		}
		try {
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			query.setFirstResult((pageCurrent-1)*pageSize);
			query.setMaxResults(pageSize);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int findCountByNameGrade(String supplierName, int supplierGrade ,int supplierDel) {
		int count = 0;
		String hql = " select count(supplierId) from Supplier where supplierDel = "+supplierDel+" and supplierName like '%"+supplierName+"%'";
		if(supplierGrade != -99){
			hql += " and supplierGrade =  "+supplierGrade;
		}
		try {
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			count = Integer.parseInt(query.list().get(0).toString());
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return count;
	}

	@Override
	public Supplier findByClientId(Long supplierId) {
		Supplier supplier = null;
		try {
			supplier = (Supplier) this.sessionFactory.getCurrentSession().get(Supplier.class, supplierId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supplier;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> findAll() {
		List<Supplier> list = new ArrayList<Supplier>();
		String hql = " from Supplier where supplierDel = 0 ";
		try {
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean doBack(Long supplierId) {
		boolean flag = false;
		Session  session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();
			Supplier pojo = (Supplier) session.get(Supplier.class, supplierId);
			pojo.setSupplierDel(0);
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
