package com.erp.service;

import java.util.List;

import com.erp.pojo.Client;

public interface ClientService {

	// 新增客户
		public boolean doIns(Client pojo);

		// 删除客户
		public boolean doDel(Long clientId);

		// 修改客户
		public boolean doUpd(Client pojo);
		
		// 还原客户
		public boolean doBack(Long clientId);

		// 通过姓名与等级与是否删除查找
		public List<Client> findByNameGrade(String clientName, int clientGrade, int clientDel, int pageCurrent);

		// 查询数据笔数
		public int findCountByNameGrade(String clientName, int clientGrade, int clientDel);

		// 查询单笔数据
		public Client findByClientId(Long clientId);

		// 查询所有
		public List<Client> findAll();
}
