package com.ibm.service;

import com.ibm.domain.Announce;

public interface AnnounceService {
	public Announce getAnnounce();
	
	public void deleteAnnounce();
	
	public void updateAnnounce(Announce announce);

}
