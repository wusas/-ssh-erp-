package com.erp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.erp.dao.TbvNewDetailDAO;
import com.erp.pojo.CheckTable;
import com.erp.pojo.TbvNewDetail;

public class TbvNewDetailDAOImpl implements TbvNewDetailDAO {
	SessionFactory sessionFactoy;
	
	
	public SessionFactory getSessionFactoy() {
		return sessionFactoy;
	}


	public void setSessionFactoy(SessionFactory sessionFactoy) {
		this.sessionFactoy = sessionFactoy;
	}


	@Override
	public TbvNewDetail findById(Long goodsId) {
		TbvNewDetail tbv = null;
		String hql = "from TbvNewDetail where id.goodsId="+goodsId;
		try{
			Query query = this.sessionFactoy.getCurrentSession().createQuery(hql);
			tbv = (TbvNewDetail) query.list().get(0);
		}catch(Exception e){
			e.printStackTrace();
		}
		return tbv;
	}


	@Override
	public List<TbvNewDetail> findGoods(int pageCurrent) {
		List<TbvNewDetail> list = null;
		try{
			StringBuffer sb =new StringBuffer();
			
			sb.append("from TbvNewDetail");
			Query query = this.sessionFactoy.getCurrentSession().createQuery(sb.toString());
            query.setFirstResult((pageCurrent-1)*8);
			
			list = query.list();
	}catch(Exception e ){
		e.printStackTrace();
	}
		return list;
}


	@Override
	public int findCountGoods() {
		int count=0;
     try{
			
			StringBuffer sb =new StringBuffer();
			
			sb.append("select count(id.goodsId) from TbvNewDetail where 0!=1"); 
			
             Query query = this.sessionFactoy.getCurrentSession().createQuery(sb.toString());
			
			count = Integer.parseInt(query.list().get(0).toString());
		
	}catch (Exception e) {
		e.printStackTrace();
	}
     return count;
     }
	

}
