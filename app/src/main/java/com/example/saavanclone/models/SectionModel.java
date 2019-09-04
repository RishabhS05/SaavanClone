package com.example.saavanclone.models;

import java.util.ArrayList;

public class SectionModel {
    private String sectionName;
    private ArrayList<BaseObjectModel> allObject;

    public SectionModel(String sectionName, ArrayList<BaseObjectModel> allObject) {
        this.sectionName = sectionName;
        this.allObject = allObject;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public ArrayList<BaseObjectModel> getAllObject() {
        return allObject;
    }

    public void setAllObject(ArrayList<BaseObjectModel> allObject) {
        this.allObject = allObject;
    }
}
