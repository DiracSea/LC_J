package Array;
//27
public class RemoveElement {
    /*
    * 1. use two pointers
    * 2. one pointer is to iterate the list
    * 3. another one is to count: not equal
    * 4. cover the repeats
    * 5. use if
    * */
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int i = 0;
        for (int j = 0; j < len; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /*
    * 1. removes are rare
    * 2. one pointer is from the start
    * 3. another one is from the end
    * 4. equal p2--; not equal p1++
    * */
    public int removeElement2(int[] nums, int val) {
        int len = nums.length;
        int i = 0;
        while (i < len) {
            if (nums[i] == val) {
                nums[i] = nums[len - 1];
                len--;
            }
            else {
                i++;
            }
        }
        return len;
    }
}
