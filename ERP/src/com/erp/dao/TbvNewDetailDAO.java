package com.erp.dao;



import java.util.Date;
import java.util.List;

import com.erp.pojo.CheckTable;
import com.erp.pojo.TbvNewDetail;

public interface TbvNewDetailDAO {
	
	public TbvNewDetail findById(Long goodsId);
	
	public List<TbvNewDetail>findGoods(int pageCurrent);
	
	public int findCountGoods();

}
