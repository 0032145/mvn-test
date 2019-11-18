package com.mvn.dao;

import java.util.List;
import java.util.Map;

import com.mvn.vo.UserInfoVO;

public interface UserInfoDAO {
	public List<UserInfoVO> selectUserList(Map<String,String> pUser);
}
