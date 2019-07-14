package com.spider.starlikerain.view;

import com.spider.starlikerain.model.Viewable;

import java.util.ArrayList;

public class ListViewer {
    private ArrayList<Viewable> viewableList;

    public ListViewer (ArrayList<Viewable> list) {
        this.viewableList = list;
    }

    public void display() {
        for(Viewable viewableItem : viewableList){
            System.out.println("-------------------分割线-------------------");
            viewableItem.display();
        }
    }
}
