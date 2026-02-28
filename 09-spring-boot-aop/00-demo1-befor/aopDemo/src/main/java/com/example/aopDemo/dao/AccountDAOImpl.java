package com.example.aopDemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    @Override
    public void addAccount() {

        System.out.println("hello i'm a account , " + getClass());

    }
}
