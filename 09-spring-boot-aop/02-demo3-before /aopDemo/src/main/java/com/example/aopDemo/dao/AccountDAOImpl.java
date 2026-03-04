package com.example.aopDemo.dao;

import com.example.aopDemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;
    private String code ;


    public String getName() {

        System.out.println(
                getClass() + "get"
        );

        return name;
    }

    public void setName(String name) {

        System.out.println(
                getClass() + "set"
        );


        this.name = name;
    }

    public String getCode() {
        System.out.println(
                getClass() + "get"
        );


        return code;
    }

    public void setCode(String code) {

        System.out.println(
                getClass() + "set"
        );


        this.code = code;
    }

    @Override
    public void addAccount(Account account, boolean isVaild) {

        System.out.println("hello i'm a account , " + getClass());

    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + "doWork()");
        return false;
    }
}
