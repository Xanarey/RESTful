package com.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
@WebServlet(
        name = "LoadFileServlet",
        urlPatterns = "/loadFile"
)
@MultipartConfig(location = "C:/Users/Пользователь/Desktop/filestorage")
public class LoadFileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Part part : req.getParts()) {
            if (part.getName().equals("load-file")) {
                InputStream inputStream = part.getInputStream();
                InputStreamReader isr = new InputStreamReader(inputStream);
                String uploadFile = new BufferedReader(isr)
                        .lines()
                        .collect(Collectors.joining("\n"));
                log(uploadFile);
            } else {
                part.write(part.getSubmittedFileName());
            }
        }
        resp.sendRedirect(req.getHeader("referer"));
    }
}