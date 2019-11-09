package Array;

public class ContainerWithMost {
    // two pointers
    public int maxArea(int[] height) {
        int v = 0;
        int tmp;
        for(int l = 0, r = height.length - 1; l < r;) {
            v = Math.max(v, Math.min(height[l], height[r])*(r - l));
            tmp = height[l] < height[r] ? l++ : r--;
        }
        return v;
    }


}
