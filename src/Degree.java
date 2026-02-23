import java.util.ArrayList;
import java.util.List;

public class Degree {
	// Your additions/changes below this line
	
	// Stores the grade object for year 2
	private List<Grade> yer2;
	// Stores the grade object for year 3
	private List<Grade> yer3;

	public Degree(List<Grade> year2, List<Grade> year3) {
		//Checks if either list is null
		if (year2 == null || year3 == null) {
			throw new IllegalArgumentException();
		}
		
		//Check if either list has only 4 grades (No more & No less)
		if (year2.size() != 4 || year3.size() != 4) {
			throw new IllegalArgumentException();
		}
			
		
		// Checks if there are any failing Grades for year 2
		for(Grade yr2 : year2) {
			if(yr2.classify() == Classification.Fail) {
				throw new IllegalArgumentException();
			}	
		}
		
		// Checks if there are any failing Grades for year 2
		for(Grade yr3 : year3) {
			if(yr3.classify() == Classification.Fail) {
				throw new IllegalArgumentException();
			}
		}
		
		// Store copies of the lists to yer2 and yer3
		this.yer2 = new ArrayList<>(year2);
		this.yer3 = new ArrayList<>(year3);
	}
		
		
		
	public Classification classify() {
		
		// Create a new list that combines grades from Year 2 and Year 3
		List<Grade> L5 = new ArrayList<>();
		L5.addAll(yer2);
	    L5.addAll(yer3);
		
	    // Create Profile object for year 3 and the level5 (year 2 and year 3)
		Profile Level6 = new Profile (yer3);
		Profile Level5 = new Profile(L5);
		
		//Converts the classification to a number using in rank method
		int Rank1 = Rank(Level6.classify());
		int Rank2 = Rank(Level5.classify());
		
		
		//If both Classifications are the same it returns that classification
		if(Level6.classify() == Level5.classify()) {
			return Level6.classify();
			//If the level6 is one more higher than level5 and level6 profile is clear it returns the Level6 classification
		}else if (Rank1 < Rank2 && Level6.isClear() && (Rank2 - Rank1 == 1)) {
		    return Level6.classify();
		  //If the Level5 is one more higher than level6 and level5 profile is clear it returns the Level5 classification
		}else if (Rank2 < Rank1 && Level5.isClear() && (Rank1 - Rank2 == 1)) {
		    return Level5.classify();
		    // If none of the statements match it is deemed Discretion
		}else{
			return Classification.Discretion;
			}	
		
	}
	
	//This method stays inside this class as it still a private method
	//Helps convert the classification to a number so it can be compared 
	int Rank(Classification DG) {
		   switch (DG) {
		    case First: return 1;
	        case UpperSecond: return 2;
	        case LowerSecond: return 3;
	        case Third: return 4;
	        default: throw new IllegalArgumentException(); // If fail or discretion was used it will come as invalid as it not in the switch statement
	    }	
		
	}
}
