package Array;


public class BullsAndCows {
    // use one array to store number of basic number
    public String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        int[] tmp = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            // use two int to store iterate number
            int a = secret.charAt(i) - '0';
            int b = guess.charAt(i) - '0';
            if (a == b) {
                // if equal, means bull plus
                bull++;
            }
            else {
                // if not equal, then add/minus to corresponding positions.
                if (tmp[a]++ < 0) { // secret then plus, so it is positive. find negative means repeat
                    cow++;
                }
                if (tmp[b]-- > 0) { // guess then minus, so it is negative. find positive means repeat
                    cow++;

                }
            }
        }
        return bull+"A"+cow+"B";
    }

    // use two arrays to store numbers of basic number of two strings..
    public String getHint1(String secret, String guess) {
        int bull = 0, cow = 0;
        int[] s = new int[10], g = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            int a = secret.charAt(i) - '0';
            int b = secret.charAt(i) - '0';
            if (a == b) {
                bull++;
            }
            else {
                s[a]++;
                g[b]++;
            }
        }

        for(int i = 0; i < s.length; i++) {
            cow+=Math.min(s[i],g[i]);
        }
        return bull+"A"+cow+"B";
    }
}
