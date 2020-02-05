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
		
		result = CustomRankingAlgorithm.sigmoidFunction(50f, 100f, 80f);
		assertEquals(0.01834f, result, acceptable_error, "Sigmoid function did not calculate y correctly");
		
		result = CustomRankingAlgorithm.sigmoidFunction(300f, 100f, 80f);
		assertEquals(0.298349f, result, acceptable_error, "Sigmoid function did not calculate y correctly");
		
		result = CustomRankingAlgorithm.sigmoidFunction(1000.0f, 100f, 80f);
		assertEquals(0.999627f, result, acceptable_error, "Sigmoid function did not calculate y correctly");
	}
	
	//0.701651
	
	@Test
	void getCustomRankValueTest()
	{
		float result = 0.0f;
		float acceptable_error = 0.000001f;
		
		result = CustomRankingAlgorithm.getCustomRankValue(2000f, 300f);	//0.003029 + 0.298349 /2 = 0.150689
		assertEquals(0.849311f, result, acceptable_error, "Custom Rank not calculated correctly");
		
		result = CustomRankingAlgorithm.getCustomRankValue(7000f, 300f);	//0.046581 + 0.298349 /2 = 0.172465
		assertEquals(0.827535f, result, acceptable_error, "Custom Rank not calculated correctly");
		
		result = CustomRankingAlgorithm.getCustomRankValue(15000f, 50f);	//0.806211 + 0.01834 /2 = 0.4122755
		assertEquals(0.5877245f, result, acceptable_error, "Custom Rank not calculated correctly");
		
		
		
		//fail();
	}

}