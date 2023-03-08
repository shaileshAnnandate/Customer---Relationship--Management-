package com.CRM.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRM.entity.Customer;
import com.CRM.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerControler {

	@Autowired
	CustomerService service;

//1
	@GetMapping("/")
	public List<Customer> getAll() {

		List<Customer> list = service.getAll();
		return list;
	}

//2
	@PostMapping("/")
	public String insertCustomer(@RequestBody Customer cc) {

		service.insertCust(cc);

		return "inserted";

	}

//3
	@PutMapping("/")
	public String updateCustomer(@RequestBody Customer cc) {

		service.updateCust(cc);
		return "updated";

	}

//4
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {

		service.delete(id);
		return "deleted";
	}

//5
	@GetMapping("/names/{city}")
	public List<String> getCustNames(@PathVariable String city) {

		List<String> list = service.getCustNames(city);
		return list;

	}

//6
	@PostMapping("//")
	public String insertMultiData(@RequestBody List<Customer> list) {

		service.insertMultiData(list);
		return "inserted";
	}

//7
	@GetMapping("/byid/{id}")
	public Customer getById(@PathVariable int id) {

		return service.getById(id);
	}

//8
	@GetMapping("/byname/{name}")
	public List<Customer> getByName(@PathVariable String name) {

		return service.getByName(name);
	}

//9
	@GetMapping("/byemail/{email}")
	public List<Customer> getByEmail(@PathVariable String email) {

		return service.getByEmail(email);
	}

//10
	@GetMapping("/bycity/{city}")
	public List<Customer> getByCity(@PathVariable String city) {

		return service.getByCity(city);
	}

//11
	@GetMapping("/bymobileno/{mob}")
	public List<Customer> getByMobileNo(@PathVariable long mob) {

		return service.getByMobileNo(mob);
	}

//12
	@GetMapping("/byage/{age}")
	public List<Customer> getByAge(@PathVariable int age) {

		return service.getByAge(age);
	}

//13
	@GetMapping("/{id}/{id1}")
	public List<Customer> getBetweenId(@PathVariable int id, @PathVariable int id1) {

		return service.getBetweenId(id, id1);
	}

//14
	@GetMapping("/between/{name}/{name1}")
	public List<Customer> getBetweenName(@PathVariable String name, @PathVariable String name1) {

		return service.getBetweenName(name, name1);
	}

//15	
	@GetMapping("/namelike/{name}")
	public List<Customer> byNameLike(@PathVariable String name) {

		return service.byNameLike(name);
	}

//16
	@PutMapping("/update/{id}/{name}")
	public String updateData(@PathVariable int id, @PathVariable String name) {

		service.updateData(id, name);
		return "Updated";
	}

//17
	@GetMapping("/query")
	public List<Customer> getByQuery() {

		return service.getByQuery();
	}

//18
	@GetMapping("/lessthan/{age}")
	public List<Customer> byLessThan(@PathVariable int age) {

		return service.byLessThan(age);

	}
//19
	
	@PutMapping("/{id}/{city}")
	public String updateDataByCity(@PathVariable int id, @PathVariable String city) {

		service.updateDataByCity(id, city);
		return "Updated";
	} 
//20
	
	@PutMapping("/byemail/{id}/{email}")
	public String updateDatabyMail(@PathVariable int id, @PathVariable  String  email){
		
		service.updateDatabyMail(id,email);
		return "Data Updated SuccesFully";
	}
//21	
	@PutMapping("/byage/{id}/{age}")
	public String updateDatabyAge(@PathVariable int id, @PathVariable  int  age){
		
		service.updateDatabyAge(id,age);
		return "Data Updated SuccesFully";
	}
//22
	@GetMapping("/getbetweenCity/{city}/{city1}")
	public List<Customer>getDataBetweenCity(@PathVariable  String city, @PathVariable  String city1){
		
		return service.getDataBetweenCity(city,city1);
	}
//23
	@DeleteMapping("/deletebetween/{id}/{id1}")
	public String deleteBetween(@PathVariable int id,@PathVariable int id1) {
		
		service.deleteBetween(id,id1);
		return "deleted";
	}
//24
	@DeleteMapping("/deleteby/{name}")
	public String deleteByName(@PathVariable String name) {
		
		service.deleteByName(name);
		return "deleted";
	}
//25
	@PutMapping("/bymob/{id}/{mob}")
	public String updateDatabyMobileNo(@PathVariable int id, @PathVariable  long mob){
		
		service.updateDatabyMobileNo(id,mob);
		return "Data Updated SuccesFully";
	}
//26	
	@GetMapping("/byidless/{id}")
	public List<Customer> getDataLessThanId(@PathVariable int id){
		
		return service.getDataLessThanId(id);
	}
//27	
	@GetMapping("/bycityequal/{city}")
	public List<Customer> getDataByEqualAddress(@PathVariable String city){
		
		return service.getDataByEqualStandard(city);
	}
//28	
	@GetMapping("/byagegt/{age}")
	public List<Customer> getDataByGt(@PathVariable int  age){
		
		return service.getDataByGt(age);
	}
//29	
	@GetMapping("/maxage")
	public Customer getMaxAge() {
		
		return service.getMaxAge();
	}
//30	
	@GetMapping("/minage")
	public Customer getMinAge() {
		
		return service.getMinAge();
	}
}
