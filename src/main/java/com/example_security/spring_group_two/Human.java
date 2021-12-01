package com.example_security.spring_group_two;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class Human {

    @NotEmpty(message = "not empty")
    private String name;
    @NotEmpty(message = "not empty")
    @Size(min = 4,message = "invalid size")
    private String country;
    private String file_name;

}
