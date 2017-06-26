package com.monederobingo;

import static cucumber.api.SnippetType.CAMELCASE;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "junit:output" },
        snippets = CAMELCASE,
        glue = { "com.monederobingo.step_definitions" },
        features = { "src/features/" },
        monochrome = true)
public class TestFeatures
{
}
