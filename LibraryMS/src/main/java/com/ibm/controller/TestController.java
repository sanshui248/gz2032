package com.ibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.domain.Type;
import com.ibm.service.CountryService;
import com.ibm.service.ThemeService;
import com.ibm.service.TypeService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private CountryService countryService;

	@Autowired
	private ThemeService themeService;

	@Autowired
	private TypeService typeService;

	@RequestMapping("/selectAll")
	public List<Type> selectAll() {
		return typeService.selectAll();
	}

	@RequestMapping("/getById")
	public Type getById(Integer id) {
		return typeService.getById(id);
	}

	@RequestMapping("/save")
	public void save(@RequestBody Type country) {
		typeService.save(country);
	}

	@RequestMapping("/update")
	public void update(@RequestBody Type country) {
		typeService.update(country);
	}

	@RequestMapping("/deleteById")
	public void deleteById(Integer id) {
		typeService.deleteById(id);
	}
}
