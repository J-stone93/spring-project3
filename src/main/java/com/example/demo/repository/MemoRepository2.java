package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Memo;

import jakarta.transaction.Transactional;

// 쿼리메소드를 사용해서 함수 만들기
@Transactional // delete를 수행하기 위해 commit(반영)이 필요한데 어노테이션이 commit을 만들어줌
public interface MemoRepository2 extends JpaRepository<Memo, Integer>{
	
	// 메모의 번호가 10에서 20 사이인 데이터 검색
	// select * from tbl_memo where no between ? and ?
	List<Memo> findByNoBetween(int from, int to);
	
	// 메모의 번호가 10보다 작은 데이터 검색
	// select * from tbl_memo where no < ?
	List<Memo> findByNoLessThan(int mno);
	
	// 메모의 번호를 기준으로 역정렬
	// select * from tbl_memo order by no desc
	List<Memo> findAllByOrderByNoDesc();
	
	// 메모의 번호가 3보다 작은 데이터 삭제
	// delete from tbl_memo where no < ?
	void deleteMemoByNoLessThan(int mno);
	
}






