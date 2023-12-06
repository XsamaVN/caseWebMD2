package com.example.module2caseweb.service;

import com.example.module2caseweb.model.PC;
import com.example.module2caseweb.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductManagerImpl implements InternetCafeService<Product>{
    List<Product> productList;

    public ProductManagerImpl() {
        productList = new ArrayList<>();
        productList.add(new Product(1,"BimBimBím",100,5000));
        productList.add(new Product(2,"BimBimBím",100,6000));
        productList.add(new Product(3,"BimBimBím",100,7000));
        productList.add(new Product(4,"BimBimBím",100,8000));
        productList.add(new Product(5,"BimBimBím",100,9000));
    }

    @Override
    public void addNew(Product product) {
        productList.add(product);
    }

    @Override
    public int findIndexById(int id) {
        int index = -1;
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getIdProduct() == id){
                index = i;
            }
        }
        return index;
    }

    @Override
    public Product findById(int id) {
        for (Product product : productList) {
            if (product.getIdProduct() == id) return product;
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void update(int id, Product product) {
        int indexOf = findIndexById(id);
        productList.set(indexOf,product);
    }

    @Override
    public void delete(int id) {
        int indexOf = findIndexById(id);
        productList.remove(indexOf);
    }
}
