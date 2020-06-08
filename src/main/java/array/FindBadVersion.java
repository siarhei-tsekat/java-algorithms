package array;

public class FindBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid))
                right = mid;
            else left = mid + 1;
        }
        return left;
    }
}

class VersionControl {
    public boolean isBadVersion(int i) {
        return false;
    }
}
