package Pages;
 
public class PaginaPrincipal extends BasePage {

    private String sectionLink = "(//a[normalize-space()='%s' and @href])[1]";
    private String elegirUnPlanButton = "//a[normalize-space()='Elegir Plan' and @href]";
 
    public PaginaPrincipal() {
        super(driver);
    }
 
    
    public void clickOnSectionNavigationBar(String section) {
        // Reemplaza el marcador de posición en sectionLink con el nombre
        String xpathSection = String.format(sectionLink, section);
        clickElement(xpathSection);
    }

    public void clickOnElegirPlanButton() {
        clickElement(elegirUnPlanButton);
    }
}