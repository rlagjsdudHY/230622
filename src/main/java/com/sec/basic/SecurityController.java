package com.sec.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityController {

		@RequestMapping("/")
		public @ResponseBody String root() {
			return "시큐리티의 이해";
		}
		
		//게스트용 패턴
		@RequestMapping("/guest/welcome")
		public String guestWelcome() {
			return "guest/guestWelcome";
		}
		
		//회원용 패턴
		@RequestMapping("/member/welcome")
		public String memberWelcome() {
			return "member/memberWelcome";
		}
		//관리자용 패턴
		@RequestMapping("/admin/welcome")
		public String adminWelcome() {
			return "admin/adminWelcome";
		}
		
//		로그인	폼
		@RequestMapping("/loginForm")
		public	String	loginForm()	{
		return	"security/loginForm";
		}
 
		
}
