package com.erp.dao;

import java.util.List;

import com.erp.pojo.Goods;

public interface GoodsDAO {
	// 新增商品
	public boolean doIns(Goods pojo);

	// 修改商品（可修改是否停用）
	public boolean doUpd(Goods pojo);

	// 根据商品ID查找
	public Goods findById(Long goodsId);

	// 根据商品名和是否停售
	// 根据供应商查询放在供应商中
	public List<Goods> findByGoodsNameGoodsStop(String goodsName, int goodsStop, int pageCurrent);

	// 查询数据笔数
	public int findCountByGoodsNameGoodsStop(String goodsName, int goodsStop);

	// 查询所有
	public List<Goods> findAll();
}
