package Runner;
 
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import Pages.BasePage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features = "SeleniumJenkinsGradle/Miravia/src/test/resources", 
                 glue = "Steps", 
                 plugin = { "pretty", "html:target/cucumber-reports" }
                 //tags = "@Courses"
                 )
 
 public class TestRunner {
    @AfterClass
        public static void cleanDriver() {
                BasePage.closeBrowser();
        }
 }