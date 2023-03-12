package com.uhshin.sbb.question;

import java.time.LocalDateTime;
import java.util.List;

import com.uhshin.sbb.answer.Answer;
import com.uhshin.sbb.user.SiteUser;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// @Id 기본키 Primary Key 로 지정
	// @GeneratedValue DB저장시 자동으로 증가
	// strategy = GenerationType.IDENTITY 일정한 고유번호를 갖도록 설정 보통 IDENTITY를 많이 사용
	
	@Column(length = 200)
	private String subject;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	// columnDefinition = "TEXT" 글자수 제한할수 없는 경우 사용
	
	private LocalDateTime createDate;
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	private List<Answer> answerList;

	@ManyToOne
	private SiteUser author;

	private LocalDateTime modifyDate;
}
