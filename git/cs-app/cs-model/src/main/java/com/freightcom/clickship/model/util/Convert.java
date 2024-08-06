package com.freightcom.clickship.model.util;

public class Convert {
	
	private Convert() {
		super();
	}
 	
	// To Imperial dimensions conversion 
	public static Double meterToInches(Double meter) {
		return meter * 39.37;
	}	

	public static Double centimetersToInches(Double centimeters) {
		return centimeters / 2.54;
	}
	
	public static Double millimimetersToInches(Double millimeters) {
		return millimeters / 25.40;
	}	

	public static Double yardToInches(Double yard) {
		return yard * 36;
	}
	
	public static Double feetToInches(Double feet) {
		return feet * 12;
	}

	// To Metrics dimensions conversion
	public static Double inchesToCentimeters(Double inches) {
		return inches * 2.54;
	}

	public static Double yardToCentimeters(Double centimeter) {
		return centimeter * 91.44;
	}
	
	public static Double meterToCentimeters(Double meter) {
		return meter * 100;
	}
	
	public static Double millimeterToCentimeters(Double millimeter) {
		return millimeter / 10;
	}
	
	public static Double feetToCentimeters(Double feet) {
		return feet * 30.48;
	}

	// To Imperial weight conversion 
	public static Double gramsToPounds(Double grams) {
		return grams / 453.592;
	}
	
	public static Double kilogramsToPounds(Double kilograms) {
		return kilograms * 2.205;
	}
	
	public static Double ouncesToPounds(Double ounces) {
		return ounces / 16;
	}
	
	public static Double tonesToPounds(Double ton) {
		return ton * 2000;
	}
	
	// To Metrics weight conversion
	public static Double gramsToKilograms(Double grams) {
		return grams / 	1000;		
	}
	
	public static Double poundsToKilograms(Double pounds) {
		return pounds / 2.205;
	}
	
	public static Double ouncesToKilograms(Double ounces) {
		return ounces / 35.274;
	}

	public static Double tonsToKilograms(Double ton) {
		return ton * 907.185;
	}
	
	public static Double getImperialDimesionByUOM(Double measurement, String unitOfMessure) {
    	switch(unitOfMessure) {
    		case "m":
    			return meterToInches(measurement);
    		
    		case "cm":
    		case "Centimeters":
    			return centimetersToInches(measurement);
    		
    		case "mm":
    			return millimimetersToInches(measurement);
    		
    		case "yd":
    			return yardToInches(measurement);
    			
    		case "feet":
    			return feetToInches(measurement);
    			
    		default:
    			return measurement;
    	}
    }
	
	public static Double getMetricDimesionByUOM(Double measurement, String unitOfMessure) {
    	switch(unitOfMessure) {
    		case "m":
    			return meterToCentimeters(measurement);
    		
    		case "mm":
    			return millimeterToCentimeters(measurement);

			case "inches":
			case "Inches":
    		case "in":
    			return inchesToCentimeters(measurement);
    		
    		case "yd":
    			return yardToCentimeters(measurement);
    		
    		case "feet":
    			return feetToCentimeters(measurement);    			
    		
    		default:
    			return measurement;
    	}
    }
	
	public static Double getImperialWeigthByUOM(Double weigth, String unitOfMessure) {
    	switch(unitOfMessure) {
    		case "g":
    		case "Grams":
    			return gramsToPounds(weigth);
    		
    		case "kg":
    		case "KGS":    			
    			return kilogramsToPounds(weigth);
    		
    		case "oz":
    		case "Ounces":
    			return ouncesToPounds(weigth);
    			
    		case "Tonnes":
    			return tonesToPounds(weigth);
    			
    		default:
    			return weigth;
    	}
    }
	
	public static Double getMetricWeigthByUOM(Double weigth, String unitOfMessure) {
    	switch(unitOfMessure) {
    		case "g":
    		case "Grams":    			
    			return gramsToKilograms(weigth);

			case "pounds":
    		case "lbs":
    		case "LBS":    			
    			return poundsToKilograms(weigth);
    		
    		case "oz":
    		case "Ounces":
    			return ouncesToKilograms(weigth);
    		
    		case "Tonnes":
    			return tonsToKilograms(weigth);
    				
    		default:
    			return weigth;
    	}
    }

}
