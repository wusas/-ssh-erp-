package com.erp.dao;

import java.util.Date;
import java.util.List;

import com.erp.pojo.CheckTable;

public interface CheckTableDAO {
	/**
	 * 
	 *@author  你坤哥，5月29
	 * @param pojo
	 * @return
	 */
	//新增
	public boolean doIns(CheckTable pojo);
	//修改
	public boolean doUpd(CheckTable pojo);
	//通過ID查找
	public CheckTable findById(Long checkId);
	//通過盘点日期和商品名（）
	public List<CheckTable>findByTimeGoodsId(Long goodsId,Long empId,Date checkDate,int pageCurrent);
	//查找数据笔数
	public int findCountByTimeGoodsId(Long goodsId,Long empId,Date checkDate);
	
	
	




}
