package com.erp.service;

import java.util.List;

import com.erp.pojo.Sale;
import com.erp.pojo.SaleDetail;

public interface SaleDetailService {
	
	public boolean doIns(SaleDetail pojo);

	public boolean doUpd(SaleDetail pojo);

	public List<SaleDetail> findById(Sale sale);
	
	public SaleDetail findBySaliDetailId(Long saleDetailId);
}
