package com.crwong.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.crwong.spring.member.domain.MemberVO;
import com.crwong.spring.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService mService;
	
	// @RequestMapping() -> Model model -> String -> return "";
	@RequestMapping(value="/member/register.kh", method=RequestMethod.GET)
	public String showRegisterForm(Model model) {
		return "member/insert";
	}
	
	@RequestMapping(value="/member/register.kh", method=RequestMethod.POST)
		public String insertMember(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("memberId") String memberId,
			@RequestParam("memberPw") String memberPw,
			@RequestParam("memberName") String memberName,
			@RequestParam(value="memberAge", required=false, defaultValue="0") int memberAge,
			@RequestParam(value="memberGender", required=false) String memberGender,
			@RequestParam(value="memberEmail", required=false) String memberEmail,
			@RequestParam(value="memberPhone", required=false) String memberPhone,
			@RequestParam(value="memberAddress", required=false) String memberAddress,
			Model model) {
//		String memberId = request.getParameter("memberId");
//		String memberPw = request.getParameter("memberPw");
		try {
			MemberVO member = new MemberVO(memberId, memberPw, memberName, memberAge, memberGender, memberEmail, memberPhone, memberAddress);
			int result = mService.insertMember(member);
			if(result > 0) {
				// 메인페이지로 이동
				return "redirect:/index.jsp";
			}else {
				// 에러 페이지로 이동
				model.addAttribute("msg", "회원가입이 완료되지 않았습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			// 에러 페이지로 이동
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/member/login.kh", method=RequestMethod.POST)
	public String checkLogin(Model model

			, HttpSession session
			, @RequestParam("memberId") String memberId
			, @RequestParam("memberPw") String memberPw) {
		try {
			MemberVO member = new MemberVO();
			member.setMemberId(memberId);
			member.setMemberPw(memberPw);
			member = mService.checkMemberLogin(member);
			if(member != null) {
				// 로그인 성공 후 세션에 정보 저장
				session.setAttribute("memberId", member.getMemberId());
				session.setAttribute("memberName", member.getMemberName());
				return "redirect:/";
			}else {
				// 로그인 실패
				model.addAttribute("msg", "로그인이 완료되지 않았습니다");
				return "common/errorPage";
			}
		} catch (Exception e) {
			// 그 외의 예외 발생시(쿼리문 오타, Null PointerException 등 ...)
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/member/logout.kh", method=RequestMethod.GET)
	public String memberLogout(Model model, HttpSession session) {
		try {
			if(session != null) {
				session.invalidate();
				return "redirect:/";
			}else {
				model.addAttribute("msg", "로그아웃을 완료하지 못하였습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
}
