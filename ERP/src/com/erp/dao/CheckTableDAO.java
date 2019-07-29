package com.erp.dao;

import java.util.Date;
import java.util.List;

import com.erp.pojo.CheckTable;

public interface CheckTableDAO {
	/**
	 * 
	 *@author  �����磬5��29
	 * @param pojo
	 * @return
	 */
	//����
	public boolean doIns(CheckTable pojo);
	//�޸�
	public boolean doUpd(CheckTable pojo);
	//ͨ�^ID����
	public CheckTable findById(Long checkId);
	//ͨ�^�̵����ں���Ʒ������
	public List<CheckTable>findByTimeGoodsId(Long goodsId,Long empId,Date checkDate,int pageCurrent);
	//�������ݱ���
	public int findCountByTimeGoodsId(Long goodsId,Long empId,Date checkDate);
	
	
	




}
