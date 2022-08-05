package com.sahal.JavaTrainingProject2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {

    private Long id;
    private String bankName;
    private Long accountNumber;
    private String creditCardStatus;
}
