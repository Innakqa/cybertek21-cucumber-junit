package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GasMileageCalculatorPage { //https://www.calculator.net/gas-mileage-calculator.html


    public GasMileageCalculatorPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "uscodreading")
    public WebElement inputCurrentOdometer;

    @FindBy(id = "uspodreading")
    public WebElement inputPreviousOdometer;

    @FindBy(id = "usgasputin")
    public WebElement inputGas;

    @FindBy(xpath = "(//input[@alt='Calculate'])[1]")
    public WebElement calculateButton;

    @FindBy(xpath = "//b[contains(text(), 'mpg')]")
    public WebElement resultInGas;


}
