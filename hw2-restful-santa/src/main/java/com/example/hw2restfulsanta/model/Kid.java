package com.example.hw2restfulsanta.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Kid {

    private int id; //id
    private int age; //年紀
    private String name; //姓名
    private String address; //地址
    private String gift; //禮物

}
