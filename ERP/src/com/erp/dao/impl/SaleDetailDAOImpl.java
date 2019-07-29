package com.erp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.erp.dao.SaleDetailDAO;
import com.erp.pojo.Sale;
import com.erp.pojo.SaleDetail;

public class SaleDetailDAOImpl implements SaleDetailDAO {

	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean doIns(SaleDetail pojo) {
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
	public boolean doUpd(SaleDetail pojo) {
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
	public List<SaleDetail> findById(Sale sale) {
		List<SaleDetail> list = new ArrayList<SaleDetail>();
		String hql = " from SaleDetail sd where sd.sale.saleId = "+sale.getSaleId();
		try {
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public SaleDetail findBySaliDetailId(Long saleDetailId) {
		SaleDetail sd = null;
		String hql = " from SaleDetail where saleDetailId = "+saleDetailId;
		try {
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			sd = (SaleDetail) query.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sd;
	}
}
