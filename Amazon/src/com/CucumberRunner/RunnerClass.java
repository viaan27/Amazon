package com.CucumberRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



	@RunWith(Cucumber.class)
	@CucumberOptions(
	 features = "./src/com/features"
	 ,glue={"com.StepDefination"},
	 tags= {"@scenario"}
	 )
	
public class RunnerClass {	

	}

