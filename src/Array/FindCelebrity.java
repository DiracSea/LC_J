package Array;

import java.util.Stack;

public class FindCelebrity {

    //example
    static int MATRIX[][] = { { 0, 0, 0, 1, 0 },
                            { 0, 0, 0, 1, 0 },
                            { 0, 0, 0, 1, 0 },
                            { 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 1, 0 } };
    //return true is a knows b,
    static boolean knows(int a, int b) {
        boolean res = (MATRIX[a][b] == 1) ? true : false;
        return res;
    }
    /*
    * 1. return -1, if celebrity not exists
    * 2. return id, if it exists.
    * */

    // common method, two loops
    public static int findCelebrity(int n) {
        for (int i = 0, j = 0; i < n; i++) {
            for(j = 0; j < n; j++) {
                if(j != i && (knows(i, j) || !knows(j, i))) {
                    break;
                }
            }
            if(j == n) {
                return i;
            }
        }
        return -1;
    }

    // stack
    public static int findCelebrity1(int n) {
        Stack<Integer> st = new Stack<>();
        int c; // third person

        // Step 1: Push everyone to stack
        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            // Step 2: Pop top 2 persons, and knows
            int a = st.pop();
            int b = st.pop();

            // Step 3: Push remain
            if (knows(a, b)) {
                st.push(b);
            }
            else if (knows(b, a)) {
                st.push(a);
            }
            else {
                return -1;
            }
        }

        c = st.pop();

        // Step 5: Check if the last person is the celebrity
        for(int i = 0; i < n; i++) {
            if(i != c && (knows(c,i) || !knows(i,c)))
                return -1;
        }
        return c;
    }



}
