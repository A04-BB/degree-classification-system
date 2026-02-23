import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

class ProfileTest {
    
	// Test if the profile is null and if it is it throws an exception
	@Test
	void testConstructorifListisNULL() {
		assertThrows(IllegalArgumentException.class, () -> {
            new Profile(null);
        });
		
	}
	
	//Test if the profile is empty and throws an exception
	@Test
	void testConstructorifListisEMPTY() {
		assertThrows(IllegalArgumentException.class, () -> {
            new Profile(List.of());
        });
	}
	
	//Test if the profile has any fail grades and throws an exception
	@Test
	void testConstructorifListHasaFAILGRADE() {
		List<Grade> g = List.of(new Grade(1),new Grade(1),new Grade(2),new Grade(20));
		assertThrows(IllegalArgumentException.class, () -> {
            new Profile(g);
        });
	}
	
	//Test if the overall classification for the profile is a first
	@Test
	void OverallClassificationForFirstTest() {
		List<Grade> g = List.of(new Grade(6),new Grade(6),new Grade(1),new Grade(1));
		Profile p = new Profile(g);
		assertEquals(Classification.First, p.classify());
	}
	
	//Test if the overall classification for the profile is a UpperSecond
	@Test
	void OverallClassificationForUpperSecondTest() {
		List<Grade> g = List.of(new Grade(2),new Grade(6),new Grade(6),new Grade(6));
		Profile p = new Profile(g);
		assertEquals(Classification.UpperSecond, p.classify());
	}
	
	//Test if the overall classification for the profile is a LowerSecond
	@Test
	void OverallClassificationForLowerSecondTest() {
		List<Grade> g = List.of(new Grade(10),new Grade(3),new Grade(10),new Grade(10));
		Profile p = new Profile(g);
		assertEquals(Classification.LowerSecond, p.classify());
	}
	
	//Test if the overall classification for the profile is a Third
	@Test
	void OverallClassificationThirdTest() {
		List<Grade> g = List.of(new Grade(14),new Grade(15),new Grade(13),new Grade(6));
		Profile p = new Profile(g);
		assertEquals(Classification.Third, p.classify());
	}
	
	//Test if the profile is clear when the classification equals a first with 1 grade that a third
	@Test
	void ifClearProflieTrueWithFirstTest() {
		List<Grade> g = List.of(new Grade(1),new Grade(1),new Grade(1),new Grade(15));
		Profile p = new Profile(g);
		assertTrue(p.isClear());
	}
	
	//Test if the profile is clear when the classification equals a UpperSecond with 1 grade that a Third
	@Test
	void ifClearProflieTrueWithUppperSecondTest() {
		List<Grade> g = List.of(new Grade(6),new Grade(5),new Grade(7),new Grade(15));
		Profile p = new Profile(g);
		assertTrue(p.isClear());
	}
	
	//Test if the profile returns false with the grade is a first with 2 grades that are a Third
	@Test
	void ifClearProflieFalseTest() {
		List<Grade> g = List.of(new Grade(1),new Grade(1),new Grade(15),new Grade(15));
		Profile p = new Profile(g);
		assertFalse(p.isClear());
	}
	
	//Test if a LowerSecond profile is clear with 2 Third grades 
	@Test
	void ifClearProflieWithLowerSecondTest() {
		List<Grade> g = List.of(new Grade(13),new Grade(14),new Grade(15),new Grade(16));
		Profile p = new Profile(g);
		assertTrue(p.isClear());
	}

}
