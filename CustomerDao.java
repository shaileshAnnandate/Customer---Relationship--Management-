package com.CRM.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.CRM.entity.Customer;

@Repository
public class CustomerDao {

	@Autowired
	SessionFactory sf;

	public List<Customer> getAll() {

		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Customer.class);
		List<Customer> list = cr.list();
		return list;
	}

	public String insertCust(Customer cc) {

		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(cc);
		tr.commit();
		session.close();
		
		return "inserted";
	}

	public String updateCust(Customer cc) {

		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.update(cc);
		tr.commit();
		session.close();
		
		return "updated";
	}

	public String delete(int id) {

		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Customer cc=session.load(Customer.class, id);
		session.delete(cc);
		tr.commit();
		session.close();
		return "deleted";
	}

	public List<String> getCustNames(String city) {

		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Customer.class);
		cr.add(Restrictions.eq("city", city));
		List<Customer>aa=cr.list();
		List<String>list=new ArrayList<>();
		for (Customer customer : aa) {
			
			list.add(customer.getName());
		}
		return list;
	}

	public String insertMultiData(List<Customer> list) {

		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		for (Customer customer : list) {
			
			session.save(customer);
		}
		tr.commit();
		session.close();
		return "inserted";
	}

	public Customer getById(int id) {

		Session session=sf.openSession();
       Customer cc= session.get(Customer.class, id);		
		return cc;
	}

	public List<Customer> getByName(String name) {

		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Customer.class);
		cr.add(Restrictions.eq("name", name));
		List<Customer>list=cr.list();
		return list;
	}

	public List<Customer> getByEmail(String email) {

		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Customer.class);
		cr.add(Restrictions.eqOrIsNull("email", email));
		List<Customer>list=cr.list();
		return list;
	}

	public List<Customer> getByCity(String city) {

		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Customer.class);
		cr.add(Restrictions.eqOrIsNull("city", city));
		List<Customer>list=cr.list();
		return list;
	}

	public List<Customer> getByMobileNo(long mob) {

		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Customer.class);
		cr.add(Restrictions.eqOrIsNull("mob", mob));
		List<Customer>list=cr.list();
		return list;
	}

	public List<Customer> getByAge(int age) {

		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Customer.class);
		cr.add(Restrictions.eqOrIsNull("age", age));
		List<Customer>list=cr.list();
		return list;	}

	public List<Customer> getBetweenId(int id, int id1) {

		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Customer.class);
		cr.add(Restrictions.between("id", id, id1));
		List<Customer>list=cr.list();
		return list;
	}

	public List<Customer> getBetweenName(String name, String name1) {

		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Customer.class);
		cr.add(Restrictions.between("name", name, name1));
		List<Customer>list=cr.list();
		return list;
		}

	public List<Customer> byNameLike(String name) {

		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Customer.class);
		cr.add(Restrictions.like("name", name));
		List<Customer>list=cr.list();
		return list;
	}

	public String updateData(int id, String name) {

		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Customer cc=session.get(Customer.class, id);
		cc.setName(name);
		session.save(cc);
		tr.commit();
		session.close();
		return "update";
	}

	public List<Customer> getByQuery() {

		Session session=sf.openSession();
		List<Customer>list=session.createQuery("from Customer").list();
		return list;
	}

	public List<Customer> byLessThan(int age) {

		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Customer.class);
		cr.add(Restrictions.le("age", age));
		List<Customer>list=cr.list();
		return list;
	}

	public String updateDataByCity(int id, String city) {

		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Customer cc=session.get(Customer.class, id);
		cc.setCity(city);
		session.save(cc);
		tr.commit();
		session.close();
		return "updated";
	}

	public String updateDatabyMail(int id, String email) {

		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Customer cc=session.get(Customer.class, id);
		cc.setEmail(email);
		session.save(cc);
		tr.commit();
		session.close();
		return "Updated";
	}

	public String updateDatabyAge(int id, int age) {

		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Customer cc=session.get(Customer.class, id);
		cc.setAge(age);
		session.save(cc);
		tr.commit();session.close();
		return "update";
	}

	public List<Customer> getDataBetweenCity(String city, String city1) {

		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Customer.class);
		cr.add(Restrictions.between("city", city, city1));
		List<Customer>list=cr.list();
		return list;
	}

	public String deleteBetween(int id, int id1) {

		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Criteria cr=session.createCriteria(Customer.class);
		cr.add(Restrictions.between("id", id, id1));
		List<Customer>list=cr.list();
		for (Customer customer : list) {
			
			session.delete(customer);
		}
		tr.commit();
		session.close();
		return "deleted";
	}

	public String deleteByName(String name) {

		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Criteria cr=session.createCriteria(Customer.class);
		cr.add(Restrictions.eq("name", name));
		List<Customer>list=cr.list();
		for (Customer customer : list) {
			
			session.delete(customer);
		}
		tr.commit();
		session.close();
		return "delete";
	}

	public String updateDatabyMobileNo(int id, long mob) {

		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Customer cc=session.get(Customer.class, id);
		cc.setMob(mob);
		session.save(cc);
		tr.commit();
		session.close();
		return "updated";
	}

	public List<Customer> getDataLessThanId(int id) {

		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Customer.class);
		cr.add(Restrictions.le("id", id));
		List<Customer>list=cr.list();
		
		return list;
	}

	public List<Customer> getDataByEqualStandard(String city) {

		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Customer.class);
		cr.add(Restrictions.eq("city", city));
		List<Customer>list=cr.list();
		return list;
	}

	public List<Customer> getDataByGt(int age) {

		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Customer.class);
		cr.add(Restrictions.gt("age", age));
		List<Customer>list=cr.list();
		return list;
	}

	public Customer getMaxAge() {

		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Customer.class);
		cr.addOrder(Order.desc("age"));
		List<Customer>list=cr.list();
		Customer cc=list.get(0);
		
		return cc;
	}

	public Customer getMinAge() {

		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Customer.class);
		cr.addOrder(Order.asc("age"));
		List<Customer>list=cr.list();
		Customer cc=list.get(0);
		return cc;
	}

}
