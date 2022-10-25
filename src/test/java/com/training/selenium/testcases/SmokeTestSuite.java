package com.training.selenium.testcases;


import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

    @SelectPackages("com.training.selenium.testcases")
    @IncludeTags("smoke")
//    @SelectClasses(LoginTest.class )
    @Suite
    @SuiteDisplayName("Test Suite")
    public class SmokeTestSuite {


    }

