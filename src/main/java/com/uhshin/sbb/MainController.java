package com.uhshin.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@GetMapping("/sbb")
	@ResponseBody
	public String index() {
		return "안녕하세요 sbb에 오심을 환영하오~";
	}
	
	@GetMapping("/")
	public String root() {
		return "redirect:/question/list";
	}
	// redirect:<URL> URL 로 리다이렉트 - 완전히 새로운 URL 로 요청된다.
	// forward:<URL> URL로 포워드 - 기존 요청값이 유지된 상태로 URL이 전환된다.
	
//	public void index() {
//		System.out.println("index");
//	}  @ResponseBody 없이는 500 Internal Error 발생함
}
