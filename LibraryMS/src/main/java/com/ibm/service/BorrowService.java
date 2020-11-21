package com.ibm.service;

import java.util.List;

import com.ibm.domain.BorrowingDetails;

public interface BorrowService {

//	public List<BorrowingDetails> selectAll(Integer pageNum, Integer pageSize);
	public List<BorrowingDetails> selectAll();

//	public List<BorrowingDetails> selectByKey(String key, Integer pageNum, Integer pageSize);
	public List<BorrowingDetails> selectByKey(String key);

	public Integer getBorrowCountByDay();

	public Integer getReturnCountByDay();

	public Integer getBorrowCountByMon();

	public Integer getReturnCountByMon();

	public Integer getBorrowCountByYear();

	public Integer getReturnCountByYear();

	public void save(BorrowingDetails borrow);

	public void deleteById(Integer uid, Integer bid);

	public void update(BorrowingDetails borrow);

	public BorrowingDetails selectByBookIdAndUserId(BorrowingDetails borrowingDetails);

	public void saveBorrowRecords(int userId, int bookId);

	public List<BorrowingDetails> selectBorrowsByUserId(Integer id);
}
