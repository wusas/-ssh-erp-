package com.erp.service;

import java.util.List;

import com.erp.pojo.TbvNewDetail;

public interface TbvNewDetailService {
	public TbvNewDetail findById(Long goodsId);
	
	public List<TbvNewDetail>findGoods(int pageCurrent);

	public int findCountGoods();
}
