package com.octopanda.octocode.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckForm
 */
@WebServlet(name = "checkform", urlPatterns = { "/checkform" })
public class CheckForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private List<String> usernames = null;
    private List<String> emails = null;

    public CheckForm() {
        super();
        usernames = new ArrayList<String>();
        emails = new ArrayList<String>();
        this.usernames.add("hankai");
        this.usernames.add("william");
        this.usernames.add("octopanda");
        this.usernames.add("octopus");
        this.emails.add("cnhankai@gmail.com");
        this.emails.add("william_k_han@foxmail.com");
        this.emails.add("100415529@qq.com");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		boolean available = true;
		for (String  item : this.usernames) {
			if (item.equals(username)) {
				available = false;
				break;
			}
		}
		for (String item : this.emails) {
			if (item.equals(email)) {
				available = false;
				break;
			}
		}
		PrintWriter out = response.getWriter();
		out.println(available);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
