package com.erp.service.impl;

import java.util.List;

import com.erp.dao.GoodsDAO;
import com.erp.pojo.Goods;
import com.erp.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {

	private GoodsDAO dao;
	
	public GoodsDAO getDao() {
		return dao;
	}

	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}

	@Override
	public boolean doIns(Goods pojo) {
		return this.dao.doIns(pojo);
	}

	@Override
	public boolean doUpd(Goods pojo) {
		return this.dao.doUpd(pojo);
	}

	@Override
	public Goods findById(Long goodsId) {
		return this.dao.findById(goodsId);
	}

	@Override
	public List<Goods> findByGoodsNameGoodsStop(String goodsName, int goodsStop, int pageCurrent) {
		return this.dao.findByGoodsNameGoodsStop(goodsName, goodsStop, pageCurrent);
	}

	@Override
	public int findCountByGoodsNameGoodsStop(String goodsName, int goodsStop) {
		return this.dao.findCountByGoodsNameGoodsStop(goodsName, goodsStop);
	}

	@Override
	public List<Goods> findAll() {
		return this.dao.findAll();
	}

}
