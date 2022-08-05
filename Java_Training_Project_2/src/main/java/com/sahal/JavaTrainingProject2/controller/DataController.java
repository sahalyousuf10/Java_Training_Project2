package com.sahal.JavaTrainingProject2.controller;
import com.sahal.JavaTrainingProject2.model.User;
import com.sahal.JavaTrainingProject2.model.Bank;
import com.sahal.JavaTrainingProject2.model.Bank_User;
import com.sahal.JavaTrainingProject2.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/bank1")
public class DataController {

    @Autowired
    private DataService bankService;

    @PostMapping("/user")
    public ResponseEntity<String> postUserData(@RequestBody User user){

        String result;
        try {
            result = bankService.saveUserData(user);
        }
        catch (Exception ex){
            log.info("Exception caught: "+ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User data not saved due to some internal issue");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

//    @PostMapping("/user")
//    public ResponseEntity<String> postUserData1(@RequestBody User user){
//
//        String result;
//        HttpStatus status = HttpStatus.CREATED;
//
//        try {
//            result = bankService.saveUserData(user);
//        }
//        catch (Exception ex){
//            log.info("Exception caught: "+ex.getMessage());
//            status = HttpStatus.BAD_REQUEST;
//            result = "Data not saved due to some internal issue";
//        }
//        return ResponseEntity.status(status).body(result);
//    }

    @PostMapping("/bank")
    public ResponseEntity<String> postBankData(@RequestBody Bank bank){

        String result;
        try {
            result = bankService.saveBankData(bank);
        }
        catch (Exception ex){
            log.info("Exception caught",ex);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bank data not saved due to some internal error");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/file3")
    public ResponseEntity<String> postDataInFIle3(){

        String result;
        try {
           result = bankService.saveDataInFile3();
        }
        catch (Exception ex){
            log.error("Exception caught:"+ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data not saved due to some internal error");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/users")
    public ResponseEntity<List<Bank_User>> getAllUsers(){

        List<Bank_User> userList = null;
        try {
            userList = bankService.getAllUsers();
        }
        catch (Exception ex){
            log.error("Exception caught: "+ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(userList);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Bank_User> getUserWithId(@PathVariable Long id){

        Bank_User user = null;
        try {
            user = bankService.getUserWithId(id);
        }
        catch (Exception ex){
            log.error("Exception caught: "+ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(user);
    }

    @PutMapping("/update/{id}/{status}")
    public ResponseEntity<String> updateCCStatus(@PathVariable Long id, @PathVariable String status){

        String result;
        try {
            result = bankService.updateCCStatus(id,status);
        }
        catch (Exception ex){
            log.error("Exception caught: "+ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Status not updated due to some internal error");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
