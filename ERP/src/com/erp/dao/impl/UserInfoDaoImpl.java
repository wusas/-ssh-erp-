package com.erp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.erp.dao.UserInfoDao;
import com.erp.pojo.Dept;
import com.erp.pojo.Emp;
import com.erp.pojo.Menu;

public class UserInfoDaoImpl implements UserInfoDao {
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Emp checkLoginname(String username, String password) {
		String hql ="from Emp where loginName='"+username+"' and loginPass='"+password+"'";
			Query query =this.sessionFactory.getCurrentSession().createQuery(hql);
			List<Emp> list = query.list();
			if(list.size()==0){
				return null;
			}else{
				return list.get(0);
			}
	}

	@Override
	public boolean doDpd(Emp pojo) {
		boolean flag=false;
		try {
			Emp user=(Emp) this.sessionFactory.getCurrentSession().get(Emp.class, pojo.getEmpId());
			user.setEmpName(pojo.getEmpName());
			user.setLoginName(pojo.getLoginName());
			user.setLoginPass(pojo.getLoginPass());
			user.setEmpLeave(pojo.getEmpLeave());
			user.setEmpSex(pojo.getEmpSex());
			user.setEmpBir(pojo.getEmpBir());
			user.setEmpPic(pojo.getEmpPic());
			user.setEmpSfnum(pojo.getEmpSfnum());
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doIns(Emp pojo) {
		boolean flag=false;
		try {
			 this.sessionFactory.getCurrentSession().save(pojo);
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doDel(Long eId) {
		boolean flag=false;
		String hql ="update Emp set emp_leave =0 where emp_id = ? ";
		try {
			Emp user = (Emp) this.sessionFactory.getCurrentSession().createQuery(hql);
			user.setEmpId(eId);
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Emp findbyId(Long eId) {
		Emp user=null;
		try {
			 user=(Emp) this.sessionFactory.getCurrentSession().get(Emp.class, eId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<Emp> findByUsername(String username, int pageCurrent, int pageSize) {
		 List<Emp> list=null;
		 String hql="from Emp where empName like '%"+username+"%'";
		 try {
			Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
			query.setFirstResult((pageCurrent-1)*pageSize);
			query.setMaxResults(pageSize);
			list=query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int findCountByUsername(String username) {
		int count =0;
		if("null".equals(username)){
			username = "";
		}
		//
		String hql ="select count(emp_id) from Emp where login_name like '%"+username+"%'";
		try {
			Query query =this.sessionFactory.getCurrentSession().createQuery(hql);
			count=Integer.parseInt(query.list().get(0).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Emp findByUsernameId(Long eId, String username) {
		return null;
	}

	@Override
	public List<Menu> findByDeptMenu(Emp deptId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> findAll() {
		List<Emp> list=null;
		String hql = " from Emp";
		try {
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public Dept findByDId(Long deptId) {
		Dept dept =null;
		try {
			dept=(Dept)this.sessionFactory.getCurrentSession().get(Dept.class, deptId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dept;
	}
}
