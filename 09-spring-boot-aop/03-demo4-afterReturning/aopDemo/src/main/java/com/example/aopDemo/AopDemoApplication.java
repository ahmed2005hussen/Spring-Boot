package com.example.aopDemo;

import com.example.aopDemo.dao.AccountDAO;
import com.example.aopDemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO , MembershipDAO membershipDAO){
		return runner->{

//			addAccount(accountDAO , membershipDAO);

			afterReturningAdvice(accountDAO);
		};
	}

	private void afterReturningAdvice(AccountDAO accountDAO) {

		List<Account> accounts = accountDAO.findAccounts();

		System.out.println("Main App ");
		System.out.println("---------");
		System.out.println(accounts);
		System.out.println("\n");

	}

	private void addAccount(AccountDAO accountDAO , MembershipDAO membershipDAO) {


		accountDAO.addAccount(new Account("asdfasdf" , "jkf") , true);
		membershipDAO.addMember();


		accountDAO.setCode("34");
		accountDAO.setName("asdfasdf");
		accountDAO.getName();
		accountDAO.getName();

		accountDAO.doWork();
		membershipDAO.goToSleep();

	}
}
