package com.uhshin.sbb.answer;

import com.uhshin.sbb.question.Question;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AnswerService {

	private final AnswerRepository answerRepository;
	
	public void create(Question question, String content) {
		Answer answer = new Answer();
		answer.setContent(content);
		answer.setCreateDate(LocalDateTime.now()); 
		answer.setQuestion(question);
		this.answerRepository.save(answer);
	}
}
