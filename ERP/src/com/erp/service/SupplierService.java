package com.erp.service;

import java.util.List;

import com.erp.pojo.Supplier;

public interface SupplierService {
	// 新增供应商
		public boolean doIns(Supplier pojo);

		// 删除供应商
		public boolean doDel(Long supplierId);

		// 修改供应商
		public boolean doUpd(Supplier pojo);
		
		// 还原供应商
		public boolean doBack(Long supplierId);

		// 通过姓名与等级与是否删除查找
		public List<Supplier> findByNameGrade(String supplierName, int supplierGrade, int supplierDel, int pageCurrent);

		// 查询数据笔数
		public int findCountByNameGrade(String supplierName, int supplierGrade ,int supplierDel);

		// 查询单笔数据
		public Supplier findByClientId(Long supplierId);
		
		//查询所有
		public List<Supplier> findAll();

}
