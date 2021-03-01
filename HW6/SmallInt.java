package assignment6;
public class SmallInt {
	private int value;
	
	public static int  MAXVALUE = 1000;
	
	
	SmallInt(int number){
		if(checkNumber(number)) {
			value = number;
		}
		else {
			System.out.println("The number is out of range.");
		}	
	}
	SmallInt(String number){
		
	}
	public static boolean checkNumber(int number) {
		if(number <= MAXVALUE && number >= 0 ) {
			return true;
		}
		else {
			return false;
		}
	}
	public String getDee() {
		String number = value + " ";
		return number;
	}
	public void setDee(int newValue) {
		if (newValue <= MAXVALUE && newValue >= 0) {
			this.value = newValue;
		}
		else {
			this.value = 0;
			System.out.print(" the number is not correct.");
		}
		
	}
	public String getBin() {    
	    String bin = "";
	    while (value > 0)//keep dividing the given number to 2, until it's 0.
	    {
	    	/* the below line, gets the reminder of the division and update the String bin. if the remainder is 0, 
	    	 * it adds a "0" to previous string bin, and if it's 1, it adds a "1" to the previous string bin. 
	    	 * The process ends when the value is 0. the final "bin" will be the binary of the given decimal number*/
	        bin =  ( (value % 2 ) == 0 ? "0" : "1") + bin;  
	        value = value / 2;
	    }
	    return bin;
	}
	public String getHex() {
		/* Same as the binary section, I want to get the remainders of the devision by 16, until the value is less than 16. 
		 * I defined the representatives of the numbers in hexadecimal format, which is the same as decimal numbers for numbers 
		 * less than or equal to 9 and A to F for numbers between 10 to 16 inclusive, in "hexchars" array. String "hex" is my hexadecimal number.
		 * Every time I divide the value, I get the remainder of the division and update the previous "hex". the final "hex" is the hexadecimal of the given 
		 * decimal number.*/
	    int remainder;  
	    String hex = "";   
	    char hexchars[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};  
	    while(value > 0){  	    	
	      remainder = value % 16;   
	      hex = hexchars[ remainder ] + hex;   
	      value = value / 16;  
	    }  
	    return hex;  
		}
	
//For Extra Credit.
	public static String getDee(int num) {
		String number = num + " ";
		return number;
	}
	public static boolean sameValue(String number1, String number2) {
		int numb1 = Integer.parseInt(number1);
		int val1 = getDecimalFromBinary(numb1);
		number1 = getDee(val1);
		int numb2 = getDecimalFromHex(number2);
		number2 = getDee(numb2);
		if(number1.equals(number2)) {
			return true;
		}
		return false;
	}
	// getting the decimal number of the given binary number.
	public static int getDecimalFromBinary(int binary){  
	    int decimal = 0;  
	    int n = 0;  
	    while(true){  
	      if(binary == 0){  
	        break;  
	      } else {
	          int temp = binary % 10;
	          decimal += temp * Math.pow(2, n);  
	          binary = binary / 10;  
	          n++;  
	       }  
	    }
	    return decimal;  
	}
	// converting the hexadecimal number to decimal. 
	public static int getDecimalFromHex(String hex){
	    String digits = "0123456789ABCDEF";  
        hex = hex.toUpperCase();  
        int val = 0;  
        for (int i = 0; i < hex.length(); i++)  
        {  
            char c = hex.charAt(i);  
            int d = digits.indexOf(c);  
            val = 16 * val + d;  
        }  
        return val;  
	} 
}
