package string;

public class FindSubstringInString {
    public static void main(String[] args) {
        System.out.println("true -> " + contains("aabbssdabba", "abba"));
        System.out.println("false -> " + contains("aabbssdadda", "abba"));
        System.out.println("false -> " + contains("", "abba"));
        System.out.println("false -> " + contains("asassss", ""));
    }

    public static boolean contains(String target, String sub) {

        int i, j;
        int t = target.length();
        int s = sub.length();

        for (i = 0; i <= (t - s); i++) {
            j = 0;

            while (j < s && target.charAt(i + j) == sub.charAt(j)) {
                j++;
                if (j == s) return true;
            }
        }

        return false;
    }
}
