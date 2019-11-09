package Array;

public class RemoveDup {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0;
        if (n == 0) {
            return 0; // list has no element
        }
        // remaining instances
        int pre = 0;
        for (int j = 0; j < n; j++) {
            if (nums[pre] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            pre = j;
        }
        return ++i;
    }
    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return ++i;
    }
}
