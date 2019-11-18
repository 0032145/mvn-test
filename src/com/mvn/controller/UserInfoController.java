package com.mvn.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mvn.service.UserInfoService;
import com.mvn.service.impl.UserInfoServiceImpl;
import com.mvn.vo.UserInfoVO;

/**
 * Servlet implementation class UserInfoController
 */
@WebServlet(name = "UserInfoController", urlPatterns = {"/user/*"})
public class UserInfoController extends HttpServlet {
	private String charSet = "utf-8";
	private static final long serialVersionUID = 1L;
	private UserInfoService uis = new UserInfoServiceImpl();
	private Gson gson = new Gson();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		if ("uiList".equals(cmd)) {
		List<UserInfoVO> uiList = uis.getUserList(null);
		response.getWriter().print(gson.toJson(uiList));
		HttpServletRequest req = (HttpServletRequest)request;
		req.setCharacterEncoding(this.charSet);
		HttpServletResponse res = (HttpServletResponse)response;
		res.setContentType("application/json;charset=" + this.charSet);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
