package com.example.spring01.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring01.model.dao.MemberDAO;
import com.example.spring01.model.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	MemberDAO memberDao;

	@Override
	public List<MemberDTO> memberList() {
		return memberDao.memberList();
		// TODO Auto-generated method stub
	}

	@Override
	public void insertMember(MemberDTO vo) {
		memberDao.insertMember(vo);
		// TODO Auto-generated method stub

	}

	@Override
	public MemberDTO viewMember(String userid) {
		
		// TODO Auto-generated method stub
		return memberDao.viewMember(userid);
	}

	@Override
	public void deleteMember(String userid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMember(MemberDTO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkPw(String userid, String passwd) {
		// TODO Auto-generated method stub
		return false;
	}

}
