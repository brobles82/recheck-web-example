package de.retest.recheck.example;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;
import de.retest.recheck.RecheckOptions;

public class BudgetTest {
	WebDriver driver;
	Recheck re;

	@Test
	public void excel() throws Exception {
		final RecheckOptions options = RecheckOptions.builder()
				//.reportUploadEnabled( true )
				.build();
		re = new RecheckImpl( options );

		System.setProperty( "webdriver.chrome.driver", "src/test/resources/chromedriver" );
		driver = new ChromeDriver();

		//		driver.get( "https://assets.retest.org/demos/budget/OriginalBudget.htm" );
		driver.get( "https://assets.retest.org/demos/budget/AdaptedBudget.htm" );
		Thread.sleep( 1000 );

		re.check( driver, "open" );
		re.capTest();
	}

	@After
	public void tearDown() {
		driver.quit();

		// Produce the result file.
		re.cap();
	}
}
