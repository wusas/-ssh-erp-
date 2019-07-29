package com.erp.dao;

import java.util.List;

import com.erp.pojo.Dept;
import com.erp.pojo.Emp;
import com.erp.pojo.Menu;

public interface UserInfoDao {
			//验证登陆名和密码
			public Emp checkLoginname(String username,String password);
			//修改
			public boolean doDpd(Emp pojo);
			//新增
			public boolean doIns(Emp pojo);
			//删除
			public boolean doDel(Long eId);
			//查询
			public Emp findbyId(Long eId);
			//跟据用户名查询多笔数据，并分页
			public List<Emp> findByUsername(String username,int pageCurrent,int pageSize);
			//跟据用户名查询数据笔数
			public int findCountByUsername(String username);
			//跟据用户名id 实现模糊查询
			public Emp findByUsernameId(Long eId,String username);
			//跟据职工部门id查找部门菜单
			public List<Menu> findByDeptMenu(Emp deptId); 
			//查询所有数据
			public List<Emp> findAll();
			//跟据部门id查找所有部门信息
			public Dept findByDId(Long deptId);
}
