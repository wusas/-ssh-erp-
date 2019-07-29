package com.erp.service.impl;

import java.util.List;

import com.erp.dao.SupplierDAO;
import com.erp.pojo.Supplier;
import com.erp.service.SupplierService;

public class SupplierServiceImpl implements SupplierService {

	private SupplierDAO dao;
	
	public SupplierDAO getDao() {
		return dao;
	}

	public void setDao(SupplierDAO dao) {
		this.dao = dao;
	}

	@Override
	public boolean doIns(Supplier pojo) {
		return this.dao.doIns(pojo);
	}

	@Override
	public boolean doDel(Long supplierId) {
		return this.dao.doDel(supplierId);
	}

	@Override
	public boolean doUpd(Supplier pojo) {
		return this.dao.doUpd(pojo);
	}

	@Override
	public List<Supplier> findByNameGrade(String supplierName, int supplierGrade, int supplierDel, int pageCurrent) {
		return this.dao.findByNameGrade(supplierName, supplierGrade, supplierDel, pageCurrent);
	}

	@Override
	public int findCountByNameGrade(String supplierName, int supplierGrade ,int supplierDel) {
		return this.dao.findCountByNameGrade(supplierName, supplierGrade ,supplierDel);
	}

	//只是名字错误，程序无误
	@Override
	public Supplier findByClientId(Long supplierId) {
		return this.dao.findByClientId(supplierId);
	}

	@Override
	public List<Supplier> findAll() {
		return this.dao.findAll();
	}

	@Override
	public boolean doBack(Long supplierId) {
		return this.dao.doBack(supplierId);
	}

}
