package com.example.module2caseweb.controller;

import com.example.module2caseweb.model.PC;
import com.example.module2caseweb.model.User;
import com.example.module2caseweb.service.UserManagerImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    UserManagerImpl userManager = new UserManagerImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action="";
        }
        switch (action){
            case "create":
                showCreateUserForm(request,response);
                break;
            case "editUser":
                showEditUserForm(request,response);
                break;
            case "deleteUser":
                deleteUser(request,response);
                break;
            default:
                showListUserPage(request,response);
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userManager.delete(id);
        response.sendRedirect("/user");
    }

    private void showEditUserForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/editUser.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userManager.findById(id);
        request.setAttribute("userEdit", user);
        requestDispatcher.forward(request,response);
    }

    private void showCreateUserForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/createUser.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showListUserPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/userList.jsp");
        List<User> userList = userManager.findAll();
        request.setAttribute("userList",userList);
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action="";
        }
        switch (action){
            case "create":
                createUser(request,response);
                break;
            case "editUser":
                editUser(request,response);
        }
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        double moneyCharge = Double.parseDouble(request.getParameter("moneyCharge"));
        userManager.update(id, new User(id, userName, userPassword, moneyCharge));
        response.sendRedirect("/user");
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        double moneyCharge = Double.parseDouble(request.getParameter("moneyCharge"));
        userManager.addNew(new User(id,userName,userPassword,moneyCharge));
        response.sendRedirect("/user");
    }
}
