package com.mvn.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mvn.controller.InitServlet;
import com.mvn.dao.UserInfoDAO;
import com.mvn.vo.UserInfoVO;

public class UserInfoDAOImpl implements UserInfoDAO {

	private SqlSessionFactory ssf;

	@Override
	public List<UserInfoVO> selectUserList(Map<String, String> pUser) {
		SqlSession ss = InitServlet.getSqlSession();
		try {
			return ss.selectList("UserInfo.selectUserList", pUser);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return null;
	}

	public static void main(String[] args) {
		UserInfoDAO udao = new UserInfoDAOImpl();
		Map<String, String> pUser = new HashMap<>();
		System.out.println(udao.selectUserList(pUser));
	}

}
