package system;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)
@CucumberOptions(
		features ="use_cases/deleteCustomer.feature",
		monochrome=true,
		snippets = SnippetType.CAMELCASE,
		glue = {"system"})
public class AcceptanceTest {

}
