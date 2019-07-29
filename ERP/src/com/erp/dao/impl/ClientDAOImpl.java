package com.erp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.erp.dao.ClientDAO;
import com.erp.pojo.Client;

public class ClientDAOImpl implements ClientDAO {

	final int pageSize = 8;
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean doIns(Client pojo) {
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
	public boolean doDel(Long clientId) {
		boolean flag = false;
		Session  session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();
			Client pojo = (Client) session.get(Client.class, clientId);
			pojo.setClientDel(1);
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
	public boolean doUpd(Client pojo) {
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
	public List<Client> findByNameGrade(String clientName, int clientGrade, int clientDel, int pageCurrent) {
		List<Client> list = new ArrayList<Client>();
		String hql = " from Client where clientDel = "+clientDel+" and clientName like '%"+clientName+"%'";
		if(clientGrade != -99){
			hql += " and clientGrade =  "+clientGrade;
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
	public int findCountByNameGrade(String clientName, int clientGrade, int clientDel) {
		int count = 0;
		String hql = " select count(clientId) from Client where clientDel = "+clientDel+" and clientName like '%"+clientName+"%'";
		if(clientGrade != -99){
			hql += " and clientGrade =  "+clientGrade;
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
	public Client findByClientId(Long clientId) {
		Client client = null;
		try {
			client = (Client) this.sessionFactory.getCurrentSession().get(Client.class, clientId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return client;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findAll() {
		List<Client> list = new ArrayList<Client>();
		String hql = " from Client ";
		try {
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean doBack(Long clientId) {
		boolean flag = false;
		Session  session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();
			Client pojo = (Client) session.get(Client.class, clientId);
			pojo.setClientDel(0);
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
