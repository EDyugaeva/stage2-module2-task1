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
import java.util.Set;

@WebServlet("/users")

public class GetUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Warehouse warehouse = Warehouse.getInstance();
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        Set<User> set = warehouse.getUsers();
        if (!set.isEmpty()) {
            for (User user :
                    set) {
                printWriter.write(user.getFirstName() + " ");
                printWriter.write(user.getLastName());
                printWriter.println();
            }
        }

        req.getSession();
        printWriter.close();

    }

    //write your code here!
}
