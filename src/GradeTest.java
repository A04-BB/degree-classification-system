import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import org.junit.jupiter.api.Test;

class GradeTest {
	
	// Test to verify that creating a grade with a value below 0
	@Test
    void NOTvalidBELOWconstructor() {
          assertThrows(IllegalArgumentException.class, () -> {
              new Grade(-1);
            });
    }
	
	// Test to verify that creating a grade with a value above 23 
	@Test
    void NOTvalidABOVEconstructor() {
          assertThrows(IllegalArgumentException.class, () -> {
              new Grade(24);
            });
    }
	
	// Test getPoints() correctly returns the stored points value
	@Test
    void VALIDgetPOINTS() {
        Grade g = new Grade(15);
        assertTrue(g.getPoints() == 15);

    }
	
	// Test that grade is classified as first points(1-4)
	@Test
	void VALIDfirstGRADE() {
	    Grade g = new Grade(1);
	    assertEquals(Classification.First, g.classify());
	}
	
	// Test that grade is classified as UpperSecond points(5-8)
	@Test
	void VALIDuppersecondtGRADE() {
	    Grade g = new Grade(6);
	    assertEquals(Classification.UpperSecond, g.classify());
	}
	
	// Test that grade is classified as LowerSecond points(9-12)
	@Test
	void VALIDLowersecondGRADE() {
	    Grade g = new Grade(9);
	    assertEquals(Classification.LowerSecond, g.classify());
	}
	
	// Test that grade is classified as Third points(13-16)
	@Test
	void VALIDthirdGRADE() {
	    Grade g = new Grade(16);
	    assertEquals(Classification.Third, g.classify());
	}
	
	// Test that grade is classified as fail points(9-12)
	@Test
	void VALIDfaildGRADE() {
	    Grade g = new Grade(20);
	    assertEquals(Classification.Fail, g.classify());
	}
	
	//This test is another way of testing classification of a grade
	//One way that it is better way of testing it that saves creating multiple test 
	@ParameterizedTest
    @CsvSource({
        "1, First", // Grade 1 should classify as first
        "6, UpperSecond",
        "9, LowerSecond",
        "16, Third",
        "20, Fail"
    })
    void testOverallGrade(int number, String expected) {
        Grade g = new Grade(number);
        Classification result = g.classify();
        
        // compare the classification 
        // Valueof allows it to compare the values of enum with CsvSource values
        assertEquals(Classification.valueOf(expected), result);
    }
    
	// Test fromPercentage() if it is below 0
	@Test
    void NOTvalidBELOWgetpercentage() {
          assertThrows(IllegalArgumentException.class, () -> {
              Grade.fromPercentage(-2);
            });

    }
	
	// Test fromPercentage() with value above 100 
	@Test
    void NOTvalidABOVEgetpercentage() {
          assertThrows(IllegalArgumentException.class, () -> {
              Grade.fromPercentage(101);
            });

    }
	 
	//Test to see if the percentage returns the correct grade
	@ParameterizedTest
    @ValueSource(ints = {85, 78, 74, 71, 68, 65, 63, 61, 58, 56, 53, 51, 48, 45, 43, 41, 37, 32, 26, -1, 28})
    void FrompercentageTOGradeTest(int g) {
		//null is there to make sure valid grade have been entered and method has not failed
		//and not null means the method didn't fail and it returned an object
        assertTrue(Grade.fromPercentage(g) != null);
    }
	
	
	

}
