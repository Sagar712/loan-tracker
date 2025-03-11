package com.example.loantracker.web;
import com.example.loantracker.entity.Expense;
import com.example.loantracker.entity.UserBody;
import com.example.loantracker.services.LocalDbServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data")
public class DbController {

    @Autowired
    LocalDbServices localDbServices;

    @GetMapping("/")
    String welcome(){
        return "DB service is up";
    }

    @GetMapping("/all")
    ResponseEntity<List<Expense>> getAllExpenses(){
        return new ResponseEntity<>(localDbServices.getAllExpense(), HttpStatus.OK);
    }

    @PostMapping("/save")
    ResponseEntity<HttpStatus> addExpense(@RequestBody Expense expense){
        try {
            localDbServices.addExpense(expense);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/share")
    ResponseEntity editSharedData(@RequestBody UserBody userBody){
        try {
            if(userBody.phoneNo.toString().length() == 10 && !userBody.getName().isBlank()){
                if(localDbServices.editDataUser(userBody))
                    return new ResponseEntity<>(HttpStatus.OK);
                return new ResponseEntity<>("Not found entry!", HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>("Name or number is missing", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/share")
    ResponseEntity addSharedData(@RequestBody UserBody userBody){
        try {
            if(userBody.phoneNo.toString().length() == 10 && !userBody.getName().isBlank()){
                if(localDbServices.addDataUser(userBody))
                    return new ResponseEntity<>(HttpStatus.OK);
                return new ResponseEntity<>("Duplicate entry!", HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>("Name or number is missing", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/share")
    ResponseEntity getSharedData(@RequestParam Long id){
        try {
            if (id.toString().length() == 10){
               UserBody userdata = localDbServices.getUserBody(id);
               return new ResponseEntity<>(userdata, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Enter valid phone no like 9878651211 (10-digit)", HttpStatus.BAD_REQUEST);
    }
}
