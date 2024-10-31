package com.epam.training.student_dmitriy_plaksin.Final_task.Cucumber_BDD.cucumberTest;

import org.junit.platform.suite.api.*;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;


//https://stackoverflow.com/questions/64587739/cucumberoptions-in-cucumber-junit-platform-engine
@Suite
@IncludeEngines("cucumber")
@SelectPackages("com.epam.training.student_dmitriy_plaksin.Final_task.Cucumber_BDD.cucumberTest")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "html:target/cucumber.html")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.epam.training.student_dmitriy_plaksin.Final_task.Cucumber_BDD.stepDefinitions")
public class TestRunner {
}