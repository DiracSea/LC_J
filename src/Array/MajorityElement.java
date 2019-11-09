package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    // HashMap
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        int major = 0;
        for (int num: nums) {
            //map.put(num, map.getOrDefault(num, 0)+1);
            if (!myMap.containsKey(num))
                myMap.put(num, 1);
            else
                myMap.put(num, myMap.get(num) + 1);
            // 

            if (myMap.get(num) > nums.length/2) {
                major = num;
                break;
            }
        }
        return major;
    }
    // Sort
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length/2];
    }

    // Bit Manipulation
    // 因为必有最大数，分别比较每位，得到所有为一的位，转化为目标数
    public int majorityElement2(int[] nums) {
        int bit[] = new int[32];
        int major = 0;
        for (int num: nums) {
            for (int i = 0; i < 32; i++) { // 轮流count32位数，根据经验取的数不大于32位。
                if ((num>>(31-i) & 1) == 1) // 该位为一的累加
                    bit[i]++;
            }
        }
        for (int i = 0; i < 32; i++) {
            bit[i] = bit[i]>nums.length/2?1:0; // 大于一般的即为一
            major += bit[i]*(1<<(31-i)); // 将对应的位化为10进制数
        }
        return major;
    }
}
