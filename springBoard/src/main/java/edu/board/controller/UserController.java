package edu.board.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.board.service.UserService;
import edu.board.service.UserServiceImple;
import edu.board.vo.UserVO;

@RequestMapping(value="/user")
@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	
	@RequestMapping(value="/register.do", method=RequestMethod.GET)
	public String register(HttpServletRequest request, HttpSession session) {
		HashMap<String,String> test = new HashMap<String,String>();
		
		test.put("name","홍길동");
		test.put("age","20");
		
		session = request.getSession();
		
		session.setAttribute("user", test);
		
		return "user/register";
	}
	
	@RequestMapping(value="/register.do", method=RequestMethod.POST)
	public String register(UserVO vo, Model model) {
		/*
			파라미터를 메소드로 전달 받는 방법은 매개변수의 명을 파라미터 키와 맞추는 방법과
			매개변수 VO의 필드 명을 맞추는 방법이 있다.
		*/
		/*
		 * model.addAttribute("name",name); model.addAttribute("age",age);
		 * model.addAttribute("addr",addr); model.addAttribute("phone",phone);
		 */
		model.addAttribute("vo",vo);
		
		
		return "user/info";
		
	}
	
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String join() {
		
		return "user/join";
	}
	
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public String join(UserVO vo) {
		
		int result = userService.insertUser(vo);
		
		return "redirect:/"; //리다이렉트 할때는 리턴 문자열에 redirect: 키워드 뒤로 url경로 값을 준다.
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, HttpServletRequest request, HttpSession session) {
		
		UserVO user = userService.selectByLogin(vo);
		
		if(user != null) {
			
			session = request.getSession();
			//세션에 개인정보 넣지 않음 ex.비밀번호 등등.. 대신 아이디 회원번호 이런거 넣음
			
			//세션에 담을 로그인 객체 생성
			UserVO login = new UserVO();
			login.setMidx(user.getMidx());
			login.setId(user.getId());
			login.setName(user.getName());
			
			session.setAttribute("login", login);
			
			return "redirect:/";
		}else {
			return "redirect:/user/login.do";
		}
		
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpServletRequest request, HttpSession session) {
		
		session = request.getSession();
		session.invalidate();
		/*
		 UserVO vo = (UserVO)session.getAttribute("login");
		 int midx = vo.getMidx();
		*/
		return "redirect:/";
		
	}
	
	@RequestMapping(value="/mypage.do")
	public String myPage(HttpServletRequest request, HttpSession session, Model model) {
		
		session = request.getSession();
		
		//로그인 객체를 꺼내오기
		UserVO login = (UserVO)session.getAttribute("login");
		
		//로그인 객체의 상세정보 추출해오기
		UserVO vo = userService.selectByMypage(login.getMidx());
		
		model.addAttribute("vo",vo);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/modify.do")
	public String modify(int midx, Model model) {
		
		UserVO vo = userService.selectByMypage(midx);
		
		model.addAttribute("vo",vo);
		
		return "user.modify";
	}
}









