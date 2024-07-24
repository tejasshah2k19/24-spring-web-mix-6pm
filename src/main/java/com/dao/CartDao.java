package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ECartBean;
import com.bean.EProductBean;

@Repository
public class CartDao {

	@Autowired
	JdbcTemplate stmt;

	public void addToCart(ECartBean cartBean) {

		// userId and productId

		// if product is already added then increase the qty

		// if product is not added then add in to a cart with qty 1

		ECartBean cart = null;

		try {
			cart = stmt.queryForObject("select * from cart where productId = ? and userId = ? ",
					new BeanPropertyRowMapper<>(ECartBean.class),
					new Object[] { cartBean.getProductId(), cartBean.getUserId() });
		} catch (Exception e) {

		}

		if (cart == null) {
			stmt.update("insert into cart (productId,userId,qty) values (?,?,?)", cartBean.getProductId(),
					cartBean.getUserId(), 1);
		} else {
			stmt.update("update cart set qty = ? where productId =? and userId = ? ", cart.getQty() + 1,
					cart.getProductId(), cart.getUserId());
		}

	}

	public List<EProductBean> myCart(Integer userId) {
		// select * from products join cart using (productId) where userId= 1;

		List<EProductBean> products = stmt.query(" select * from products join cart using (productId) where userId= ?",
				new BeanPropertyRowMapper<>(EProductBean.class), new Object[] { userId });
		return products;
	}

	// productId userId
}
//@Autowired 

//cart  new 
//order new 
//orderHistory new  