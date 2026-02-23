public class Grade {
	
	//Stores grade points (1 to 20)
	private final int points;
	
    //Get method to return the points
	public int getPoints() {
		return points;
	}
	
    //Checks to see if the points are within valid range 
	public Grade(int p) throws IllegalArgumentException {
		if(p<1 || p>20) 
			throw new IllegalArgumentException();
		points = p;
	}
	
	// Your additions/changes below this line
    
	//Checks the grade points to see which classification it belongs to 
	public Classification classify() {
		
		//points(1-4) it is a First
	    if (points <= 4) {
	        return Classification.First;
	      //points(5-8) it is a UpperSecond
	    }else if (points <= 8) {
	        return Classification.UpperSecond;
	      //points(9-12) it is a LowerSecond
	    }else if (points <= 12) {
	        return Classification.LowerSecond;
	      //points(13-16) it is a Third
	    }else if (points <= 16) {
	        return Classification.Third;
	      //points(17-20) it is a Fail
	    }else {
	    	return Classification.Fail;
	    }
	}

	// Creates a grade object from the percentage mark 
	public static Grade fromPercentage(int g) throws IllegalArgumentException {
		
		//If percentage is -1 then its grade 20
		if (g == -1) {
	        return new Grade(20);
	    }
		
		//Make sure the percentage is in between (0-100) or -1
		 if (g <= -1 || g >= 100) 
		        throw new IllegalArgumentException();
		 
		 int grade; // Stores the grade after it is converted from a percentage
		 
		 
		 
		    if (g >= 80) {
		        grade = 1;  // 100 - 80
		    } else if (g >=76) {
		        grade = 2; // 79 - 76
		    } else if (g >= 73) {
		        grade = 3; // 75 - 73
		    } else if (g >= 70) {
		        grade = 4; // 73 - 70
		    } else if (g >= 67) {
		        grade = 5; // 69 - 67
		    } else if (g >= 65) {
		        grade = 6; // 66 - 65
		    } else if (g >= 62) {
		        grade = 7; // 64 - 62
		    } else if (g >= 60) {
		        grade = 8; // 61 - 60
		    } else if (g >= 57) {
		        grade = 9; // 59 - 57 
		    } else if (g >= 55) {
		        grade = 10; // 56 - 55
		    } else if (g >= 52) {
		        grade = 11; // 54 - 52
		    } else if (g >= 50) {
		        grade = 12; // 51 - 50
		    } else if (g >= 47) {
		        grade = 13; // 49 - 47
		    } else if (g >= 45) {
		        grade = 14; // 46 -45
		    } else if (g >= 42) {
		        grade = 15; // 44 - 42
		    } else if (g >= 40) {
		        grade = 16; // 41 - 40
		    } else if (g >= 35) {
		        grade = 17; // 39 - 35
		    } else if (g >= 30) {
		        grade = 18; // 34 -30
		    } else{
		        grade = 19; // 29 - 0
		    } 
             
		    //Returns new grade object to the grade points 
		    return new Grade(grade);
		}

		 
		    
}
