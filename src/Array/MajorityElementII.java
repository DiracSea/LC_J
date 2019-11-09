package Array;

import java.util.*;

public class MajorityElementII {
    //Hash Map
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        List<Integer> major = new ArrayList<Integer>();

        for(int num: nums) {
            //map.put(num, map.getOrDefault(num, 0)+1);
            if (!m.containsKey(num))
                m.put(num, 1);
            else
                m.put(num, m.get(num) + 1);
            //

            if (m.get(num) > nums.length/3 && !major.contains(num)) {
                major.add(num);
            }
        }
        return major;
    }

}
