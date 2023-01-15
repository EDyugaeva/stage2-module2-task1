package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add")

public class AddUserServlet extends HttpServlet {
    //write your code here!

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession();

        req.setAttribute("name", getRequestParameter(req, "name"));
        req.setAttribute("lastName", getRequestParameter(req, "lastName"));

        Warehouse warehouse = Warehouse.getInstance();

        User newUser = new User((String) req.getAttribute("name"), (String) req.getAttribute("lastName"));
        warehouse.addUser(newUser);




    }

    protected String getRequestParameter(
            HttpServletRequest request,
            String name) {
        String param = request.getParameter(name);
        return !param.isEmpty() ? param : getInitParameter(name);
    }
}
