package com.uhshin.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uhshin.sbb.answer.AnswerForm;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

	private final QuestionService questionService;
	//private final QuestionRepository questionRepository;
	
	@GetMapping("/list")
	public String list(Model model){
		List<Question> questionList = this.questionService.getList();
		//List<Question> questionList = this.questionRepository.findAll();
		// 실제 프로젝트에서 이렇게 하면 안될듯 한다.. 질문 개수가 많아지면 당연히 성능에 문제가 생기겠지..
		model.addAttribute("questionList", questionList);
		return "question_list";
	}
	
//	@GetMapping("/list")
//	//@ResponseBody
//	public String list() {
//		return "question_list";  // 템플릿 파일의 이름이다.
//		// return "question list"
//	}
	
	@GetMapping(value = "/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "question_detail";
	}
	
	@GetMapping("/create") // GET 으로 질문 양식 가져오기
	public String questionCreate(QuestionForm questionForm) {
		return "question_form";
	}
	
	// POST 로 질문 저장하기
	@PostMapping("/create") 
	public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
		// TODO 질문을 저장한다.
		if(bindingResult.hasErrors()) {
			return "question_form";
		}
		this.questionService.create(questionForm.getSubject(), questionForm.getContent());
		return "redirect:/question/list";	// 질문 저장후 질문 목록으로 이동한다.
	}
}
