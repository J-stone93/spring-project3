package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Member;

@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	MemberRepository memberRepository;
	
	@Test
	public void 확인() {
		System.out.println("memberRepository: " + memberRepository);
	}
	
	@Test
	public void 추가() {
		
		Member member1 = new Member("admin", "관리자", "1234", null);
		Member member2 = new Member("user", "사용자", "1234", null);
		memberRepository.save(member1);
		memberRepository.save(member2);
		
	}
	
	@Test
	public void 조회() {
		
		Optional<Member> result = memberRepository.findById("admin");

		if (result.isPresent()) {
			Member member = result.get();
			System.out.println(member);
		}
		
	}
	
	@Test
	public void 목록조회() {
		
		List<Member> list = memberRepository.findAll();
		
		for (Member member : list) {
			System.out.println(member);
		}
		
	}
	
	@Test
	public void 수정() {
		
		Optional<Member> result = memberRepository.findById("user");
		Member member = result.get();
		member.setPassword("5678");
		memberRepository.save(member);
		
	}
	
	@Test
	public void 데이터단건삭제() {
		
		memberRepository.deleteById("admin");
	}
	
	@Test
	public void 데이터전체삭제() {
		
		memberRepository.deleteAll();
	}	
}


















