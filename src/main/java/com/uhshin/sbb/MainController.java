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
//	public void index() {
//		System.out.println("index");
//	}  @ResponseBody 없이는 500 Internal Error 발생함
}
