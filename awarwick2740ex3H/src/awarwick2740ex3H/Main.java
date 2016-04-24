package awarwick2740ex3H;

import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
		
		double [] dblRainfall = {
				1.2, 2.7, 2.2, 3.1, 2.9, 5.1,
				3.2, 2.7, 3.6, 1.8, 2.2, 1.7};
		String [] strRainfall = {
				"1.2", "2.7", "2.2", "3.1", "2.9", "5.1",
				"3.2", "2.7", "3.6", "1.8", "2.2", "1.7"};
		
		DecimalFormat fmt = new DecimalFormat("#0.0");
		
		RainFall rainfall1 = new RainFall(dblRainfall);
		System.out.println("Rainfall1 total:  " + fmt.format(rainfall1.getTotal()));
		System.out.println("Rainfall1 average:  " + fmt.format(rainfall1.getAverage()));
		System.out.println("Rainfall1 highest:  " + fmt.format(rainfall1.getHighest()));
		System.out.println("Rainfall1 lowest:  " + fmt.format(rainfall1.getLowest()));
		System.out.println("");
		
		RainFall rainfall2 = new RainFall(strRainfall);
		System.out.println("Rainfall2 total:  " + fmt.format(rainfall2.getTotal()));
		System.out.println("Rainfall2 average:  " + fmt.format(rainfall2.getAverage()));
		System.out.println("Rainfall2 highest:  " + fmt.format(rainfall2.getHighest()));
		System.out.println("Rainfall2 lowest:  " + fmt.format(rainfall2.getLowest()));
		
		
	}

}
