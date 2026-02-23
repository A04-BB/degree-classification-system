import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class DegreeTest {

	
	//Test to see if year2 list of grades is null throws an exception
	@Test
	void testConstructorIfYear2IsNull() {
	    assertThrows(IllegalArgumentException.class, () -> new Degree(null, null)); 
	}
	
	//Test to see if year3 list of grades is null throws an exception
	@Test
	void testConstructorIfYear3IsNull() {
		List<Grade> year2 = List.of(new Grade(1),new Grade(1),new Grade(2),new Grade(2));
	    assertThrows(IllegalArgumentException.class, () -> new Degree(year2, null)); 
	}
	
    //Test if year2 contains more or less than 4 grades in the list it throws an exception
	@Test
	void testConstructorifListHasMorethan4() {
		List<Grade> year2 = List.of(new Grade(1),new Grade(1),new Grade(2));
		List<Grade> year3 = List.of(new Grade(1),new Grade(1),new Grade(2),new Grade(2));
		assertThrows(IllegalArgumentException.class, () -> {
            new Degree(year2, year3);
        });
	}
	
	//Test if year3 contains more or less than 4 grades in the list it throws an exception
	@Test
	void testConstructorifListHasMorethan4ForYear3() {
		List<Grade> year2 = List.of(new Grade(1),new Grade(1),new Grade(2),new Grade(2));
		List<Grade> year3 = List.of(new Grade(1),new Grade(1),new Grade(2),new Grade(2),new Grade(2));
		assertThrows(IllegalArgumentException.class, () -> {
            new Degree(year2, year3);
        });
	}

	//Test if year 2 has a fail grade in the list an throws an exception
	@Test
	void testConstructorifyear2HasaFAILGRADE() {
		List<Grade> year2 = List.of(new Grade(1),new Grade(1),new Grade(2),new Grade(17));
		List<Grade> year3 = List.of(new Grade(1),new Grade(1),new Grade(2),new Grade(3));
		assertThrows(IllegalArgumentException.class, () -> {
            new Degree(year2, year3);
        });
	}
	
	//Test if year 3 has a fail grade in the list an throws an exception
	@Test
	void testConstructorifYear3HasFailGrade() {
	    List<Grade> year2 = List.of(new Grade(1), new Grade(1), new Grade(2), new Grade(3));
	    List<Grade> year3 = List.of(new Grade(1), new Grade(1), new Grade(2), new Grade(17)); 
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Degree(year2, year3);
	    });
	}

	
	//Test the overall degree grade is a first when both level 5 and level 6 are equal 
	void ifBothLevelsEqualTest() {
		List<Grade> year2 = List.of(new Grade(1),new Grade(1),new Grade(6),new Grade(6));
		List<Grade> year3 = List.of(new Grade(1),new Grade(1),new Grade(6),new Grade(6));
		Degree degree = new Degree(year2, year3);
		assertEquals(Classification.First, degree.classify());
	}
	
	//Test the overall degree grade is a UpperSecond when level 6 is better than level 5 and level 6 is clear 
	@Test
	void ifLevel6BetterThanLevel5Test() {
	    List<Grade> year2 = List.of(new Grade(9), new Grade(10), new Grade(11), new Grade(12));
	    List<Grade> year3 = List.of(new Grade(5), new Grade(6), new Grade(9), new Grade(10));
        Degree degree = new Degree(year2, year3);
        assertEquals(Classification.UpperSecond, degree.classify());
        
	} 
	
	//Test the overall degree grade is a LowerSecond when level 5 is better than level 6 and level 5 is clear
	@Test
	void ifL5IsBetterThanL6WithLowerSecond() {
	    List<Grade> year2 = List.of(new Grade(9), new Grade(10), new Grade(11), new Grade(12)); 
	    List<Grade> year3 = List.of(new Grade(13), new Grade(14), new Grade(15), new Grade(16)); 
	   
	    Degree degree = new Degree(year2, year3);
	    assertEquals(Classification.LowerSecond, degree.classify());
	}
	
	//Test the overall degree grade is a Third when level 6 and level 5 are equal 
    @Test
	void ifBothLevelsAreThird() {
        List<Grade> year2 = List.of(new Grade(13), new Grade(14), new Grade(15), new Grade(16));
        List<Grade> year3 = List.of(new Grade(13), new Grade(14), new Grade(15), new Grade(16) );
        
        Degree degree = new Degree(year2, year3);
	    assertEquals(Classification.Third, degree.classify());
    }
    
    
    //Test level 6 is not clear (level 6 reaches discretion)
    @Test
    void testDiscretionWhenLevel6NotClear() {
        List<Grade> year2 = List.of(new Grade(10), new Grade(10), new Grade(10), new Grade(10));//LowerSecond
        List<Grade> year3 = List.of(new Grade(6), new Grade(6), new Grade(15), new Grade(15));// 2xUpperSecond 2xthird (unclear profile)
        Degree degree = new Degree(year2, year3);
        assertEquals(Classification.Discretion, degree.classify());
    }
   
   

    //Test level5 profile is better than level 6 profile by more than one classification
    @Test
    void testWhenLevel5IsBetterThanLevel6ByMoreThanOne() {
        List<Grade> year2 = List.of(new Grade(6), new Grade(6), new Grade(6), new Grade(6));//UpperSecond
        List<Grade> year3 = List.of(new Grade(15), new Grade(15), new Grade(15), new Grade(15));//Third
        Degree degree = new Degree(year2, year3);
        assertEquals(Classification.Discretion, degree.classify());
    }
   
    //Test rank method and if the classification is discretion throws an exception
    @Test
    void testRankThrowsException() {
        List<Grade> year2 = List.of(new Grade(6), new Grade(6), new Grade(6), new Grade(6));
        List<Grade> year3 = List.of(new Grade(15), new Grade(15), new Grade(15), new Grade(15));
        Degree degree = new Degree(year2,year3);
        assertThrows(IllegalArgumentException.class, () -> degree.Rank(Classification.Discretion));
    }
    
    //Test if level6 is better than level5 by more than one classification
    @Test
    void tesLevel6BetterThanLevel5ByMoreThanOne() {
    	// Year 2: all Lower Seconds (points 9–12)
        List<Grade> year2 = List.of(new Grade(9), new Grade(10), new Grade(11), new Grade(12));// LowerSecond
        List<Grade> year3 = List.of(new Grade(1), new Grade(1), new Grade(8), new Grade(7));// 2 x first 2 x UpperSecond
    		Degree degree = new Degree(year2, year3);
    		assertEquals(Classification.Discretion, degree.classify());
    }
    
    //Test level5 profile is better than level 6 profile by more than one classification 
    @Test
    void testLevel5BetterThanLevel6ByMoreThanOne() {
    	List<Grade> year2 = List.of(new Grade(1), new Grade(1), new Grade(1), new Grade(1));// First
    	List<Grade> year3 = List.of(new Grade(10), new Grade(11), new Grade(9), new Grade(12));// LowerSecond
    		Degree degree = new Degree(year2, year3);
    		assertEquals(Classification.Discretion, degree.classify());

        
    }


}
