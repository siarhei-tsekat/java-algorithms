package array;

public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        if(s.length() == 0) return true;

        int head = 0;
        int tail = s.length() - 1;
        char cHead;
        char cTail;

        while(head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);

            if(!Character.isLetterOrDigit(cHead)) head++;
            else if (!Character.isLetterOrDigit(cTail)) tail--;
            else if(Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) return false;
            else {
                head++;
                tail--;
            }
        }

        return true;
    }
}
