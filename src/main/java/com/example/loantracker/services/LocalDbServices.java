package com.example.loantracker.services;

import com.example.loantracker.entity.Expense;
import com.example.loantracker.entity.UserBody;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LocalDbServices {
    List<Expense> list = new ArrayList<>();
    List<UserBody> listOfUsersData = new ArrayList<>();

    LocalDbServices(){
        list.add(new Expense("deposit", 5000, "expense", true, LocalDateTime.now()));
        list.add(new Expense("bhajipala", -300, "expense", false, LocalDateTime.now()));
        list.add(new Expense("kirana", -2000, "expense", false, LocalDateTime.now()));
        list.add(new Expense("chiilar", -40, "expense", false, LocalDateTime.now()));
    }

    public List<Expense> getAllExpense(){
        return list;
    }

    public void addExpense(Expense expense){
        list.add(expense);
    }

    public boolean addDataUser(UserBody userBody){
        if(listOfUsersData.stream().filter(u -> u.phoneNo.equals(userBody.phoneNo)).toList().isEmpty()){
            listOfUsersData.add(userBody);
            return true;
        }
        return false;
    }

    public UserBody getUserBody(Long phone){
        Optional<UserBody> user = listOfUsersData.stream().filter(u -> u.phoneNo.equals(phone)).findFirst();
        if(user.isPresent())
            return user.get();
        return null;
    }

}
