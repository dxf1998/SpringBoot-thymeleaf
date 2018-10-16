package com.dxf.controller;
/**
 * author 独善其身的狗
 * date 2018-10-16
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dxf.model.Member;
import com.dxf.util.controller.AbstractBaseController;

@Controller
public class MemberController extends AbstractBaseController {
	@RequestMapping(value = "/member/set", method = RequestMethod.GET)
	public String set(Model model) {
		Set<String> allNames = new HashSet<String>() ;
		List<Integer> allIds = new ArrayList<Integer>() ;
		for (int x = 0 ; x < 5 ; x ++) {
			allNames.add("悟空来-" + x) ;
			allIds.add(x) ;
		}
		model.addAttribute("names", allNames) ;
		model.addAttribute("ids", allIds) ;
		model.addAttribute("mydate", new java.util.Date()) ;
		return "member/member_set" ;
	}
	

	
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Member> allMembers = new ArrayList<Member>();
		for (int x = 0; x < 10; x++) {
			Member vo = new Member();
			vo.setMid(101L + x);
			vo.setName("大师兄 - " + x);
			vo.setAge(9);
			vo.setSalary(99999.99);
			vo.setBirthday(new Date());
			allMembers.add(vo) ;
		}
		model.addAttribute("allMembers", allMembers);
		return "member/member_list";
	}
}
