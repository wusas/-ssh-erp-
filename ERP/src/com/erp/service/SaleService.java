package com.erp.service;

import java.util.Date;
import java.util.List;

import com.erp.pojo.Sale;

public interface SaleService {
	public Sale doIns(Sale pojo);

	public boolean doDel(Long saleId);

	public boolean doUpd(Sale pojo);

	public boolean doBack(Long saleId);

	public Sale findBySaleId(long saleId);

	public List<Sale> findByFiveCondition(String saleName, long clientId, long empId, Date startDate, Date endDate,
			int saleState, int saleDel, int pageCurrent);

	public int findCountByFiveCondition(String saleName, long clientId, long empId, Date startDate, Date endDate,
			int saleState, int saleDel);
	public boolean doCheckAll(Long saleId,double saleAll);
	public boolean doOut(Long saleId);
}
