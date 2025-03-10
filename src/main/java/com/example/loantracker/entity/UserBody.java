package com.example.loantracker.entity;

import java.util.List;

public class UserBody {
    String name;
    public Long phoneNo;
    List<Expense> expenseList;

    public UserBody(String name, long phoneNo, List<Expense> expenseList) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.expenseList = expenseList;
    }

    public String getName() {
        return name;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }
}
