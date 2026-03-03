package com.example.aopDemo;

import com.example.aopDemo.dao.AccountDAO;
import com.example.aopDemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO , MembershipDAO membershipDAO){
		return runner->{

			addAccount(accountDAO , membershipDAO);

		};
	}

	private void addAccount(AccountDAO accountDAO , MembershipDAO membershipDAO) {


		accountDAO.addAccount();
		membershipDAO.addMember();

	}
}
