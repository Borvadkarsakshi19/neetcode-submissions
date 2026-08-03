public class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            long hours = 0;

            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;   // Ceiling division
            }

            if (hours <= h) {
                right = mid;       // Try a smaller speed
            } else {
                left = mid + 1;    // Need a larger speed
            }
        }

        return left;
    }
}