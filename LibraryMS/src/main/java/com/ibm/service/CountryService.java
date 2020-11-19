package com.ibm.service;

import java.util.List;

import com.ibm.domain.Country;

public interface CountryService {

	public List<Country> selectAll();

	public Country getById(Integer id);

	public void save(Country country);

	public void update(Country country);

	public void deleteById(Integer id);

}
