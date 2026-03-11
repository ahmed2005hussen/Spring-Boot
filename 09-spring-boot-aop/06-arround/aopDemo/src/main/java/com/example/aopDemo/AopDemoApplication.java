package com.example.aopDemo;

import com.example.aopDemo.dao.AccountDAO;
import com.example.aopDemo.dao.MembershipDAO;
import com.example.aopDemo.service.TrafficFortuneService;
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
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO ,
											   MembershipDAO membershipDAO ,
											   TrafficFortuneService trafficFortuneService){
		return runner->{

//			addAccount(accountDAO , membershipDAO);

//			afterReturningAdvice(accountDAO);

//			afterThrowingAdvice(accountDAO);

// 			afterAdvice(accountDAO);


 		//	aroundAdvice(trafficFortuneService);


 			aroundAdviceHandleException(trafficFortuneService);

		
		
		};
	}

	private void aroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {


		System.out.println("Around Main ");

		boolean isException = true;


		String traffic = trafficFortuneService.getFortune(isException);


		System.out.println("The fortune is " + traffic);
		System.out.println("I'm finished ");


	}

	private void aroundAdvice(TrafficFortuneService trafficFortuneService) {


		System.out.println("Around Main ");


		String traffic = trafficFortuneService.getFortune();


		System.out.println("The fortune is " + traffic);
		System.out.println("I'm finished ");
	}

	private void afterAdvice(AccountDAO accountDAO) {

		List<Account> accounts = null ;

		try {
			boolean isException = true;

			accounts = accountDAO.findAccounts();
		}
		catch (Exception e ){
			System.out.println("Exception in the main " + e);
		}
		System.out.println("Main App ");
		System.out.println("---------");
		System.out.println(accounts);
		System.out.println("\n");

	}

	private void afterThrowingAdvice(AccountDAO accountDAO) {


		List<Account> accounts = null ;

		try {
			boolean isException = true;

			accounts = accountDAO.findAccounts(isException);
		}
		catch (Exception e ){
			System.out.println("Exception in the main " + e);
		}
		System.out.println("Main App ");
		System.out.println("---------");
		System.out.println(accounts);
		System.out.println("\n");



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
