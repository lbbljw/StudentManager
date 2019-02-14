package com.ajax.app.test;



import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Customer {

	public Customer(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	private String name;
	private String id;

	public String getCustomerName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return "BeiJing";
	}
//@JsonIgnore
	public String getBirth() {
		return "1990/10/11";
	}

	public static void main(String[] args) throws JsonProcessingException {
		// 1 导入jar包
		// 2 创建ObiectMapper对象
		ObjectMapper mapper = new ObjectMapper();
		// 3 调用mapper的writValueAsString（）方法把一个对象转为一个JSON字符串
		Customer customer=new Customer("NiPn","1009");
		String jsonStr=mapper.writeValueAsString(customer);
		System.out.println(jsonStr);
		// 4 JackSon使用getter方法来定位JSON对象的属性
		// 5 通过添加注解的方式 @JsonIgnore 忽略某一个getter定义的属性
		List<Customer> customers=Arrays.asList(customer,new Customer("DDD","1000"));
		jsonStr=mapper.writeValueAsString(customers);
		System.out.println(jsonStr);

	}
}
