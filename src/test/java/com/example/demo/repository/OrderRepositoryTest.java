package com.example.demo.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;

@SpringBootTest
public class OrderRepositoryTest {

	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void 확인() {
		System.out.println("orderRepository: " + orderRepository);
	}
	
	@Test
	public void 추가() {
		
		Order order1 = new Order(1, "둘리", LocalDate.of(2023, 7, 1), "인천 구월동");
		Order order2 = new Order(2, "또치", LocalDate.of(2023, 7, 2), "인천 연수동");
		Order order3 = new Order(3, "도우너", LocalDate.of(2023, 7, 3), "부산 동래동");
		orderRepository.save(order1);
		orderRepository.save(order2);
		orderRepository.save(order3);
	}
	
	@Test
	public void 데이터단건조회() {
		
		// 조회결과를 optional로 반환 여기서 Id는 pk를 의미함
		Optional<Order> result = orderRepository.findById(1);
		
		// 값이 있는지 확인하고 꺼내기
		if (result.isPresent()) {
			
			Order order = result.get();
			System.out.println(order);
		}
		
	}
	
	@Test
	public void 데이터전체조회or목록조회() {
		
		List<Order> list = orderRepository.findAll();
		
		for (Order order : list) {
			System.out.println(order);
		}
		
	}
	
	@Test
	public void 수정() {
		
		Optional<Order> result = orderRepository.findById(1);
		Order order = result.get();
		order.setCustomerName("고길동");
		orderRepository.save(order);
		
	}
	
	@Test
	public void 데이터단건삭제() {
		
		orderRepository.deleteById(1);
	}
	
	@Test
	public void 데이터전체삭제() {
		
		orderRepository.deleteAll();
	}	
	
	@Test
	public void 주소지가인천_주문검색() {
		
		List<Order> list = orderRepository.get1("인천");
		
		for (Order order : list) {
			System.out.println(order);
		}
	}
	
	@Test
	public void 주문일7월3일_주문검색() {
		
		List<Order> list = orderRepository.get2(Date.valueOf("2023-07-03"));
		
		for (Order order : list) {
			System.out.println(order);
		}
	}
	
}










