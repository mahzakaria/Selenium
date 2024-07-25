package Pages;

public class AmazonHomePage extends BasePage {


    // Variables
     private String Link = "https://www.miravia.es/";
     private String rejectButton ="(//div[contains(text(),'Rechazar todo')])[1]";
     private String searchBar = "//input[@id='g_header_search_input']";
     private String searchButton = "//div[contains(@class,'global_search')]";
     private String thirdItem  ="//body/div[@id='root_page_container']/div[@class='container--jCaTxNqV pc']/div[@class='lContent--pC3_VymR']/div[@class='lMain--LLuqwU7S']/div/div[@class='mGoodsList--I3XeDneu']/div[3]/a[1]/div[1]/div[1]";
     private String addToCartButton="//div[@class='qnyKfgP8am']//button[@type='button'][normalize-space()='Comprar ya']//div[@class='iweb-button-mask']";
     private String addToCartMessagelocator = "//div[@data-spm=\"login_button_click\"]";

    public AmazonHomePage(){
        super(driver);
    }

    // Navigate to Amazon Page
    public void navigateToAmazon() {
        navigateTo(Link);
    }

    // Reject cookies
    public void rejectCookies(){
        clickElement(rejectButton);
    }

    // Search for the product
    public void searchProduct(String  product){
        write(searchBar,product);
    }

    // Click on search button
    public void clickButton(){
        clickElement(searchButton);
    }

    // Go to a page
    public void goToPage(String pageNumber){
        goToLinkText(pageNumber);
    }

    // Select the third item
    public void selectItem(){
        clickElement(thirdItem);
    }

    // Add To Cart
    public void addToCart(){
        clickButton(addToCartButton);
    }

    // Return message
    public String addToCartMessage(){
        return textFromElement(addToCartMessagelocator);
    }
}   
