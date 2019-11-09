package Array;

public class FindFirstMissing {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            // if this position not equal to its corresponding number.
            if (nums[i] > 0 && nums[i] <= n && nums[nums[i]-1] != nums[i]) {
                swap(nums, i, nums[i]-1);
            }
            else {
                i++;
            }
        }
        i = 0;
        while (i < n) {
            if (nums[i] != i + 1) {
                break;
            }
            i++;
        }
        return i + 1;
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
