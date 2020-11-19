package com.ibm.mapper;

import java.util.List;

import com.ibm.domain.Country;

public interface CountryMapper {

	public List<Country> selectAll();

	public Country getById(Integer id);

	public void save(Country country);

	public void update(Country country);

	public void deleteById(Integer id);

}
