package com.mvn.controller;

import java.io.InputStream;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mvn.dao.impl.UserInfoDAOImpl;

/**
 * Servlet implementation class InitServlet
 */
@WebServlet(name="Init", urlPatterns = {"/init"}, loadOnStartup = 1)
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static SqlSessionFactory ssf;
	static {
		String path = "/config/mybatis-config.xml";
		InputStream is = UserInfoDAOImpl.class.getResourceAsStream(path);
		ssf = new SqlSessionFactoryBuilder().build(is);
	}
	public void init() {
	}
	public static SqlSession getSqlSession() {
		return ssf.openSession();
	}
}