package com.example.spring01.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring01.model.dto.MemberDTO;
import com.example.spring01.service.MemberService;

@Controller
public class MemberController {
	private static final Logger Logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService memberService;
	
	@RequestMapping("member/list.do")
	public String memberList(Model model) {
		List<MemberDTO> list = memberService.memberList();
		model.addAttribute("list",list);
		return "member/member_list";
	}
	
	@RequestMapping("member/insert.do")
	public String insertMember(@ModelAttribute MemberDTO dto) {
		//@ModelAttribute MemberDTO dto 하면 일일이
		// request.getParameter로 값을 전달하지 않아도 됨
		memberService.insertMember(dto);
		return "redirect:/member/list.do";
		// 만약 redirect를 붇이지 않으면 포워드가 되어 주소가 바뀌지 않음
	}
	
	//view.do?userid=kim 이라면
	//@RequestParam String userid 변수에 kim이 저장됨
	@RequestMapping("member/view.do")
	public String view(@RequestParam String userid, Model model) {
		model.addAttribute("dto",memberService.viewMember(userid));
		return "member/view";
	}
	
	//@ModelAttribute는 폼의 전체 데이터를 전달함, 즉 dto
	//@RequestParam 는 폼의 개별 데이터를 전달함
	
	@RequestMapping("member/update.do")
	public String update(@ModelAttribute MemberDTO dto, Model model) {
		Logger.info("아이디 : " + dto.getUserid());
		Logger.info("비밀번호 : " + dto.getPasswd());
		boolean result = memberService.checkPw(dto.getUserid(), dto.getPasswd());
		Logger.info("비밀번호 확인: " + result);
		if(result) {
			memberService.updateMember(dto);
			return "redirect:/member/list.do";
		} else {
			MemberDTO dto2 = memberService.viewMember(dto.getUserid());
			dto.setJoin_date(dto2.getJoin_date());
			model.addAttribute("dto",dto);
			model.addAttribute("message","비밀번호가 일치하지 않습니다");
			return "member/view";
		}
	}
	
	@RequestMapping("member/delete.do")
	public String delete(@ModelAttribute MemberDTO dto, Model model) {
		Logger.info("아이디 : " + dto.getUserid());
		Logger.info("비밀번호 : " + dto.getPasswd());
		boolean result = memberService.checkPw(dto.getUserid(), dto.getPasswd());
		Logger.info("비밀번호 확인: " + result);
		if(result) {
			memberService.deleteMember(dto.getUserid());
			return "redirect:/member/list.do";
		} else {
			MemberDTO dto2 = memberService.viewMember(dto.getUserid());
			dto.setJoin_date(dto2.getJoin_date());
			model.addAttribute("dto",dto);
			model.addAttribute("message","비밀번호가 일치하지 않습니다");
			return "member/view";
		}
	}

}
