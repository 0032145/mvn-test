package com.mvn.service.impl;

import java.util.List;
import java.util.Map;

import com.mvn.dao.UserInfoDAO;
import com.mvn.dao.impl.UserInfoDAOImpl;
import com.mvn.service.UserInfoService;
import com.mvn.vo.UserInfoVO;

public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoDAO uidao = new UserInfoDAOImpl();

	@Override
	public List<UserInfoVO> getUserList(Map<String, String> pUser) {
		return uidao.selectUserList(pUser);
	}
}
