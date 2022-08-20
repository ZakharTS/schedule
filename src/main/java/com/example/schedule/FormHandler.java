package com.example.schedule;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import parser.Parser;

@WebServlet("/form-handler")
@MultipartConfig
public class FormHandler extends HttpServlet {

    public void init() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.print("<head><title>Form Handler</title></head>");
        out.print("<body>Uploading...<br>");
        Part filePart = request.getPart("xl-table");
        String fileName = filePart.getName();
        try (InputStream fileContent = filePart.getInputStream()) {
            out.print(Parser.parseFile(fileContent));
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.print("</body>");
        out.close();
    }

    public void destroy() {
    }
}