package com.tomcat.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class BackJson
 */
@WebServlet("/b")
public class BackJson extends HttpServlet {
	private static final long serialVersionUID = 2L;

	private User getUser() {
		User user = new User();
		user.setName("������");
		user.setAge(18);
		user.setBirthDay(new Date());
		user.setPassword("54321");
		return user;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BackJson() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * response.setContentType("application/json; charset=utf-8");
		 * response.setCharacterEncoding("UTF-8");
		 * 
		 * String userJson; try { userJson = JSONObject.valueToString(buildUserDO());
		 * ServletOutputStream out = response.getOutputStream();
		 * out.write(userJson.getBytes("UTF-8")); out.flush(); } catch (JSONException e)
		 * { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		String jsonStr;
		PrintWriter out = null;
		try {
			jsonStr = JSON.toJSONString(getUser());
			out = response.getWriter();
			out.write(jsonStr);
			/*
			 * } catch (JSONException e1) { // TODO Auto-generated catch block
			 * e1.printStackTrace();
			 */
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	static class User {
		private String name;
		private String password;
		private int age;
		private Date birthDay;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public Date getBirthDay() {
			return birthDay;
		}

		public void setBirthDay(Date birthDay) {
			this.birthDay = birthDay;
		}
	}

}
