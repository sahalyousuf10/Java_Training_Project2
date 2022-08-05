package com.sahal.JavaTrainingProject2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank_User {

    private Long id;
    private String name;
    private int age;
    private String profession;
    private String maritialStatus;
    private String bankName;
    private Long accountNumber;
    private String creditCardStatus;

    @Override
    public String toString() {
        return id +
                ", " + name +
                ", " + age +
                ", " + profession +
                ", " + maritialStatus +
                ", " + bankName +
                ", " + accountNumber +
                ", " + creditCardStatus+
                "\n";
    }
}
