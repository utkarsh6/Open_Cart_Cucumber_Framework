package testRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
//		features= {"D:\\Eclipse\\Open_Cart_Cucumber_Framework\\Features\\"},
//		features = {"D:\\Eclipse\\Open_Cart_Cucumber_Framework\\Features\\Login.feature"},
		features = {"D:\\Eclipse\\Open_Cart_Cucumber_Framework\\Features\\LoginDDTExcel.feature"},
		glue = "stepDefinations",
		plugin = {"pretty",
				"html:reports/myreport.html",
				"json:reports/myreport.json",
				
				},
		dryRun = false,
		monochrome = true
//		tags="@Sanity"
		
		)
public class RunCucumberTest {
	
}
