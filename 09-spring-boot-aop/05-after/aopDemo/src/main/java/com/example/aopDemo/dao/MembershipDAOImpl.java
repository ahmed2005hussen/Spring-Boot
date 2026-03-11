package com.example.aopDemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public boolean addMember() {

        System.out.println("hello i'm a Membership , " + getClass());
        return false;
    }

    @Override
    public boolean goToSleep() {

        System.out.println(getClass() +  " goToSleep()");

        return false;
    }
}
