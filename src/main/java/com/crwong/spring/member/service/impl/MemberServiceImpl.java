package com.crwong.spring.member.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crwong.spring.member.domain.MemberVO;
import com.crwong.spring.member.service.MemberService;
import com.crwong.spring.member.store.MemberStore;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberStore mStore;
	@Autowired
	private SqlSession session;
	
	@Override
	public int insertMember(MemberVO member) {
		int result = mStore.insertMember(session, member);
		return result;
	}

	@Override
	public int updateMember(MemberVO member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String memberId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO checkMemberLogin(MemberVO member) {
		MemberVO result = mStore.checkMemberLogin(session, member);
		return result;
	}

	@Override
	public MemberVO selectOneById(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
