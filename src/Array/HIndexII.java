package Array;

public class HIndexII {
    public int hIndex(int[] citations) {
        int count = 0;
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int idx = n - i - 1;
            if (citations[idx] > i) {
                count++;
            }
        }
        return count;
    }
}
