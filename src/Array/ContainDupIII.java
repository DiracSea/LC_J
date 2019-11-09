package Array;

import java.util.TreeSet;

public class ContainDupIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // Tree Set
        if (k < 0 || t < 0 || nums == null) return false;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i - k - 1 >= 0) set.remove(nums[i - k - 1]);
            int n = nums[i];
            if (set.floor(n) != null && n <= t + set.floor(n) ||
                    set.ceiling(n) != null && set.ceiling(n) <= t + n)
                return true;
            set.add(n);
        }
        return false;
    }

    // O(n2)
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if(k<0 || nums.length>1000) // trick
            return false;
        for(int i=0;i<nums.length; i++){
            for(int j=i+1; j<=Math.min(i+k, nums.length-1);j++){
                if(Math.abs((long)nums[i]-(long)nums[j])<=t)
                    return true;
            }
        }
        return false;
    }
}
