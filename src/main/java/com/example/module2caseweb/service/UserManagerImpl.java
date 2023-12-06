package com.example.module2caseweb.service;

import com.example.module2caseweb.model.PC;
import com.example.module2caseweb.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserManagerImpl implements InternetCafeService<User>{
    List<User> userList;

    public UserManagerImpl() {
        userList =new ArrayList<>();
        userList.add(new User(1,"a","a",200000));
        userList.add(new User(2,"b","b",200000));
        userList.add(new User(3,"c","c",200000));
        userList.add(new User(4,"d","d",200000));
        userList.add(new User(5,"e","e",200000));
    }

    @Override
    public void addNew(User user) {
        userList.add(user);

    }

    @Override
    public int findIndexById(int id) {
        int index = -1;
        for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getId() == id){
                index = i;
            }
        }
        return index;
    }

    @Override
    public User findById(int id) {
        for (User user : userList) {
            if (user.getId() == id) return user;
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public void update(int id, User user) {
        int indexOf = findIndexById(id);
        userList.set(indexOf,user);
    }

    @Override
    public void delete(int id) {
        int indexDelete = findIndexById(id);
        userList.remove(indexDelete);
    }
}
