package com.erp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.erp.dao.GoodsDAO;
import com.erp.pojo.Goods;

public class GoodsDAOImpl implements GoodsDAO {

	final int pageSize = 8;
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean doIns(Goods pojo) {
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
	public boolean doUpd(Goods pojo) {
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
	public Goods findById(Long goodsId) {
		Goods goods = null;
		try {
			goods = (Goods) this.sessionFactory.getCurrentSession().get(Goods.class, goodsId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goods;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> findByGoodsNameGoodsStop(String goodsName, int goodsStop, int pageCurrent) {
		List<Goods> list = new ArrayList<Goods>();
		String hql = " from Goods where goodsName like '%"+goodsName+"%'";
		if(goodsStop != -99){
			hql += " and goodsStop =  "+goodsStop;
		}
		try {
			Query query =this.sessionFactory.getCurrentSession().createQuery(hql);
			query.setFirstResult((pageCurrent-1)*pageSize);
			query.setMaxResults(pageSize);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int findCountByGoodsNameGoodsStop(String goodsName, int goodsStop) {
		int count = 0;
		String hql = " select count(goodsId) from Goods where goodsName like '%"+goodsName+"%'";
		if(goodsStop != -99){
			hql += " and goodsStop =  "+goodsStop;
		}
		try {
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			count = Integer.parseInt(query.list().get(0).toString());
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> findAll() {
		List<Goods> list = new ArrayList<Goods>();
		String hql = " from Goods ";
		try {
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
