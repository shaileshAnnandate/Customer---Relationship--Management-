package com.CRM.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRM.dao.CustomerDao;
import com.CRM.entity.Customer;

@Service
public class CustomerService {

	@Autowired
	
	CustomerDao dao;
	public List<Customer> getAll() {

		List<Customer> list=dao.getAll();
		return list;
	}
	public String insertCust(Customer cc) {

		String msg=dao.insertCust(cc);
		
		return msg;
	}
	public String updateCust(Customer cc) {

		String msg=dao.updateCust(cc);
		return msg;
	}
	public String delete(int id) {

		String msg=dao.delete(id);
		return msg;
	}
	public List<String> getCustNames(String city) {

		List<String >list=dao.getCustNames(city);
		return list;
	}
	public String insertMultiData(List<Customer> list) {

		String msg=dao.insertMultiData(list);
		return msg;
		
	}
	public Customer getById(int id) {

		return dao.getById(id);
	}
	public List<Customer> getByName(String name) {

		return dao.getByName(name);
	}
	public List<Customer> getByEmail(String email) {

		return dao.getByEmail(email);
	}
	public List<Customer> getByCity(String city) {

		return dao.getByCity(city);
	}
	public List<Customer> getByMobileNo(long mob) {

		return dao.getByMobileNo(mob);
	}
	public List<Customer> getByAge(int age) {

		return dao.getByAge(age);
	}
	public List<Customer> getBetweenId(int id, int id1) {

		return dao.getBetweenId(id,id1);
	}
	public List<Customer> getBetweenName(String name, String name1) {

		return dao.getBetweenName(name,name1);
	}
	public List<Customer> byNameLike(String name) {

		return dao.byNameLike(name);
	}
	public String updateData(int id, String name) {

		String msg=dao.updateData(id,name);
		return msg;
	}
	public List<Customer> getByQuery() {

		return dao.getByQuery();
	}
	public List<Customer> byLessThan(int age) {

		return dao.byLessThan(age);
	}
	public String updateDataByCity(int id, String city) {

		String msg= dao.updateDataByCity(id,city);
		
		return msg;
	}
	public String updateDatabyMail(int id, String email) {

		String msg=dao.updateDatabyMail(id,email);
		return msg;
	}
	public String updateDatabyAge(int id, int age) {

		String msg=dao.updateDatabyAge(id,age);
		
		return msg;
	}
	public List<Customer> getDataBetweenCity(String city, String city1) {

		return dao.getDataBetweenCity(city,city1);
	}
	public String deleteBetween(int id, int id1) {

		String msg=dao.deleteBetween(id,id1);
		return msg;
	}
	public String deleteByName(String name) {
      
		String msg=dao.deleteByName(name);
		return msg;

	}
	public String updateDatabyMobileNo(int id, long mob) {

		String msg=dao.updateDatabyMobileNo(id,mob);
		return msg;
		
	}
	public List<Customer> getDataLessThanId(int id) {

		return dao.getDataLessThanId(id);
	}
	public List<Customer> getDataByEqualStandard(String city) {

		return dao.getDataByEqualStandard(city);
	}
	public List<Customer> getDataByGt(int age) {

		return dao.getDataByGt(age);
	}
	public Customer getMaxAge() {

		return dao.getMaxAge();
	}
	public Customer getMinAge() {

		return dao.getMinAge();
	}

	
	
}

