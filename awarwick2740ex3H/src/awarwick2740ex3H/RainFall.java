package awarwick2740ex3H;

public class RainFall {
	double rainfallAray[] = {
			0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
			0.0, 0.0, 0.0, 0.0, 0.0, 0.0};

	public RainFall(double[] rainfall) {
		super();
		this.rainfallAray = rainfall;
	}
	
	public RainFall(String rainfall[]) {
		super();
		for (int i = 0; i < rainfall.length; i++ ){
			rainfallAray[i] = Double.parseDouble(rainfall[i]);
		}


	
	}
	
	public double getTotal() {
		
		double total = 0;
	      for (double value : rainfallAray)
	          total += value;
		
		return total;
	}
	
	public double getAverage() {
	      return getTotal() / rainfallAray.length;
	   }
	
	public double getHighest()
	   {
	      // Store the first value in the sales array in
	      // the variable highest.
	      double highest = rainfallAray[0];

	      // Search the array for the highest value.
	      for (int index = 1; index < rainfallAray.length; index++)
	      {
	         if (rainfallAray[index] > highest)
	            highest = rainfallAray[index];
	      }

	      // Return the highest value.
	      return highest;
	   }
	   
	   public double getLowest()
	   {
	      // Store the first value in the sales array in
	      // the variable lowest.
	      double lowest = rainfallAray[0];

	      // Search the array for the lowest value.
	      for (int index = 1; index < rainfallAray.length; index++)
	      {
	         if (rainfallAray[index] < lowest)
	            lowest = rainfallAray[index];
	      }

	      // Return the lowest value.
	      return lowest;
	   }

}
