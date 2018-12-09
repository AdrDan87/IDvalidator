import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class IDChecker implements Validator {
private static final int[] weights = new int[]{7,3,1,9,7,3,1,7,3};
  private Map<Character,Integer> LETTERS_TO_NUMBERS = new HashMap<Character, Integer>() {
       {
           int value = 10;
           for (char ch = 'A'; ch <= 'Z'; ++ch) {
               put(ch, value);
               value++;
           }
       }
   };




    @Override
    public boolean validate(String toCheck) {
        String idNumber = toCheck.toUpperCase();
        final Pattern pattern = Pattern.compile("[A-Z]{3}\\d{6}");
if (!pattern.matcher(idNumber).matches()) {
    throw new IllegalArgumentException("Invalid ID number");
}
int sum = 0;
        for (int i = 0; i <3; i++) {
            sum += LETTERS_TO_NUMBERS.get(idNumber.charAt(i)) * weights[i];
        }
        for (int i = 3; i <idNumber.length() ; i++) {
            sum += Character.getNumericValue(idNumber.charAt(i)) * weights[i];
        }
        return sum % 10 == 0;

    }



}




