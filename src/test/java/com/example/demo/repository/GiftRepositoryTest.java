package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Gift;

@SpringBootTest
public class GiftRepositoryTest {

	@Autowired
	GiftRepository giftRepository;
	
	@Test
	public void 리파지토리객체를가져왔는지확인() {
		System.out.println("giftRepository = " + giftRepository);
	}
	
	@Test
	public void 데이터추가() {
		
		Gift gift1 = new Gift(1, "참치세트", 10000, "식품");
		Gift gift2 = new Gift(2, "햄세트", 20000, "식품");
		Gift gift3 = new Gift(3, "샴푸세트", 30000, "생활용품");
		Gift gift4 = new Gift(4, "세차용품", 40000, "생활용품");
		Gift gift5 = new Gift(5, "주방용품", 50000, "생활용품");
		Gift gift6 = new Gift(6, "노트북", 60000, "가전제품");
		Gift gift7 = new Gift(7, "벽걸이TV", 70000, "가전제품");
		giftRepository.save(gift1);
		giftRepository.save(gift2);
		giftRepository.save(gift3);
		giftRepository.save(gift4);
		giftRepository.save(gift5);
		giftRepository.save(gift6);
		giftRepository.save(gift7);
		
	}
	
	@Test
	public void 데이터조회() {
		
		Optional<Gift> result = giftRepository.findById(1);
		
		if (result.isPresent()) {
			Gift gift = result.get();
			System.out.println(gift);
		}
	}
	
	@Test
	public void 목록조회() {
		
		List<Gift> list = giftRepository.findAll();
		
		for (Gift gift : list) {
			System.out.println(gift);
		}
	}
	
	@Test
	public void 데이터수정() {
		
		Optional<Gift> result = giftRepository.findById(3);
		Gift gift = result.get();
		gift.setPrice(40000);
		giftRepository.save(gift);
		
	}
	
	@Test
	public void 데이터삭제() {
		giftRepository.deleteById(3);
	}
	
	@Test
	public void 데이터전체삭제() {
		giftRepository.deleteAll();
	}
	
	@Test
	public void 가격50000이상_물건검색() {
		
		List<Gift> list = giftRepository.get1();
		
		for (Gift gift : list) {
			System.out.println(gift);
		}
	}
	
	@Test
	public void 이름이세트로끝나는_물건검색() {
		
		List<Gift> list = giftRepository.get2();
		
		for (Gift gift : list) {
			System.out.println(gift);
		}
	}
	
	@Test
	public void 가격40000이하생활용품_물건검색() {
		
		List<Gift> list = giftRepository.get3();
		
		for (Gift gift : list) {
			System.out.println(gift);
		}
	}

	@Test
	public void 가격50000이상_물건검색2() {
		
		List<Gift> list = giftRepository.get4(50000);
		
		for (Gift gift : list) {
			System.out.println(gift);
		}
	}
	
	@Test
	public void 이름이세트로끝나는_물건검색2() {
		
		List<Gift> list = giftRepository.get5("세트");
		
		for (Gift gift : list) {
			System.out.println(gift);
		}
	}
	
	@Test
	public void 가격40000이하생활용품_물건검색2() {
		
		List<Gift> list = giftRepository.get6(40000, "생활용품");
		
		for (Gift gift : list) {
			System.out.println(gift);
		}
	}
}













