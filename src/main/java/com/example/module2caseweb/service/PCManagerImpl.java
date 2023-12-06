package com.example.module2caseweb.service;

import com.example.module2caseweb.model.PC;

import java.util.ArrayList;
import java.util.List;

public class PCManagerImpl implements InternetCafeService<PC> {
    List<PC> pcList;

    public PCManagerImpl() {
        pcList = new ArrayList<>();
        pcList.add(new PC(1, 2000));
        pcList.add(new PC(2, 3000));
        pcList.add(new PC(3, 4000));
        pcList.add(new PC(4, 5000));
    }

    @Override
    public List<PC> findAll() {
        return pcList;
    }

    @Override
    public void addNew(PC pc) {
        pcList.add(pc);
    }

    @Override
    public int findIndexById(int id) {
        int index = -1;
        for (int i = 0; i < pcList.size(); i++) {
            if(pcList.get(i).getIdPC() == id){
                index = i;
            }
        }
        return index;
    }

    @Override
    public PC findById(int id) {
        for (PC pc : pcList) {
            if (pc.getIdPC() == id) return pc;
        }
        return null;
    }


    @Override
    public void update(int id, PC pc) {
    int indexOf = findIndexById(id);
    pcList.set(indexOf,pc);
    }

    @Override
    public void delete(int id) {
        int indexDelete = findIndexById(id);
        pcList.remove(indexDelete);
    }
}
