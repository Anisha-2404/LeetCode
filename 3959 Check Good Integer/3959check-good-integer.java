class Solution {
    public boolean checkGoodInteger(int n) {

        int diff = 0;

        while (n > 0) {
            int digit = n % 10;
            diff += digit * digit - digit;
            n /= 10;
        }

        return diff >= 50;
    }
}