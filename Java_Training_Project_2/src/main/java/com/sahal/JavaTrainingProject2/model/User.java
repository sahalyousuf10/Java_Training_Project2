package com.sahal.JavaTrainingProject2.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String name;
    private int age;
    private String profession;
    private String maritialStatus;
}
