package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// JPA의 리스너 기능을 활성화 (메인 클래스에 있어야 자바 파일 안에 클래스에서 리스너 기능 사용 가능)
// 데이터가 생성 및 수정되는 것을 추적
@EnableJpaAuditing
@SpringBootApplication
public class Project3Application {

	public static void main(String[] args) {
		SpringApplication.run(Project3Application.class, args);
	}

}
