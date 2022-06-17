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
		
		test.put("name","ȫ�浿");
		test.put("age","20");
		
		session = request.getSession();
		
		session.setAttribute("user", test);
		
		return "user/register";
	}
	
	@RequestMapping(value="/register.do", method=RequestMethod.POST)
	public String register(UserVO vo, Model model) {
		/*
			�Ķ���͸� �޼ҵ�� ���� �޴� ����� �Ű������� ���� �Ķ���� Ű�� ���ߴ� �����
			�Ű����� VO�� �ʵ� ���� ���ߴ� ����� �ִ�.
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
		
		return "redirect:/"; //�����̷�Ʈ �Ҷ��� ���� ���ڿ��� redirect: Ű���� �ڷ� url��� ���� �ش�.
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
			//���ǿ� �������� ���� ���� ex.��й�ȣ ���.. ��� ���̵� ȸ����ȣ �̷��� ����
			
			//���ǿ� ���� �α��� ��ü ����
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
		
		//�α��� ��ü�� ��������
		UserVO login = (UserVO)session.getAttribute("login");
		
		//�α��� ��ü�� ������ �����ؿ���
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









