class Solution {
    public int singleNumber(int[] nums) {
        // HashSet O(N) O(N) 
        // every element appears three times except for one
        Set<Long> set = new HashSet<>(); 
        long sumSet = 0, sumArray = 0; 
        for (int n: nums) {
            sumArray += n; 
            set.add(n);
        }
        for (long s: set) sumSet += s; 
        return (int)((3*sumSet - sumArray)/2);
    }
    
    // HashMap

    public int singleNumber1(int[] nums) {
        // Bitwise Ops 
        
        // NOT, AND, XOR
        int seenOnce = 0, seenTwice = 0; 
        
        for (int num: nums) {
            seenOnce = ~seenTwice & (seenOnce ^ num); 
            seenTwice = ~seenOnce & (seenTwice ^ num); 
        } 
        return seenOnce; 
    }
}