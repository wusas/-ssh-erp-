package com.erp.dao;

import java.util.List;

import com.erp.pojo.Sale;
import com.erp.pojo.SaleDetail;

public interface SaleDetailDAO {
	//新增销售单时使用
	public boolean doIns(SaleDetail pojo);
	//修改明细时使用
	public boolean doUpd(SaleDetail pojo);
	//查出某个销售单对应的所有明细
	public List<SaleDetail> findById(Sale sale);
	
	public SaleDetail findBySaliDetailId(Long saleDetailId);
}
