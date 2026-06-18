class Solution {
    public boolean detectCapitalUse(String word) {
        int a = word.length();
        int count = 0;

        for (int i = 0; i < a; i++) {
            if (word.charAt(i) >= 65 && word.charAt(i) <= 90) {
                count++;
            }
        }

        if (count == a) {           // all capitals
            return true;
        } else if (count == 0) {    // all lowercase
            return true;
        } else if (count == 1 &&
                   word.charAt(0) >= 65 &&
                   word.charAt(0) <= 90) {  // only first capital
            return true;
        } else {
            return false;
        }
    }
}