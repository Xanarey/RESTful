package com.controller.FileServlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(
        name = "FileGetAllServlet",
        urlPatterns = "/fileGetAll"
)
public class FileGetAllServlet extends HttpServlet {
}
