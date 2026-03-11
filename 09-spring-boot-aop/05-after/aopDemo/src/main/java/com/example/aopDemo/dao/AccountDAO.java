package com.example.aopDemo.dao;

import com.example.aopDemo.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount(Account account , boolean isVip);

    boolean doWork();

    public String getName() ;
    public void setName(String name) ;
    public String getCode() ;
    public void setCode(String code) ;

    List<Account> findAccounts();

    List<Account> findAccounts(boolean isException);



}
