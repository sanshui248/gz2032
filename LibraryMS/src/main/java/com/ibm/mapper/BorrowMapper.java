package com.ibm.mapper;

import java.util.List;

import com.ibm.domain.BorrowingDetails;

public interface BorrowMapper {

	// 查询所有借阅记录
	public List<BorrowingDetails> selectAll();

	// 根据关键字模糊查询借阅记录
	public List<BorrowingDetails> selectByKey(String key);

	// 根据参数进行今日借阅或归还数量统计 1:借阅 2：归还
	public Integer getCountByDay(Integer boOrRu, String day);

	// 根据参数进行本月借阅或归还数量统计 1:借阅 2：归还
	public Integer getCountByMon(Integer boOrRu, String mon);

	// 根据参数进行年度借阅或归还数量统计 1:借阅 2：归还
	public Integer getCountByYear(Integer boOrRu, String year);

	// 保存借阅记录
	public void save(BorrowingDetails borrow);

	// 根据ID删除借阅记录
	public void deleteById(Integer uid, Integer bid);

	// 更新借阅记录
	public void update(BorrowingDetails borrow);
	//查找借阅内容
	public BorrowingDetails selectByBookIdAndUserId(BorrowingDetails borrowingDetails);
	
	// 根据图书ID查询借阅记录
	public List<BorrowingDetails> selectBorrowsByBookId(Integer id);


}
