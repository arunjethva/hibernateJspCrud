package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.UserDao;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action");

		int uid = Integer.parseInt(req.getParameter("uid"));

		UserDao dao = new UserDao();
		if (action.equals("edit")) {

			User u = dao.userById(uid);
			req.setAttribute("udata", u);
			req.getRequestDispatcher("index.jsp").forward(req, resp);

		} else if (action.equals("delete")) {

			int i = dao.deleteUser(uid);

			req.getRequestDispatcher("display").forward(req, resp);

		}

	}
}
