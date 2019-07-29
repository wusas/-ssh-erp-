package com.erp.service.impl;

import java.util.Date;
import java.util.List;

import com.erp.dao.SaleDAO;
import com.erp.pojo.Sale;
import com.erp.service.SaleService;

public class SaleServiceImpl implements SaleService {

	private SaleDAO dao;
	
	
	public SaleDAO getDao() {
		return dao;
	}

	public void setDao(SaleDAO dao) {
		this.dao = dao;
	}

	@Override
	public Sale doIns(Sale pojo) {
		return this.dao.doIns(pojo);
	}

	@Override
	public boolean doDel(Long saleId) {
		return this.dao.doDel(saleId);
	}

	@Override
	public boolean doUpd(Sale pojo) {
		return this.dao.doUpd(pojo);
	}

	@Override
	public boolean doBack(Long saleId) {
		return this.dao.doBack(saleId);
	}

	@Override
	public Sale findBySaleId(long saleId) {
		return this.dao.findBySaleId(saleId);
	}

	@Override
	public List<Sale> findByFiveCondition(String saleName, long clientId, long empId, Date startDate, Date endDate,
			int saleState, int saleDel, int pageCurrent) {
		return this.dao.findByFiveCondition(saleName, clientId, empId, startDate, endDate, saleState, saleDel, pageCurrent);
	}

	@Override
	public int findCountByFiveCondition(String saleName, long clientId, long empId, Date startDate, Date endDate,
			int saleState, int saleDel) {
		return this.dao.findCountByFiveCondition(saleName, clientId, empId, startDate, endDate, saleState, saleDel);
	}

	@Override
	public boolean doCheckAll(Long saleId, double saleAll) {
		return this.dao.doCheckAll(saleId, saleAll);
	}

	@Override
	public boolean doOut(Long saleId) {
		return this.dao.doOut(saleId);
	}

}
