package customRanking;

public class CustomRankingAlgorithm {

	final static float e = 2.71828f;
	
	
	public static float sigmoidFunction(float x)
	{
		float y = 0.0f;
		
		//Sigmoid function - https://en.wikipedia.org/wiki/Sigmoid_function
		//Used here to bound a result between 0 and 1 along a smooth curve
		y = (1 / (1 + (float)Math.pow(e, -x)));
		
		return y;
	}
	
	
}
