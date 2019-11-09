package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainDup {
    // Hash Map
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();

        for (int n: nums) {
            if (!m.containsKey(n))
                m.put(n, 1);
            else
                return true;
        }
        return false;
    }

    // Hash Set
    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();

        for (int n: nums) {
            if (s.contains(n))
                return true;
            else
                s.add(n);
        }
        return false;
    }
    // Normalization O(n) O(k)
    public boolean containsDuplicate2(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int n: nums) {
            if (n > max) max = n;
            if (n < min) min = n;
        }

        int range = max - min + 1;
        if (range < nums.length) return true;
        int[] count = new int[range];
        for (int n: nums) {
            count[n - min]++;
            if(count[n - min] > 1) return true;
        }
        return false;
    }
}
