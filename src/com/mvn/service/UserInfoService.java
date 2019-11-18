package com.mvn.service;

import java.util.List;
import java.util.Map;

import com.mvn.vo.UserInfoVO;

public interface UserInfoService {
	public List<UserInfoVO> getUserList(Map<String,String> pUser);
}
