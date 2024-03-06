import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
	@Test(timeout = 500)
	public void testMergeRightEnd() {
		List<String> left = Arrays.asList("a", "b", "c");
		List<String> right = Arrays.asList("a", "d");
		List<String> merged = ListExamples.merge(left, right);
		List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
		assertEquals(expected, merged);
	}

	@Test(timeout = 500)
	public void testMergeLeftEnd() {
		List<String> input1 = new ArrayList<>(Arrays.asList("a", "c", "e", "g"));
		List<String> input2 = new ArrayList<>(Arrays.asList("b", "d", "f"));
		List<String> merged = ListExamples.merge(input1, input2);
		List<String> expected = new ArrayList<>(
			Arrays.asList("a", "b", "c", "d", "e", "f", "g"));
		assertEquals(expected, merged);
	}

	@Test 
	public void testFilter() {
		IsMoon sc = new IsMoon();
		List<String> input = new ArrayList<>(Arrays.asList("moon", "sun", "stars"));
		List<String> expected = new ArrayList<>(Arrays.asList("moon"));
		assertEquals(expected, ListExamples.filter(input, sc));
	}

	@Test 
	public void testFilterSubstring() {
		IsMoon sc = new IsMoon();
		List<String> input = new ArrayList<>(Arrays.asList("moon", "sun", "fullmoon"));
		List<String> expected = new ArrayList<>(Arrays.asList("moon"));
		assertEquals(expected, ListExamples.filter(input, sc));
	}
}
