package com.mvn.dao;

import java.util.List;
import java.util.Map;

import com.mvn.vo.UserInfoVO;

public interface UserInfoDAO {
	public List<UserInfoVO> selectUserList(Map<String,String> pUser);
	public UserInfoVO selectUser(UserInfoVO user);
	public int insertUser(UserInfoVO user);
	public int updateUser(UserInfoVO user);
	public int deleteUser(UserInfoVO user);
}
