package garbage;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizationGarbage {

	@Parameters({"myName","myAge"})
	@Test
	public void params(@Optional("Krishna Saahi") String name, @Optional("25") int age) {
		System.out.println("My name is "+name+" | "+"Age "+age);
	}
}
