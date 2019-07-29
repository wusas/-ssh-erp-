package com.erp.service.impl;

import java.util.List;

import com.erp.dao.UserInfoDao;
import com.erp.pojo.Dept;
import com.erp.pojo.Emp;
import com.erp.pojo.Menu;
import com.erp.service.UserInfoServiceDao;

public class UserInfoServiceDaoImpl implements UserInfoServiceDao {
		UserInfoDao dao;
		
	public UserInfoDao getDao() {
			return dao;
		}

		public void setDao(UserInfoDao dao) {
			this.dao = dao;
		}

	@Override
	public Emp checkLoginname(String username, String password) {
		return this.dao.checkLoginname(username, password);
	}

	@Override
	public boolean doDpd(Emp pojo) {
		return this.dao.doDpd(pojo);
	}

	@Override
	public boolean doIns(Emp pojo) {
		return this.dao.doIns(pojo);
	}

	@Override
	public boolean doDel(Long eId) {
		return this.dao.doDel(eId);
	}

	@Override
	public Emp findbyId(Long eId) {
		return this.dao.findbyId(eId);
	}

	@Override
	public List<Emp> findByUsername(String username, int pageCurrent, int pageSize) {
		return this.dao.findByUsername(username, pageCurrent, pageSize);
	}

	@Override
	public int findCountByUsername(String username) {
		return this.dao.findCountByUsername(username);
	}

	@Override
	public Emp findByUsernameId(Long eId, String username) {
		return this.dao.findByUsernameId(eId, username);
	}

	@Override
	public List<Menu> findByDeptMenu(Emp deptId) {
		return this.dao.findByDeptMenu(deptId);
	}

	@Override
	public List<Emp> findAll() {
		return this.dao.findAll();
	}
	
	@Override
	public Dept findByDId(Long deptId) {
		return this.dao.findByDId(deptId);
	}

}
