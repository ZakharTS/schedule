package com.example.schedule;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "formHandler", value = "/form-handler")
public class FormHandler extends HttpServlet {

    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        HttpSession in = request.getSession();

        PrintWriter out = response.getWriter();
        out.print("<head><title>Form Handler</title></head>");
        out.print("<body>Your name is " + request.getParameter("name") + "</body>");
        out.close();
    }

    public void destroy() {
    }
}