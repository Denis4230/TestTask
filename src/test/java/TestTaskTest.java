import junit.framework.TestCase;

public class TestTaskTest extends TestCase {

    public void testValidate() {
        
            assertEquals("2-()", TestTask.validate("(()"));
            assertEquals("4-()()", TestTask.validate(")()())"));
            assertEquals("6-(()())", TestTask.validate(")(()())"));
            assertEquals("0", TestTask.validate(")("));
    }
    public void testValidateTwo() {
        assertEquals("14-(()()()()(()))", TestTask.validate(")(()()()()(((())()"));
        assertEquals("12-(())(((())))", TestTask.validate("(())((((((())))"));
    }
}