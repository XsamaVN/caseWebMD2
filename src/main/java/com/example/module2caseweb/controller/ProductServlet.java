package com.example.module2caseweb.controller;
import com.example.module2caseweb.model.Product;
import com.example.module2caseweb.service.ProductManagerImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
   ProductManagerImpl productManager = new ProductManagerImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if(action == null){
            action="";
        }
        switch (action){
            case "create":
                showCreateProductForm(request,response);
                break;
            case "editProduct":
                showEditProductForm(request,response);
                break;
            case "deleteProduct":
                deleteProduct(request,response);
                break;
            default:
                showListProductPage(request,response);
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        productManager.delete(idProduct);
        response.sendRedirect("/product");

    }

    private void showEditProductForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/editProduct.jsp");
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        Product product = productManager.findById(idProduct);
        request.setAttribute("productEdit", product);
        requestDispatcher.forward(request,response);
    }

    private void showCreateProductForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/createProduct.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showListProductPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/productList.jsp");
        List<Product>  productList= productManager.findAll();
        request.setAttribute("productList",productList);
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
                createProductForm(request,response);
                break;
            case "editProduct":
                editProductForm(request,response);
                break;

        }

    }

    private void editProductForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        String name = request.getParameter("nameProduct");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double priceProduct = Double.parseDouble(request.getParameter("priceProduct"));
        productManager.update(idProduct,new Product(idProduct,name,quantity,priceProduct));
        response.sendRedirect("/product");
    }

    private void createProductForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        String nameProduct = request.getParameter("nameProduct");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double priceProduct = Double.parseDouble(request.getParameter("priceProduct"));
        productManager.addNew(new Product(idProduct,nameProduct,quantity,priceProduct));
        response.sendRedirect("/product");
    }



}
