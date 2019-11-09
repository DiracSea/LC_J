package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();

        for (int i = 0; i < rowIndex + 1; i++) { // [1], [1,1], [1,1,1], [1,1,2,1]
            row.add(0,1);
            for (int j = 1; j < i; j++)
                row.set(j, row.get(j) + row.get(j + 1)); // [1,2,1]; [1,3,2,1], [1,3,3,1]

        }
        return row;
    }

    /*
    * row k of Pascal's Triangle:
    [C(k,0), C(k,1), ..., C(k, k-1), C(k, k)]
    and
    C[k,i] = C[k,i-1]*(k-i+1)/i*/
    public List<Integer> getRow1(int rowIndex) {
        Integer[] row = new Integer[rowIndex + 1];
        row[0] = 1;
        for (int i = 1; i < rowIndex + 1; i++) {
            row[i] = (int)((long)row[i - 1]*(rowIndex - i + 1)/i);
        }
        return Arrays.asList(row);
    }
}
