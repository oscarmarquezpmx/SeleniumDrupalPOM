package com.training.selenium.cucumber;

import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.suite.api.*;


import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectDirectory;
import static org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder.request;

@Suite
@IncludeEngines("cucumber")
@SelectDirectories("src/test/resources/features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.training.selenium.steps")
public class RunCucumberTest {


}

//@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.swtestacademy.springbootselenium.cucumber")
//@ConfigurationParameter(key = Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")