package com.example.chainboutique.tanjum;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SharedData {
    public static final Cart cart = new Cart(1, 0);
    public static final ObservableList<Order> orders =
            FXCollections.observableArrayList();
}
