package array;

/***
 * You are driving a vehicle that has capacity empty seats initially available for passengers.
 * The vehicle only drives east (ie. it cannot turn around and drive west.)
 *
 * Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information
 * about the i-th trip: the number of passengers that must be picked up, and the locations to pick them
 * up and drop them off.  The locations are given as the number of kilometers due east from your vehicle's
 * initial location.
 *
 * Return true if and only if it is possible to pick up and drop off all passengers for all the given trips.
 */

public class CarPooling {
    public static void main(String[] args) {

        System.out.println("false => " + new Solution__().carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4));
        System.out.println("true => " + new Solution__().carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5));
        System.out.println("true => " + new Solution__().carPooling(new int[][]{{2, 1, 5}, {3, 5, 7}}, 3));
        System.out.println("true => " + new Solution__().carPooling(new int[][]{{3, 2, 7}, {3, 7, 9}, {8, 3, 9}}, 11));
    }
}

class Solution__ {
    int capacity;
    int[] timeTable = new int[1000];

    public boolean carPooling(int[][] trips, int capacity) {
        this.capacity = capacity;

        for (int i = 0; i < trips.length; i++) {
            if (!spaceIsEnough(trips[i])) return false;
        }
        return true;
    }

    private boolean spaceIsEnough(int[] passengerInfo) {
        if (checkSpace(passengerInfo[0], passengerInfo[1], passengerInfo[2])) {
            placePassenger(passengerInfo);
            return true;
        }
        return false;
    }

    private boolean checkSpace(int amount, int from, int to) {
        for (int i = from; i < to; i++)
            if (capacity - timeTable[i] < amount) return false;
        return true;
    }

    private void placePassenger(int[] passengerInfo) {
        for (int i = passengerInfo[1]; i < passengerInfo[2]; i++)
            timeTable[i]+=passengerInfo[0];
    }
}
