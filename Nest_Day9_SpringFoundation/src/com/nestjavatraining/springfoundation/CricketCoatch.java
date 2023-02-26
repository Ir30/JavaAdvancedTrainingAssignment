package com.nestjavatraining.springfoundation;

public class CricketCoatch implements Coatch {

	private FortuneService fortuneService;
	
	
	

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside setter methode fortune service");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Do workout one houre for cricket ";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
