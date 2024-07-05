package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EUserBean;

//singleton -> new -> @Autowired 
@Repository
public class EUserDao {

	@Autowired // instance eject
	JdbcTemplate stmt; // update() query()

	public void insertUser(EUserBean userBean) {
		// query ->
		stmt.update("insert into users(firstName,email,password,profilePicpath) values (?,?,?,?) ", userBean.getFirstName(),
				userBean.getEmail(), userBean.getPassword(), userBean.getProfilePicPath());

	}
	// int
	// boolean
	// EuserBean
	// welcome , Ram
	// addTocart userId

	public EUserBean authenticate(String email, String password) {
		// select * from users where email = ? and password = ?
		try {
			EUserBean userBean = stmt.queryForObject("select * from users where email = ? and password = ?",
					new BeanPropertyRowMapper<>(EUserBean.class), new Object[] { email, password });

			return userBean;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;// invalid
	}
	// query -> select * -> 1+ -> n
	// queryForObject -> select -> 1 record { 0 1+ throw exception}
	// update -> insert update delete

}

//controller -> USerBEan user  -> dao->insertUser(user) 

//dao -> insertUser()
