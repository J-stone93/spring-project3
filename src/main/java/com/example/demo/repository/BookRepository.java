package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query(value = "select * from tbl_book where title = '자바프로그래밍입문'",nativeQuery = true)
	List<Book> get1();
	
	@Query(value = "select * from tbl_book where price > 30000 and publisher = '남가람북스'", nativeQuery = true)
	List<Book> get2();
	
	@Query(value = "select * from tbl_book where publisher = '한빛출판사' or publisher = '이지스퍼블리싱'", nativeQuery = true)
	List<Book> get3();
	
//	@Query(" select m from Memo m where m.no < :mno ")
//	List<Memo> get1(@Param("mno") int mno);
	
	@Query(" select b from Book b where b.title = :btitle ")
	List<Book> get4(@Param("btitle") String btitle);
	
	@Query(" select b from Book b where b.price > :bprice and b.publisher = :bpublisher ")
	List<Book> get5(@Param("bprice") int bprice, @Param("bpublisher") String bpublisher);
	
	@Query(" select b from Book b where b.publisher = :bpublisher1 or b.publisher = :bpublisher2 ")
	List<Book> get6(@Param("bpublisher1") String bpublisher1, @Param("bpublisher2") String bpublisher2);
}













