package edu.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SampleController {
	
	@RequestMapping(value="/sample1.do", method = RequestMethod.GET)
	public String sample1(Model model) {
		
		model.addAttribute("key","�ȳ��ϼ���");
		
		
		
		return "sample/sample01";
	}
	
	@RequestMapping(value="/sample2.do")
	public String sample2(String testData,Model model) {
		/*
		 spring mvc���� �Ķ���͸� �޴� ����� �Ű����� ���� �Ķ���� ��� ��ġ��Ű ����
		 @RequestParam ������̼��� ����ϸ� �ȴ�.
		 �̶� �Ķ���ʹ� �⺻������ ���ڿ� �����͸� ������ �⺻Ÿ�Կ� ���ؼ��� �ڵ� ����ȯ�� �����ϴ�.
		 ���� ����ȯ �� �� ���� �����Ͱ� �Ѿ���� ��� ��û ������ �� �� �����Ƿ� ���� �ؾ��Ѵ�. 
		 
		 */
		model.addAttribute("key", "hello");
		System.out.println("testData:::::::"+testData);
		return "sample/sample02";
	}
}




