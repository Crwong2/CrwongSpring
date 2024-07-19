package com.crwong.spring.member.service;

import com.crwong.spring.member.domain.MemberVO;

public interface MemberService {
	/**
	 * 회원 정보 등록 Service
	 * @param member
	 * @return int
	 */
	int insertMember(MemberVO member);
	
	/**
	 * 회원 정보 수정 Service
	 * @param member
	 * @return int
	 */
	int updateMember(MemberVO member);
	
	/**
	 * 회원 정보 삭제 Service
	 * @param memberId
	 * @return int
	 */
	int deleteMember(String memberId);
	
	/**
	 * 회원 로그인 Service
	 * @param member
	 * @return member
	 */
	MemberVO checkMemberLogin(MemberVO member);
	
	/**
	 * 회원 아이디 검색 Service
	 * @param String
	 * @return
	 */
	MemberVO selectOneById(String memberId);
}
