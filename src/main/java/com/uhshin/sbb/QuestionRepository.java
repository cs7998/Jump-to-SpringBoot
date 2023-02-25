package com.uhshin.sbb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	// JpaRepository 를 상속할때 리포지터리의 대상이 되는 엔티티의 타입(Question)과
	// 해당 엔티티의 PK의 속성 타입(Integer)를 지정해야 한다.
	// JpaRepository를 생성하기 위한 규칙이다.

}
