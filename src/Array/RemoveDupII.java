package Array;

public class RemoveDupII {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n:nums) {
            if (i < 2 || n > nums[i-2]) { //前两个保留，每次只保留两个相同值
                nums[i++] = n;
            }
        }
        return i;
    }
    public int removeDuplicates1(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return n;
        }
        int i = 2;
        for (int j = 2; j < n; j++) {
            if (nums[i-2] != nums[j]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

}
