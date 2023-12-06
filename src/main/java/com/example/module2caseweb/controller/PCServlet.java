package com.example.module2caseweb.controller;

import com.example.module2caseweb.model.PC;
import com.example.module2caseweb.service.PCManagerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "PCServlet", value = "/pc")
public class PCServlet extends HttpServlet {
    PCManagerImpl pcManager = new PCManagerImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if(action == null){
            action="";
        }
        switch (action){
            case "create":
                showCreatePCForm(request,response);
                break;
            case "editPC":
                showEditPCForm(request,response);
                break;
            case "deletePC":
                deletePC(request,response);
                break;
            default:
                showListPCPage(request,response);
        }
    }

    private void showEditPCForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("pc/editPC.jsp");
        int idPC = Integer.parseInt(request.getParameter("idPC"));
        PC pc = pcManager.findById(idPC);
        request.setAttribute("pcEdit", pc);
        requestDispatcher.forward(request,response);
    }

    private void showCreatePCForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("pc/createPC.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showListPCPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("pc/pcList.jsp");
        List<PC> pcList = pcManager.findAll();
        request.setAttribute("pcList",pcList);
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
                createPCForm(request,response);
                break;
            case "editPC":
                editPCForm(request,response);
                break;

        }

    }
    private void editPCForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idPC = Integer.parseInt(request.getParameter("idPC"));
        double pricePC = Double.parseDouble(request.getParameter("pricePC"));
        pcManager.update(idPC,new PC(idPC,pricePC));
        response.sendRedirect("/pc");
    }
    private void deletePC(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idPC = Integer.parseInt(request.getParameter("idPC"));
        pcManager.delete(idPC);
        response.sendRedirect("/pc");
    }

    private void createPCForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idPC = Integer.parseInt(request.getParameter("idPC"));
        double pricePC = Double.parseDouble(request.getParameter("pricePC"));
        pcManager.addNew(new PC(idPC,pricePC));
        response.sendRedirect("/pc");
    }
}