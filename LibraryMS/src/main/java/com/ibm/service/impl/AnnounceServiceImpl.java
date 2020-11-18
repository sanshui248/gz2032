package com.ibm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.domain.Announce;
import com.ibm.mapper.AnnounceMapper;
import com.ibm.service.AnnounceService;

@Service
public class AnnounceServiceImpl implements AnnounceService {
	
	@Autowired
	private AnnounceMapper announceMapper;
	
	
	@Override
	public Announce getAnnounce() {		
		return announceMapper.getAnnounce();
	}

	@Override
	public void deleteAnnounce() {
		announceMapper.deleteAnnounce();

	}

	@Override
	public void updateAnnounce(Announce announce) {
	    announceMapper.updateAnnounce(announce);

	}

}
