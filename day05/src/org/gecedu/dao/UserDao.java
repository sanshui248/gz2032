package org.gecedu.dao;

import java.util.List;

import org.gecedu.bean.PageInfo;
import org.gecedu.model.User;


public interface UserDao {
	/**
	 * 添加
	 */
	void save(User user);
	/**
	 *更新 
	 */
	void update(User user);
	/**
	 * 删除
	 * @param id  用户id
	 */
	void deleteById(Integer id);
	/**
	 * 查询
	 * @param id  用户id
	 * @return  user对象
	 */
	User queryById(Integer id);
	
	
	/**
	 * 查询所有
	 */
	public List<User> queryAll();
	
	/**
	 * 分页查询
	 */
	PageInfo queryByPages(Integer currentPage);
	/**
	 *账号密码查询
	 */
	User queryByAccountAndPwd(String account, String password);
}
