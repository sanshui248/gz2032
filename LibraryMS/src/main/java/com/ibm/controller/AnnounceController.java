package com.ibm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.domain.Announce;
import com.ibm.service.AnnounceService;

@Controller
@RequestMapping("/announce")
public class AnnounceController {
	
	@Autowired
	private AnnounceService announceService;
	
	
	/**
	 * @Description 获取公告信息
	 * @param
	 * @return 公告信息
	 */
	@ResponseBody
	@RequestMapping("/list")
	public Announce getAnnounce() {
		return announceService.getAnnounce();
	}
	
	/**
	 * @Description 删除公告信息
	 * @param
	 * @return 
	 * @return 图书信息列表
	 */
	@RequestMapping("/delete")
	public String deleteAnnounce() {
		announceService.deleteAnnounce();
		return "redirect:/announce/list";
	}
	
	/**
	 * @Description 更新公告信息
	 * @param
	 * @return 图书信息列表
	 */
	
	@RequestMapping("/update")
	public String updateAnounce(@RequestBody Announce announce) {
		announceService.updateAnnounce(announce);
		return "redirect:/announce/list";
	}
	
	
	
	

}
