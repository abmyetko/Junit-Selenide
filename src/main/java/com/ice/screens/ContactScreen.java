package com.ice.screens;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;


public class ContactScreen {

    @FindBy(xpath = "//h1[text()='Personalized Support']")
    public SelenideElement Personalized_Support;

    @FindBy(xpath = "//button[text()='Help Desk for Trading & Clearing']")
    public SelenideElement Help_Desk_for_Trading_and_Clearing;

}