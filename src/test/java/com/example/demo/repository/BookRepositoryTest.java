package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;

@SpringBootTest
public class BookRepositoryTest {

	@Autowired
	BookRepository bookRepository;
	
	@Test
	public void 리파지토리확인() {
		System.out.println("bookRepository: " + bookRepository);
	}
	
	@Test
	public void 데이터추가() {
		
		Book book1 = new Book(1, 20000, "한빛출판사", "자바프로그래밍입문");
		Book book2 = new Book(2, 25000, "남가람북스", "스프링부트프로젝트");
		Book book3 = new Book(3, 40000, "남가람북스", "실무로 끝내는 PHP");
		Book book4 = new Book(4, 35000, "이지스퍼블리싱", "알고리즘코딩테스트");
		bookRepository.save(book1);
		bookRepository.save(book2);
		bookRepository.save(book3);
		bookRepository.save(book4);
		
	}
	
	@Test
	public void 데이터조회() {
		
		Optional<Book> result = bookRepository.findById(1);
		
		if (result.isPresent()) {
			Book book = result.get();
			System.out.println(book);
		}
	}
	
	@Test
	public void 목록조회() {
		
		List<Book> list = bookRepository.findAll();
		
		for (Book book : list) {
			System.out.println(book);
		}
	}
	
	@Test
	public void 데이터수정() {
		
		Optional<Book> result = bookRepository.findById(3);
		Book book = result.get();
		book.setPublisher("한빛출판사");
		bookRepository.save(book);
		
	}
	
	@Test
	public void 데이터삭제() {
		bookRepository.deleteById(3);
	}
	
	@Test
	public void 데이터전체삭제() {
		bookRepository.deleteAll();
	}
	
	// 순수한 SQL
	@Test
	public void 자바프로그래밍입문_데이터검색() {
		
		List<Book> list = bookRepository.get1();
		
		for (Book book : list) {
			System.out.println(book);
		}
	}
	
	@Test
	public void 가격30000이상남가람북스인_데이더검색() {
		
		List<Book> list = bookRepository.get2();
		
		for (Book book : list) {
			System.out.println(book);
		}
	}
	
	@Test
	public void 출판사한빛또는이지스인_데이터검색() {
		
		List<Book> list = bookRepository.get3();
		
		for (Book book : list) {
			System.out.println(book);
		}
	}
	
	// JPQL
	@Test
	public void 자바프로그래밍입문_데이터검색2() {
		
		List<Book> list = bookRepository.get4("자바프로그래밍입문");
		
		for (Book book : list) {
			System.out.println(book);
		}
	}
	
	@Test
	public void 가격30000이상남가람북스인_데이더검색2() {
		
		List<Book> list = bookRepository.get5(30000, "남가람북스");
		
		for (Book book : list) {
			System.out.println(book);
		}
	}
	
	@Test
	public void 출판사한빛또는이지스인_데이터검색2() {
		
		List<Book> list = bookRepository.get6("한빛출판사", "이지스퍼블리싱");
		
		for (Book book : list) {
			System.out.println(book);
		}
	}
}











