package com.bdd.cucumber.features.debit_account;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", features = "src/test/resources/features", tags = "@debitar-conta")
public class RunDebitAccountTests {
    
}
