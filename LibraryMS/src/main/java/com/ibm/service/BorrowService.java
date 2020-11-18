package com.ibm.service;

import java.util.List;

import com.ibm.domain.BorrowingDetails;

public interface BorrowService {

	public List<BorrowingDetails> selectAll(Integer pageNum, Integer pageSize);

	public List<BorrowingDetails> selectByKey(String key, Integer pageNum, Integer pageSize);

	public Integer getBorrowCountByDay();

	public Integer getReturnCountByDay();

	public Integer getBorrowCountByMon();

	public Integer getReturnCountByMon();

	public Integer getBorrowCountByYear();

	public Integer getReturnCountByYear();

	public void save(BorrowingDetails borrow);

	public void deleteById(Integer uid, Integer bid);

	public void update(BorrowingDetails borrow);
}
