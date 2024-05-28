package PageObjects;

import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class StarWarsPage {

    private final WebDriver webDriver;

    //Constructor to initialize page elements
    public StarWarsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    // Locators
    @FindBy(xpath = "//table[contains(@class,'text')]")
    private WebElement movieTable;
    @FindBy(xpath = "//th[contains(text(),'Title')]")
    private WebElement titleCol;
    @FindBy(xpath = "//tbody//following::tr[5]//a[1]")
    private WebElement lastMovie;
    @FindBy(xpath = "//h1[contains(text(),'Species')]")
    private WebElement lblSpecies;


    @FindBy(xpath = " //h1[contains(text(),'Species')]/following::ul[1]/child::li")
    private List<WebElement> speciesLst;
    @FindBy(xpath = "  //h1[contains(text(),'Planets')]/following::ul[1]/child::li")
    private List<WebElement> planetsLst;

    @FindBy(xpath = "//tbody//following::td//a")
    private List<WebElement> allMovies;

    @FindBy(xpath = "//a[contains(text(),'Back')]")
    private WebElement btnBack;



    //enter 2 numbers in calculator app and press equal symbol
    public String sortMoviesByColumn(String strColumn) throws InterruptedException {
        Wait.untilAjaxCallIsDone(this.webDriver, 40L);
        Wait.untilPageReadyState(this.webDriver, 30L);
        Wait.untilElementIsVisible(this.webDriver, movieTable, 70L);
        Wait.untilElementIsVisible(this.webDriver, titleCol, 70L);
        titleCol.click();
        Wait.untilElementIsVisible(this.webDriver, lastMovie, 70L);
        String strLastMovie = lastMovie.getText();
        return strLastMovie;

    }

    public boolean clickSpecificMovieToVerifySpecies(String strExpectedMovie, String strExpectedSpeciesName) {
        Wait.untilAjaxCallIsDone(this.webDriver, 40L);
        Wait.untilPageReadyState(this.webDriver, 30L);
        Wait.untilElementIsVisible(this.webDriver,allMovies.get(0),20L);
        String strMovieName, strSpeciesNames;
        int intSpeciesSize;
        //get all movies name and click with specific title
        int intSize = allMovies.size();
        for (int i = 0; i < intSize; i++) {
            strMovieName = allMovies.get(i).getText();
            if (strMovieName.equals(strExpectedMovie)) {
                allMovies.get(i).click();
                 break;
            }
        }


            Wait.untilPageReadyState(this.webDriver, 30L);
            boolean blnFoundFlag = false;
        //get all species name and validate tha value present
            Wait.untilElementIsVisible(this.webDriver, lblSpecies, 70L);
            intSpeciesSize = speciesLst.size();
            for (int j = 0; j < intSpeciesSize; j++) {
                strSpeciesNames = speciesLst.get(j).getText();
                if (strSpeciesNames.equals(strExpectedSpeciesName)) {
                    blnFoundFlag =true;
                    System.out.println("Got Species name as " + strSpeciesNames);
                    break;
                }
            }
            Wait.untilElementIsVisible(this.webDriver,btnBack,20L);
            btnBack.click();
            return blnFoundFlag;
        }


        public boolean verifyPlanetsForMovie(String strExpectedPlanetName, String strExpectedMovieName){

            Wait.untilAjaxCallIsDone(this.webDriver, 40L);
            Wait.untilPageReadyState(this.webDriver, 30L);
            Wait.untilElementIsVisible(this.webDriver,allMovies.get(0),20L);

            String strActualMovieName, strActualPlanetName;
            int intMovies, intPlanets;
            //get all movies name and click with click with specific title
            intMovies = allMovies.size();
            for (int i = 0; i < intMovies; i++) {
                strActualMovieName = allMovies.get(i).getText();
                if (strActualMovieName.equals(strExpectedMovieName)) {
                    allMovies.get(i).click();
                    break;
                }
            }

            //  Wait.untilAjaxCallIsDone(this.webDriver, 40L);
            Wait.untilPageReadyState(this.webDriver, 30L);
            Wait.untilElementIsVisible(this.webDriver, lblSpecies, 70L);
            boolean blnVerifyFlag = false;

            //get all movies name and verify the planets column doesnt have specific  value
            intPlanets = planetsLst.size();
            for (int j = 0; j < intPlanets; j++) {
                strActualPlanetName = planetsLst.get(j).getText();
                if (strActualPlanetName.equals(strExpectedPlanetName)) {
                    System.out.println("FAILED--Got planets name as " + strActualPlanetName);
                    blnVerifyFlag = true;
                    break;
                }
            }
            Wait.untilElementIsVisible(this.webDriver,btnBack,20L);
            btnBack.click();
            return blnVerifyFlag;

        }

    }

