package com.ibm.service;

import java.util.List;

import com.ibm.domain.BorrowingDetails;

public interface BorrowService {

	public List<BorrowingDetails> selectAll(Integer pageNum, Integer pageSize);

	public List<BorrowingDetails> selectByUserId(Integer id);

	public List<BorrowingDetails> selectByBookId(Integer id);

	public List<BorrowingDetails> selectByKey(String key, Integer pageNum, Integer pageSize);

	public void save(BorrowingDetails borrow);

	public void deleteById(Integer uid, Integer bid);

	public void update(BorrowingDetails borrow);
}
