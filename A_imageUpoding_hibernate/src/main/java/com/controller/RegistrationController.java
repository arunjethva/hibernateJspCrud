package com.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import com.dao.UserDao;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/addUser")
@MultipartConfig
public class RegistrationController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		Part file = req.getPart("file");

		String filename = Paths.get(file.getSubmittedFileName()).getFileName().toString();

		String basepath = req.getServletContext().getRealPath("") + File.separator + "img";
		File f = new File(basepath);

		if (!f.exists()) {
			f.mkdir();
		}

		file.write(basepath + File.separator + filename);
		User u = new User();

		u.setName(name);
		u.setEmail(email);
		u.setPass(pass);
		u.setImg(filename);

		String id = req.getParameter("id");
		UserDao dao = new UserDao();
		
		
		if(!id.equals(""))
		{
			u.setId(Integer.parseInt(id));
			dao.addOrUpdate(u);
			req.setAttribute("msg", "Update Successfuly....");
			req.getRequestDispatcher("display").forward(req, resp);
		}
		else
		{
			dao.addOrUpdate(u);
			req.setAttribute("msg", "Registration Success");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		

	}

}
