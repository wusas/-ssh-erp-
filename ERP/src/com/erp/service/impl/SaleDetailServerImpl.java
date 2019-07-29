package com.erp.service.impl;

import java.util.List;

import com.erp.dao.SaleDetailDAO;
import com.erp.pojo.Sale;
import com.erp.pojo.SaleDetail;
import com.erp.service.SaleDetailService;

public class SaleDetailServerImpl implements SaleDetailService{

	private SaleDetailDAO dao;
	
	public SaleDetailDAO getDao() {
		return dao;
	}

	public void setDao(SaleDetailDAO dao) {
		this.dao = dao;
	}

	@Override
	public boolean doIns(SaleDetail pojo) {
		return this.dao.doIns(pojo);
	}

	@Override
	public boolean doUpd(SaleDetail pojo) {
		return this.dao.doUpd(pojo);
	}

	@Override
	public List<SaleDetail> findById(Sale sale) {
		return this.dao.findById(sale);
	}

	@Override
	public SaleDetail findBySaliDetailId(Long saleDetailId) {
		return this.dao.findBySaliDetailId(saleDetailId);
	}

}
