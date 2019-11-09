package Array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<List<Integer>>(); // two dimension array
        ArrayList<Integer> row = new ArrayList<Integer>(); // single array
        for(int i = 0; i < numRows; i++) {
            row.add(0,1);
            for(int j = 1; j < row.size() - 1; j++)
                row.set(j, row.get(j) + row.get(j+1)); // [1,1,1] -> [1,2,1] -> [1,1,2,1] -> [1,3,3,1] -> [1,1,3,3,1]
            rows.add(new ArrayList<Integer>(row));
        }
        return rows;
    }

    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> rows = new ArrayList<List<Integer>>();

        for(int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for(int j = 0; j < i + 1; j++) { // include head and tail
                if(j == 0 || j == i)
                    row.add(1);
                else {
                    int a = rows.get(i - 1).get(j);
                    int b = rows.get(i - 1).get(j - 1);
                    row.add(a + b);
                }
            }
            rows.add(row);
        }
        return rows;
    }
}
