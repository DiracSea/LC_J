package MS; 
public class trapRain {
    public int trap(int[] height) {
        // two pointers 
        
        int n = height.length; 
        int left = 0, left_max = 0; 
        int right = n-1, right_max = 0; 
        int rest = 0; 
        
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left]; 
                }
                else {
                    rest += left_max - height[left]; 
                }
                left++; 
            }
            else {
                if (height[right] >= right_max) {
                    right_max = height[right]; 
                }
                else {
                    rest += right_max - height[right]; 
                }
                right--; 
            }
        }
        return rest; 
    }
    public int trap1(int[] height) {
        // dp 
        if (height.length == 0) 
            return 0; 
        int ans = 0, size = height.length; 
        int left_max[] = new int[size]; 
        int right_max[] = new int[size]; 
        
        left_max[0] = height[0]; 
        
        for (int i = 1; i < size; i++) {
            left_max[i] = Math.max(height[i], left_max[i-1]); 
        }
        
        right_max[size-1] = height[size-1]; 
        
        for (int i = size - 2; i >= 0; i--) {
            right_max[i] = Math.max(height[i], right_max[i+1]); 
        }
        
        for (int i = 1; i < size-1; i++) {
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return ans; 
    }
}