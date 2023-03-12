package com.uhshin.sbb;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.uhshin.sbb.answer.Answer;
import com.uhshin.sbb.answer.AnswerRepository;
import com.uhshin.sbb.question.Question;
import com.uhshin.sbb.question.QuestionRepository;
import com.uhshin.sbb.question.QuestionService;


@SpringBootTest
class SbbApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
//	@Autowired
//	private QuestionRepository questionRepository;
//	
//	@Autowired
//	private AnswerRepository answerRepository;

//	@Test
//	void testJpa() {
//  질문 생성
//		Question q1 = new Question();
//		q1.setSubject("sbb가 뭐예요?");
//		q1.setContent("sbb가 궁금해요");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1);	// 첫번째 질문 저장
//		
//		Question q2 = new Question();
//		q2.setSubject("스프링부트 모델 질문입니다.");
//		q2.setContent("id는 자동으로 생성될까요?");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2);	// 두번째 질문 저장

//		findAll() 조회 테스트
//		List<Question> all = this.questionRepository.findAll();
//		assertEquals(3, all.size());
//		
//		Question q = all.get(0);
//		assertEquals("sbb가 뭐예요?", q.getSubject());

		// findById
//		Optional<Question> oq = this.questionRepository.findById(1);
//		if(oq.isPresent()) {
//			Question q = oq.get();
//			assertEquals("sbb가 뭐예요?", q.getSubject());
//		}
		
		// findBySubject
//		Question q = this.questionRepository.findBySubject("sbb가 뭐예요?");
//		assertEquals(1, q.getId());
		
		// findBySubjectAndContent
//		Question q = this.questionRepository.findBySubjectAndContent("sbb가 뭐예요?", "sbb가 궁금해요");
//		assertEquals(1, q.getId());
		
		// findBySubjectLike
//		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//		Question q = qList.get(0);
//		assertEquals("sbb가 뭐예요?", q.getSubject());
		
		// Optional 질문 데이터 수정
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		q.setSubject("수정된 제목");
//		this.questionRepository.save(q);
		
		// 첫번째 질문 삭제 - 실습교재에는 질문 2개 입력후 삭제이지만 3개 입력하여 변경함
//		assertEquals(3, this.questionRepository.count());
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		this.questionRepository.delete(q);
//		assertEquals(2, this.questionRepository.count());
		
		// 답변 데이터 생성 후 저장하기
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		
//		Answer a = new Answer();
//		a.setContent("네 자동으로 생성됩니다.");
//		a.setQuestion(q);
//		a.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(a);
		
		// 답변 조회하기
//		Optional<Answer> oa = this.answerRepository.findById(1);
//		assertTrue(oa.isPresent());
//		Answer a = oa.get();
//		assertEquals(2, a.getQuestion().getId());
//	}
	
//	@Transactional
//	@Test
//	void testGetAnswerListQuestion() {
//		// 질문에 연결된 답변 찾기 - 질문 객체로 부터 답변 리스트 구하는 테스트 코드
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		
//		List<Answer> answerList = q.getAnswerList();
//		
//		assertEquals(1, answerList.size());
//		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
//	}
	
    @Autowired
    private QuestionService questionService;
    
    @Test
    void testJpa() {
        for (int i = 1; i <= 300; i++) {
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content = "내용무";
            this.questionService.create(subject, content, null);
        }
    }
}
