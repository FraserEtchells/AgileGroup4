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
		float acceptable_error = 0.000001f;
		
		result = CustomRankingAlgorithm.sigmoidFunction(3.0f, 1.0f, 1.0f);
		assertEquals(0.952574f, result, "Sigmoid function did not calculate y correctly");
		
		//Price tests
		
		result = CustomRankingAlgorithm.sigmoidFunction(2000f, 1000f, 1000f);
		assertEquals(0.007335f, result, acceptable_error, "Sigmoid function did not calculate y correctly");
		
		result = CustomRankingAlgorithm.sigmoidFunction(5000f, 1000f, 1000f);
		assertEquals(0.129233f, result, acceptable_error, "Sigmoid function did not calculate y correctly");
		
		result = CustomRankingAlgorithm.sigmoidFunction(9000f, 1000f, 1000f);
		assertEquals(0.890147f, result, acceptable_error, "Sigmoid function did not calculate y correctly");
		
		//Distance tests
		
		result = CustomRankingAlgorithm.sigmoidFunction(50f, 2000f, 200f);
		assertEquals(0.000642f, result, acceptable_error, "Sigmoid function did not calculate y correctly");
		
		result = CustomRankingAlgorithm.sigmoidFunction(300f, 2000f, 200f);
		assertEquals(0.002236f, result, acceptable_error, "Sigmoid function did not calculate y correctly");
		
		result = CustomRankingAlgorithm.sigmoidFunction(1000.0f, 2000f, 200f);
		assertEquals(0.06908f, result, acceptable_error, "Sigmoid function did not calculate y correctly");
	}
	
	@Test
	void getCustomRankValueTest()
	{
		float result = 0.0f;
		result = CustomRankingAlgorithm.getCustomRankValue(0.0f, 0.0f); //TODO update with values
		fail("Still need to write test");
	}

}
