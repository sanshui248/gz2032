package org.gecedu.model;

public class Department {

	private Integer id;
	private Integer parent_id;
	private String name;
	private Integer order_num;
	private String parentName;
	
	public Department() {
		super();
	}

	public Department(Integer id, Integer parent_id, String name, Integer order_num) {
		super();
		this.id = id;
		this.parent_id = parent_id;
		this.name = name;
		this.order_num = order_num;
		//this.parentName = parentName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getOrder_num() {
		return order_num;
	}
	public void setOrder_num(Integer order_num) {
		this.order_num = order_num;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
	
}
