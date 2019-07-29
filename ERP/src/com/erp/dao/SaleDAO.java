package com.erp.dao;

import java.util.Date;
import java.util.List;

import com.erp.pojo.Sale;

public interface SaleDAO {
	// 新增销售单(返回pojo用于增加明细)
	public Sale doIns(Sale pojo);

	// 删除销售单
	public boolean doDel(Long saleId);

	//确认出库
	public boolean doOut(Long saleId);
	
	// 修改销售单
	public boolean doUpd(Sale pojo);
	
	//确认结算
	public boolean doCheckAll(Long saleId,double saleAll);
	
	//还原销售单
	public boolean doBack(Long saleId);

	// 根据id查询销售单
	public Sale findBySaleId(long saleId);

	/**
	 * @author zhenqing
	 * @param 销售单名称
	 * @param 客户
	 * @param 处理职工
	 * @param 开始时间
	 * @param 结束时间
	 * @param 当前状态
	 * @param 当前页
	 * @return
	 */
	public List<Sale> findByFiveCondition(String saleName, long clientId, long empId, Date startDate, Date endDate,
			int saleState, int saleDel, int pageCurrent);

	// 查询数据笔数
	public int findCountByFiveCondition(String saleName, long clientId, long empId, Date startDate, Date endDate,
			int saleState ,int saleDel);

}
