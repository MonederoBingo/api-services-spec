/* Copyright 2016 Sabre Holdings */
package com.monederobingo;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "junit:output" },
        snippets = SnippetType.CAMELCASE,
        glue = { "com.monederobingo.step_definitions" },
        features = { "src/features/" },
        monochrome = true)
public class TestFeatures
{
}
