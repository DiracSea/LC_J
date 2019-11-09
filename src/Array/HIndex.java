package Array;

public class HIndex {
    // bucket sort
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] bucket = new int[n+1];

        for (int c: citations) {
            if (c >= n)
                bucket[n]++;
            else
                bucket[c]++;
        }

        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += bucket[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }

    // O(n) and O(1)
    public int hIndex1(int[] citations) {
        // Here, we fill the input array with counts, where
        // (-citations[i] - 1) is exactly the number
        // of papers having i publications.
        // Negative because we need to distinguish it from
        // the citation counts that we haven't processed yet.
        // Note that we'll just throw away any counts >= citations.length,
        // but we'll never need those.
        for (int i = 0; i < citations.length; ++i) {
            int count = citations[i];
            if (count < 0)
                continue; // already processed
            citations[i] = -1; // the count starts with 0
            for (int nextCount; count < citations.length &&
                    (nextCount = citations[count]) >= 0; ) {
                // We haven't got enough space to count those
                // >= citations.length, but neither we need them.
                citations[count] = -2; // we've just seen one
                count = nextCount;
            }
            // The loop above could have terminated either
            // 1) because count >= citations.length (we don't count those) or
            // 2) because we hit an element that already stores a count.
            // In the second case we need to increment that count since
            // we've just encountered another element with the same value.
            if (count < citations.length) {
                --citations[count];
            }
        }
        for (int h = 0, less = 0; h < citations.length; ++h) {
            int count = -citations[h] - 1;
            // Logically, the loop below must have this condition:
            // citations.length - less >= h && less + count >= citations.length - h,
            // but the first of these is really redundant. Indeed, it is obviously
            // true on the first iteration, and it follows that if it was true for
            // some "h", then it would be true for "h + 1". Indeed, the "less" variable
            // on this iteration is what "less + count" was on the previous one, so
            // the (citations.length - less >= h) condition, in terms of
            // the previous-iteration values, is nothing but really
            // (citations.length - (less + count) >= h + 1),
            // which is exactly the same as (citations.length - (h + 1) >= (less + count))
            // or (citations.length - h > (less + count)), but if that was false, then
            // (less + count >= citations.length - h) would be true on the previous
            // iteration, and the whole thing would have terminated earlier.
            if (less + count >= citations.length - h)
                return h;
            less += count;
        }
        return citations.length;
    }
}
