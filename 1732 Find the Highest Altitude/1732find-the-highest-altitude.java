class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int m = 0;

        for (int i = 0; i <= n; i++) 
        {
            int alt =0;

            for (int j = 0; j < i; j++) {
                alt += gain[j];
            }
            m = Math.max(m, alt);
        }

        return m;
    }
}