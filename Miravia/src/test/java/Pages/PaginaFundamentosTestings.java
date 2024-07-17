package Pages;
 
public class PaginaFundamentosTestings extends BasePage {
 
    private String IntroduccionTestingLink = "//a[normalize-space()='Introducción al Testing de Software' and @href]";
 
    public PaginaFundamentosTestings() {
        super(driver);
    }
 
    public void clickFundamentosTestingLink() {
        clickElement(IntroduccionTestingLink);
    }
 
}