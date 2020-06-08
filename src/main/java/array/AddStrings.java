package array;

public class AddStrings {

    public String addStrings(String num1, String num2) {

        StringBuilder result = new StringBuilder();
        int carry = 0;

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0) {

            int iValue = i >= 0 ? Character.getNumericValue(num1.charAt(i)) : 0;
            int jValue = j >= 0 ? Character.getNumericValue(num2.charAt(j)) : 0;

            int sum = carry + iValue + jValue;
            carry = sum / 10;

            result.append(sum % 10);
            i--;
            j--;
        }

        if (carry > 0) result.append(carry);

        return result.reverse().toString();

    }
}
