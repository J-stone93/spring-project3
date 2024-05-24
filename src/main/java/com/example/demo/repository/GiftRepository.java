package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Gift;

public interface GiftRepository extends JpaRepository<Gift, Integer>{

	// 순수한 SQl
	@Query(value = "select * from tbl_gift where price >= 50000", nativeQuery = true)
	List<Gift> get1();
	
	@Query(value = "select * from tbl_gift where name like '%세트'", nativeQuery = true)
	List<Gift> get2();
	
	@Query(value = "select * from tbl_gift where price <= 40000 and type = '생활용품'", nativeQuery = true)
	List<Gift> get3();
	
	// JPQl
	@Query("select g from Gift g where g.price >= :gprice")
	List<Gift> get4(@Param("gprice") int gprice);
	
	@Query("select g from Gift g where g.name like '%세트'")
	List<Gift> get5(@Param("gname") String gname);
	
	@Query("select g from Gift g where g.price <= :gprice and g.type = :gtype")
	List<Gift> get6(@Param("gprice") int gprice, @Param("gtype") String gtype);
}








