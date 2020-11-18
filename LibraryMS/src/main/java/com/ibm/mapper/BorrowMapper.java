package com.ibm.mapper;

import java.util.List;

import com.ibm.domain.BorrowingDetails;

public interface BorrowMapper {

	// 查询所有借阅记录
	public List<BorrowingDetails> selectAll();

	// 根据用户ID查询借阅记录
	public List<BorrowingDetails> selectByUserId(Integer id);

	// 根据图书ID查询借阅记录
	public List<BorrowingDetails> selectByBookId(Integer id);

	// 根据关键字模糊查询借阅记录
	public List<BorrowingDetails> selectByKey(String key);

	// 保存借阅记录
	public void save(BorrowingDetails borrow);

	// 根据ID删除借阅记录
	public void deleteById(Integer uid, Integer bid);

	// 更新借阅记录
	public void update(BorrowingDetails borrow);

}
