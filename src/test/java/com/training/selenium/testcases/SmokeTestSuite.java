package com.testcases;


import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

    @SelectPackages("com.testcases")
    @IncludeTags("regression")
//    @SelectClasses(LoginTest.class )
    @Suite
    @SuiteDisplayName("Test Suite")
    public class SmokeTestSuite {


    }

