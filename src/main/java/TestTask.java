import java.util.List;
import java.util.stream.Collectors;

public class TestTask {
    private static final char OPEN = '(';
    private static final char CLOS = ')';

    public static void main(String[] args) {

        System.out.println(validate("(()"));
        System.out.println(validate(")()())"));
        System.out.println(validate(")(()()))"));
        System.out.println(validate(")("));
        
    }

    public static String validate(String initStr) {
        StringBuilder result = new StringBuilder();
        List<Character> closingBracketsWithoutPair = initStr.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
        List<Character> openBracketsWithoutPair = initStr.chars().mapToObj(i -> (char) i).collect(Collectors.toList());

        int counter = 0;


        for (int i = 0; i < initStr.length(); i++) {
            if (initStr.charAt(i) == OPEN) {
                for (int oneFor = i; oneFor < closingBracketsWithoutPair.size(); oneFor++) {
                    if (closingBracketsWithoutPair.get(oneFor) == CLOS) {
                        result.append(initStr.charAt(i));
                        closingBracketsWithoutPair.remove(oneFor);
                        counter++;
                        break;
                    }
                }
            } else if (initStr.charAt(i) == CLOS && result.length() > 0) {
                for (int secondFor = 0; secondFor < openBracketsWithoutPair.size(); secondFor++) {
                    if (openBracketsWithoutPair.get(secondFor) == OPEN) {
                        result.append(initStr.charAt(i));
                        openBracketsWithoutPair.remove(secondFor);
                        counter++;
                        break;
                    }
                }
            }
        }

        if (counter > 9) {
            result.insert(0, counter).insert(2, "-");
        } else if (result.length() > 0) {
            result.insert(0, counter).insert(1, "-");
        } else {
            result.insert(0, counter);
        }

        return result.toString();
    }
}
