package com.uhshin.sbb.question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	// JpaRepository 를 상속할때 리포지터리의 대상이 되는 엔티티의 타입(Question)과
	// 해당 엔티티의 PK의 속성 타입(Integer)를 지정해야 한다.
	// JpaRepository를 생성하기 위한 규칙이다.

	Question findBySubject(String subject);
	Question findBySubjectAndContent(String subject, String content);
	List<Question> findBySubjectLike(String subject);
	Page<Question> findAll(Pageable pageable);
}
