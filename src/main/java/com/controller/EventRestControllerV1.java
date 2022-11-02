package com.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(
        name = "EventServlet",
        urlPatterns = "/api/v1/events/*"
)
public class EventRestControllerV1 extends HttpServlet {

}
