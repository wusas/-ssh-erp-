package com.erp.service.impl;

import java.util.List;

import com.erp.dao.TbvNewDetailDAO;
import com.erp.pojo.TbvNewDetail;
import com.erp.service.TbvNewDetailService;

public class TbvNewDetailServiceImpl implements TbvNewDetailService {
	TbvNewDetailDAO dao;
	

	public TbvNewDetailDAO getDao() {
		return dao;
	}


	public void setDao(TbvNewDetailDAO dao) {
		this.dao = dao;
	}


	@Override
	public TbvNewDetail findById(Long goodsId) {
		// TODO Auto-generated method stub
		
		return this.dao.findById(goodsId);
	}


	@Override
	public List<TbvNewDetail> findGoods(int pageCurrent) {
		// TODO Auto-generated method stub
		return this.dao.findGoods(pageCurrent);
	}


	@Override
	public int findCountGoods() {
		// TODO Auto-generated method stub
		return this.dao.findCountGoods();
	}

}
