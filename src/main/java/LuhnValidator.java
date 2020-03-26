import static java.lang.Character.getNumericValue;
class LuhnValidator {

    boolean isValid(String candidate) {
        
        String spacesCleaned = candidate.replaceAll(" ", "");

        if (spacesCleaned.length() < 2) return false;
        
        String cleaned = spacesCleaned.replaceAll("[^0-9]", "");

        if (cleaned.length() != spacesCleaned.length()) return false;

        int[] digits = new int[cleaned.length()];

        for (int i = 0; i<digits.length; i++) {
            digits[i] = getNumericValue(cleaned.charAt(i));
        }

        for (int i = digits.length-2; i >= 0; i-=2) {
            int doubledDigit = digits[i]*2;

            digits[i] = doubledDigit > 9 ? doubledDigit - 9 : doubledDigit;
        }

        int sum = 0;
        
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
        }
        
        return sum % 10 == 0 ? true : false;        
    }

}
