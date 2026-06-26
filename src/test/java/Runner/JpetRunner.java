package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/Features/Jpetstore.feature",
		glue={"StepDef","Hooks"}, monochrome=true
)
public class JpetRunner extends AbstractTestNGCucumberTests{

}
