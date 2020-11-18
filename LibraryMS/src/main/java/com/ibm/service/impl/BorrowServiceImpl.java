package com.ibm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ibm.domain.BorrowingDetails;
import com.ibm.mapper.BorrowMapper;
import com.ibm.service.BorrowService;

@Service
public class BorrowServiceImpl implements BorrowService {

	@Autowired
	private BorrowMapper borrowMapper;

	@Override
	public List<BorrowingDetails> selectAll(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<BorrowingDetails> borrows = borrowMapper.selectAll();
		return borrows;
	}

	@Override
	public List<BorrowingDetails> selectByUserId(Integer id) {
		List<BorrowingDetails> borrows = borrowMapper.selectByUserId(id);
		return borrows;
	}

	@Override
	public List<BorrowingDetails> selectByBookId(Integer id) {
		List<BorrowingDetails> borrows = borrowMapper.selectByBookId(id);
		return borrows;
	}

	@Override
	public List<BorrowingDetails> selectByKey(String key, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<BorrowingDetails> borrows = borrowMapper.selectByKey(key);
		return borrows;
	}

	@Override
	public void save(BorrowingDetails borrow) {
		borrowMapper.save(borrow);
	}

	@Override
	public void deleteById(Integer uid, Integer bid) {
		borrowMapper.deleteById(uid, bid);
	}

	@Override
	public void update(BorrowingDetails borrow) {
		borrowMapper.update(borrow);
	}

}
