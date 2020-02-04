package customRanking;

public class CustomRankingAlgorithm {

	final static float e = 2.71828f;
	
	/**
	 * 
	 * @param x Value to pass through sigmoid function ie price or distance
	 * @param a Modifies sigmoid curve. For price, set 1000. For distance, set 100
	 * @param b Modifies sigmoid curve. For price, set 1000. For distance, set 80
	 * @return y value between 0 and 1, to 7? sig figs.
	 */
	public static float sigmoidFunction(float x, float a, float b)
	{
		float y = 0.0f;
		
		//Sigmoid function - https://en.wikipedia.org/wiki/Sigmoid_function
		//Used here to bound a result between 0 and 1 along a smooth curve
		y = (1 / (1 + a * (float)Math.pow(e, -(1/b) * x)));
		
		return y;
	}
	
	/**
	 * 
	 * @param price
	 * @param distance
	 * @return Float value between 0 and 1, where 1 is high rank and 0 is low
	 */
	public static float getCustomRankValue(float price, float distance)
	{
		float rankValue = -1.0f;
		float priceFactor = 0.0f;
		float distanceFactor = 0.0f;
		
		priceFactor = 1 - sigmoidFunction(price, 1000f, 1000f);
		distanceFactor = sigmoidFunction(distance, 100f, 80f);
		
		rankValue = (priceFactor + distanceFactor) / 2;
		
		return rankValue;
	}
}
