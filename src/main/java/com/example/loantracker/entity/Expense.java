package com.example.loantracker.entity;

import java.time.LocalDateTime;

public class Expense {
    String title;
    double price;
    String category;
    boolean mark;
    LocalDateTime date;

    public Expense(String title, double price, String category, boolean mark, LocalDateTime date) {
        this.title = title;
        this.price = price;
        this.category = category;
        this.mark = mark;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public boolean isMark() {
        return mark;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
