package array;

public class Tmp4 {

    public String makeGood(String s) {
        StringBuffer sb = new StringBuffer(s);

        for (int i = 0; i < sb.length() - 1; i++) {
            if (Character.toLowerCase(sb.charAt(i)) == Character.toLowerCase(sb.charAt(i + 1))) {
                if (diffCase(sb.charAt(i), sb.charAt(i + 1))) {
                    sb.deleteCharAt(i + 1);
                    sb.deleteCharAt(i);
                    if (i > 0) {i-=2;}
                    if(i == 0) i--;
                }
            }
        }
        return sb.toString();
    }

    private boolean diffCase(char charAt, char charAt1) {
        return Character.isUpperCase(charAt) ? Character.isLowerCase(charAt1) : Character.isUpperCase(charAt1);
    }

}

class R {
    public static void main(String[] args) {
        System.out.println(new Tmp4().makeGood("abBAcC"));
    }
}
