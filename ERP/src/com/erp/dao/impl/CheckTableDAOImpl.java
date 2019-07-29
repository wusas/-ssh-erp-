package com.erp.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.erp.dao.CheckTableDAO;
import com.erp.pojo.CheckTable;

public class CheckTableDAOImpl implements CheckTableDAO {
SessionFactory sessionFactoy;
	
	public SessionFactory getSessionFactoy() {
		return sessionFactoy;
	}

	public void setSessionFactoy(SessionFactory sessionFactoy) {
		this.sessionFactoy = sessionFactoy;
	}


	@Override
	public boolean doIns(CheckTable pojo) {
		boolean bool = false;
		try{
			this.sessionFactoy.getCurrentSession().save(pojo);
			bool = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}

	

	@Override
	public boolean doUpd(CheckTable pojo) {
		
		boolean bool = false ; 
		try{
			CheckTable ck = (CheckTable) this.sessionFactoy.getCurrentSession().get(CheckTable.class, pojo.getCheckId());
			ck.setEmp(pojo.getEmp());
			ck.setGoods(pojo.getGoods());
			ck.setCheckDate(pojo.getCheckDate());
			ck.setCheckPerson(pojo.getCheckPerson());
			bool = true ;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public CheckTable findById(Long checkId) {
		CheckTable ck = null;
		try{
			ck = (CheckTable) this.sessionFactoy.getCurrentSession().get(CheckTable.class, checkId);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ck;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CheckTable> findByTimeGoodsId( Long goodsId,Long empId,Date checkDate, int pageCurrent) {
		List<CheckTable> list = null;
//		Calendar c = new GregorianCalendar();
//		//c.set(Calendar.DAY_OF_MONTH, 1);//设置为当前月第一天
//		c.add(Calendar.DAY_OF_MONTH, 1);//jia一天
//		Date cd = c.getTime();//转换成Date类型
//		//Date cd = new Date();
//		System.out.println(cd);
//		DateFormat df = new SimpleDateFormat("yyyy/MM/dd ");//定义转换格式
//		String str=df.format(cd);
//		try {
//			df.parse(str);
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		System.out.println(df.format(cd));
		
		
		try{
			StringBuffer sb =new StringBuffer();
			
			sb.append("from CheckTable ck where 0!=1 ");
			if(null !=goodsId){
			sb.append(" and ck.goods.goodsId="+goodsId);
			}
			if(null !=empId){
				sb.append(" and ck.emp.empId="+empId);
			}
			if(checkDate!=null){
				sb.append(" and ck.checkDate>=?  ");
				
			}
			sb.append(" order by checkDate desc  ");
			Query query = this.sessionFactoy.getCurrentSession().createQuery(sb.toString());
			
				if(checkDate!=null){
					Date date = new java.sql.Date(checkDate.getTime());
					query.setDate(0, date);
					
				}
			
			query.setFirstResult((pageCurrent-1)*8);
			
			list = query.list();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int findCountByTimeGoodsId( Long goodsId,Long empId,Date checkDate) {
		int count = 0;
		try{
			
			StringBuffer sb =new StringBuffer();
			
			sb.append("select count(checkId) from CheckTable ck where 0!=1");
			if(null !=goodsId){
				sb.append(" and ck.goods.goodsId= '"+goodsId+"'");  
			}
			if(null !=empId){
				sb.append(" and ck.emp.empId='"+empId+"'");
			}
//			if(checkDate !=null){
//				sb.append( "and ck.checkDate =  '"+checkDate+"'");
//			}
			
			Query query = this.sessionFactoy.getCurrentSession().createQuery(sb.toString());
			
			
			count = Integer.parseInt(query.list().get(0).toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}
