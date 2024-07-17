package Steps;
 
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import org.testng.Assert;

import Pages.AmazonHomePage;

import java.util.Arrays;


public class AmazonSteps {
 
    AmazonHomePage HomePage = new AmazonHomePage();

    @Given("^The user navigates to www.miravia.es$")
    public void the_user_navigate_to_www_amazon_com() {
        HomePage.navigateToAmazon();
        HomePage.rejectCookies();
        
    }

    @And("^Search for (.+)$")
    public void search_for_product(String product) {
        HomePage.searchProduct(product);
        HomePage.clickButton();
    }

    @And("^Navigate to the page number (.+)$")
    public void navigate_to_the_page_number_x(String pageNumber) {
       HomePage.goToPage(pageNumber);
    }

    @When("Select the third item")
    public void select_the_third_item() {
        HomePage.selectItem();
    }

    @Then("The user is able to add it to the cart")
    public void the_user_is_able_to_add() {
       HomePage.addToCart();
       Assert.assertEquals("Continuar con Facebook", HomePage.addToCartMessage());
    
    }
 
}