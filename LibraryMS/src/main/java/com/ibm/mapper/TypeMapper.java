package com.ibm.mapper;

import java.util.List;

import com.ibm.domain.Type;

public interface TypeMapper {

	public List<Type> selectAll();

	public Type getById(Integer id);

	public void save(Type type);

	public void update(Type type);

	public void deleteById(Integer id);

}
