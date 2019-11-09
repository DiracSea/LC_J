package Array;

public class JumpGameII {
    public int jump(int[] nums) {
        int reach = 0, step = 0, tail = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            reach = Math.max(reach, i + nums[i]);
            if (i == tail) {
                tail = reach;
                step++;
            }
        }
        return step;
    }
}
