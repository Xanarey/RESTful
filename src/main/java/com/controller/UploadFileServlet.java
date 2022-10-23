package com.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.UUID;
import java.util.stream.Collectors;

@WebServlet(
        name = "UploadFileServlet",
        urlPatterns = "/uploadFile"
)
@MultipartConfig(location = "C:/Users/Пользователь/Desktop/upload")
public class UploadFileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Part part : req.getParts()) {
            if (part.getName().equals("upload-file")) {
                InputStream inputStream = part.getInputStream();
                InputStreamReader isr = new InputStreamReader(inputStream);
                String uploadFile = new BufferedReader(isr)
                        .lines()
                        .collect(Collectors.joining("\n"));
                log(uploadFile);
            } else {
                part.write(UUID.randomUUID().toString() + part.getSubmittedFileName());
            }
        }
        resp.sendRedirect("/getAllUsers");
    }
}