package com.crwong.spring.member.store;

import org.apache.ibatis.session.SqlSession;

import com.crwong.spring.member.domain.MemberVO;

public interface MemberStore {
	/**
	 * 회원 정보 등록 Service
	 * @param member
	 * @return int
	 */
	int insertMember(SqlSession session, MemberVO member);
	
	/**
	 * 회원 정보 수정 Service
	 * @param member
	 * @return int
	 */
	int updateMember(SqlSession session, MemberVO member);
	
	/**
	 * 회원 정보 삭제 Service
	 * @param memberId
	 * @return int
	 */
	int deleteMember(SqlSession session, String memberId);
	
	/**
	 * 회원 로그인 Service
	 * @param member
	 * @return member
	 */
	MemberVO checkMemberLogin(SqlSession session, MemberVO member);
	
	/**
	 * 회원 아이디 검색 Service
	 * @param String
	 * @return
	 */
	MemberVO selectOneById(SqlSession session, String memberId);
}



