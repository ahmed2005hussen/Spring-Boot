package com.example.aopDemo.dao;

import com.example.aopDemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

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
