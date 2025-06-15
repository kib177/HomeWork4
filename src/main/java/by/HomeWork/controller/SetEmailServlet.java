package by.HomeWork.controller;

import by.HomeWork.service.Session;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/set-email")
public class SetEmailServlet extends HttpServlet {


    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String email = req.getParameter("email");

        req.getSession().setAttribute("userEmail", email);
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}

