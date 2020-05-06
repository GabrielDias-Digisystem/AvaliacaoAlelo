package com.alelo.AvaliacaoAlelo.automacao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

class Selenium {

	// realiza a pesquisa do diretor no google e valida
	@Test
	void SearchDiretorWoodyAllen() {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 5);

		try {
			driver.get("https://google.com");
			driver.findElement(By.name("q")).sendKeys("Woody Allen" + Keys.ENTER);

			List<WebElement> resultado = driver.findElements(By.cssSelector("h3"));

			assertNotNull(resultado);
		} finally {
			driver.quit();
		}
	}

	@Test
	void SearchFilmeInterestelar() {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 5);

		try {
			driver.get("https://google.com");
			driver.findElement(By.name("q")).sendKeys("Interestelar" + Keys.ENTER);

			List<WebElement> resultado = driver.findElements(By.cssSelector("h3"));

			assertNotNull(resultado);
		} finally {
			driver.quit();
		}
	}

}