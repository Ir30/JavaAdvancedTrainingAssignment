package com.nestjavatraining.springfoundation;

public class BaseBallCoatch implements Coatch {
	
	private FortuneService fortuneService;
	
	
	public BaseBallCoatch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BaseBallCoatch(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Do workout 30 minutes for baseball";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}



}
