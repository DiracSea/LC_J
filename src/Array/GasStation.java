package Array;

public class GasStation {
    /*
        1. Whenever the tank is negative, reset it and let the car start from next point.
        2. In the mean time, add up all of the left gas to total.
        3. If it's negative finally, return -1 since it's impossible to finish.
        4. If it's non-negative, return the last point saved in res;
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int tank = 0;
        int sum = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                sum += tank;
                tank = 0;
                idx = i + 1;
            }
        }
        sum += tank;
        return sum<0?-1:idx;
    }
}
