package com.controller.FileServlets;

import com.model.File;
import com.model.User;
import com.service.FileService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "FileGetAllServlet",
        urlPatterns = "/FileGetAllServlet"
)
public class FileGetAllServlet extends HttpServlet {

    private FileService fileService = new FileService();

    private void processRequest(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<File> fileList = fileService.getAllFiles();
        request.setAttribute("FileGetAllServlet", fileList);

        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/jsp/fileView/fileGetAll-record.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }
}
