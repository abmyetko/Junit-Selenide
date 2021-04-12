package com.ice.screens;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Selenide.page;


public class StartScreen{

    @FindBy(css = "a.logo-ice")
    public SelenideElement logo_ice;

    @FindBy(xpath = "//a[text()='Learn more about ICE']")
    public SelenideElement Learn_more_about_ICE;

    @FindBy(xpath = "//h4[text()='Featured Services']")
    public SelenideElement Featured_Services;

    @FindBy(xpath = "//div[text()='ICE Product Guide']")
    public SelenideElement ICE_Product_Guide;

    @FindBy(xpath = "//h4[text()='Market Pulse']")
    public SelenideElement Market_Pulse;

    @FindBy(xpath = "//button[text()='About']")
    public SelenideElement About;

    @FindBy(xpath = "//button[text()='Solutions']")
    public SelenideElement Solutions;

    @FindBy(xpath = "//button[text()='Resources']")
    public SelenideElement Resources;

    @FindBy(xpath = "//button[text()='Insights']")
    public SelenideElement Insights;

    @FindBy(xpath = "//a[text()='Contact']")
    public SelenideElement Contact;


    public ContactScreen clickContact(){
        Contact.click();
        return page(ContactScreen.class);
    }
}