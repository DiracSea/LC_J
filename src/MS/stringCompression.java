package MS;
class Solution {
    public int compress(char[] chars) {
        int idxAns = 0, idx = 0; 
        while (idx < chars.length) {
            char curChar = chars[idx]; 
            int count = 0; 
            
            while (idx < chars.length && chars[idx] == curChar) {
                idx++; 
                count++; 
            }
            chars[idxAns++] = curChar; 
            if (count != 1) 
                for (char c: Integer.toString(count).toCharArray()) // split number
                    chars[idxAns++] = c;
        }
        return idxAns; 
    }
}