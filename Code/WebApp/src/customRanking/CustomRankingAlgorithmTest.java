package customRanking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomRankingAlgorithmTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void sigmoidFunctionTest() {
		float result = 0.0f;
		result = CustomRankingAlgorithm.sigmoidFunction(3);
		assertEquals(0.952574f, result, "Sigmoid function did not calculate y correctly");
		
		result = CustomRankingAlgorithm.sigmoidFunction(20);
		assertNotEquals(0.3f, result, "Sigmoid function returned a correct result of y that it was not meant to");
	}
	
	@Test
	void getCustomRankValueTest()
	{
		float result = 0.0f;
		result = CustomRankingAlgorithm.getCustomRankValue(0.0f, 0.0f); //TODO update with values
		fail("Still need to write test");
	}

}
