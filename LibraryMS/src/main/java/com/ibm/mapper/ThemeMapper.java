package com.ibm.mapper;

import java.util.List;

import com.ibm.domain.Theme;

public interface ThemeMapper {

	public List<Theme> selectAll();

	public Theme getById(Integer id);

	public void save(Theme theme);

	public void update(Theme theme);

	public void deleteById(Integer id);

}
