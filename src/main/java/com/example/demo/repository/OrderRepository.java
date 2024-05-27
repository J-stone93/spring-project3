package com.example.demo.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

	// 순수한 SQL
	@Query(value = "select * from tbl_order where ship_address like :ship_address%", nativeQuery = true)
	List<Order> get1(@Param("ship_address") String ship_address);
	
	@Query(value = "select * from tbl_order where order_date = :order_date", nativeQuery = true)
	List<Order> get2(@Param("order_date") LocalDate order_date);
	
	@Query( " select o from Order o where o.shipAddress like :oship_address% " )
	List<Order> get3(@Param("oship_address") String oship_address);
	
	@Query( " select o from Order o where o.orderDate = :order_date " )
	List<Order> get4(@Param("order_date") Date order_date);
}
