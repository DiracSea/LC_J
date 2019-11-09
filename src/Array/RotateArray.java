package Array;

public class RotateArray {
    // brute force
    // rotate all the elements of the array in k steps
    // TC O(k*n)
    // SC O(1)
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int sh = k%n; // shift distance
        int tmp; int pre; // temporary space
        for (int i = 0; i < k; i++) {
            pre = nums[n-1];
            for (int j = 0; j < n; j++) {
                tmp = nums[j];
                nums[j] = pre;
                pre = tmp;
            }
        }
    }

    // extra array
    // TC O(n)*2
    // SC O(n)
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        int[] tmp = new int[n]; //temporary array
        for(int i = 0; i < n; i++) {
            tmp[(i + k) % n] = nums[i];
        }
        for(int i = 0; i < n; i++) {
            nums[i] = tmp[i];
        }
    }

    // Cyclic Replacement
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;

        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
    // reverse two sub-array
    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);

    }

    public void reverse(int[] nums, int head, int tail) {
        int temp;
        while(head < tail) {
            temp = nums[head];
            nums[head] = nums[tail];
            nums[tail] = temp;
            head++;
            tail--;
        }
    }
}
