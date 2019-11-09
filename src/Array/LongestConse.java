package Array;

import java.util.HashSet;
import java.util.Set;

public class LongestConse {
    // Hash Map

    // Hash Set
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;

        Set<Integer> set = new HashSet<Integer>();

        for (int i: nums) set.add(i);

        int l_max = 1;
        for (int i: nums) {
            if (set.remove(i)) {// i has not been visited
                int val = i;
                int sum = 1;
                while (set.remove(val - 1)) val--; // until reach the min consecutive
                sum += i - val;

                val = i;
                while (set.remove(val + 1)) val++;
                sum += val - i;

                l_max = Math.max(l_max, sum);

            }
        }
        return l_max;
    }

}
