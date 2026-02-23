import java.util.ArrayList;
import java.util.List;

public class Profile {
	// Your additions/changes below this line
	
	//Holds students grades
	private List<Grade> grades;
 
	// Checks if the list is null or empty 
	public Profile(List<Grade> g) {
		if (g == null || g.isEmpty()) {
			throw new IllegalArgumentException();
		}
		// Checks if any grades in the list is a failed classification
		for(Grade gg : g) {
			if(gg.classify() == Classification.Fail) {
				throw new IllegalArgumentException();
			}
		}
		
		// Allows the grade list to be stored and used within the class
		this.grades = new ArrayList<>(g);
	}
	
	public Classification classify() {
		//Holds a count for each classification below
		int Firstcount = 0; 
		int UpperSecondCount = 0 ;
		int LowerSecondCount = 0; 
		
		// loop goes through the list to check how many grades match the classification and increments it by 1
		for (Grade gg : grades) {
			if(gg.classify() == Classification.First) {
				Firstcount++;
			}else if(gg.classify() == Classification.UpperSecond) {
				UpperSecondCount++;
			}else if(gg.classify() == Classification.LowerSecond) {
				LowerSecondCount++;
			}
				
		}
		
		// 50% or more of the grades are a first then the profile is a first (the same rules apply for the rest)
		//size of the list is times by 0.5 ( size of the list of 4 it would be 4 * 0.5 = 2)
		if (Firstcount >= grades.size() * 0.5 ) {
			return Classification.First;
		}else if (UpperSecondCount >= grades.size() * 0.5) {
			return Classification.UpperSecond;	
		}else if (LowerSecondCount >= grades.size() * 0.5) {
			return Classification.LowerSecond;
		}else {
			return Classification.Third;
		}
			
				
	}

	public boolean isClear() {
		//Holds a count for the third classification
		int Thirdcount = 0;
		
		// Loop goes through the list to check how many grades match the classification and increments it by 1
		for (Grade gg : grades) {
			if(gg.classify() == Classification.Third) {
				Thirdcount++;
			}
		}
		
		//If the classification is a First and UpperSecond it check if how many grades are a first and if it more than 25% its not a clear
		//and if its under 25% it is clear
		if (classify() == Classification.First || classify() == Classification.UpperSecond ) {
            // Double allows the Thirdcount to be divided by grade size 
			// 2.0 / 8  = 0.25 * 100 = 25
			if ((double)Thirdcount / grades.size() * 100 <= 25) {
				return true;
				
			}else {
				return false;
			}	
		} else {
			// If the classification is Lower Second or Third, it is clear
			return true;
		}
		
		
	
	}
}
