package com.hiraas.pm4j.primefaces;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomerDialogPmTest {

    @Test
    public void testSome(){

        System.setProperty("webdriver.chrome.driver","/home/rkunas/Dev/Projects/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.hiraav.com");

        System.out.println(driver.getPageSource());
    }
}
