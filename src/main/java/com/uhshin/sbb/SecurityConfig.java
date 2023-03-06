package com.uhshin.sbb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().requestMatchers(
				new AntPathRequestMatcher("/**")).permitAll()
//		.and()	 // http 객체 설정 이어서 할수 있게 하는 메서드
//			.csrf().ignoringRequestMatchers(	// h2-console로 시작하는 URL CSRF 검증 예외 적용
//					new AntPathRequestMatcher("/h2-console/**"))
//		.and()
//			.headers()
//			.addHeaderWriter(new XFrameOptionsHeaderWriter(
//					XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
//					// X-Frame-Options 값 sameorigin 으로 설정하여 h2 로그인후 화면 오류 없도록 설정함
		;
		return http.build();
	}
}
