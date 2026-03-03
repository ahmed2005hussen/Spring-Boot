package com.example.aopDemo.dao;

import com.example.aopDemo.Account;

public interface AccountDAO {

    void addAccount(Account account , boolean isVip);

    boolean doWork();
}
