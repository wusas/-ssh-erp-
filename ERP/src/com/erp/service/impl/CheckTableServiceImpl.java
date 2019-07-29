package com.erp.service.impl;

import java.util.Date;
import java.util.List;

import com.erp.dao.CheckTableDAO;
import com.erp.pojo.CheckTable;
import com.erp.service.CheckTableService;

public class CheckTableServiceImpl implements CheckTableService {
	CheckTableDAO dao;
	

	public CheckTableDAO getDao() {
		return dao;
	}

	public void setDao(CheckTableDAO dao) {
		this.dao = dao;
	}

	@Override
	public boolean doIns(CheckTable pojo) {
		// TODO Auto-generated method stub
		return this.dao.doIns(pojo);
	}

	@Override
	public boolean doUpd(CheckTable pojo) {
		// TODO Auto-generated method stub
		return this.dao.doUpd(pojo);
	}

	@Override
	public CheckTable findById(Long checkId) {
		// TODO Auto-generated method stub
		return this.dao.findById(checkId);
	}

	@Override
	public List<CheckTable> findByTimeGoodsId( Long goodsId,Long empId,Date checkDate, int pageCurrent) {
		// TODO Auto-generated method stub
		return this.dao.findByTimeGoodsId( goodsId,empId,checkDate, pageCurrent);
	}

	@Override
	public int findCountByTimeGoodsId( Long goodsId,Long empId,Date checkDate) {
		// TODO Auto-generated method stub
		return this.dao.findCountByTimeGoodsId(goodsId, empId,checkDate);
	}

}
