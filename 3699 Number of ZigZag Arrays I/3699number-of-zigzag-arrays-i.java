
class Solution {
    public int zigZagArrays(int n, int l, int r) {
        long MOD = 1_000_000_007L;
        int m = r - l + 1;

        long[] up = new long[m + 1];
        long[] down = new long[m + 1];

        for (int v = 1; v <= m; v++) {
            up[v] = v - 1;
            down[v] = m - v;
        }

        for (int len = 3; len <= n; len++) {
            long[] nu = new long[m + 1];
            long[] nd = new long[m + 1];

            long[] preD = new long[m + 1];
            long[] preU = new long[m + 1];

            for (int i = 1; i <= m; i++) {
                preD[i] = (preD[i - 1] + down[i]) % MOD;
                preU[i] = (preU[i - 1] + up[i]) % MOD;
            }

            for (int y = 1; y <= m; y++) {
                nu[y] = preD[y - 1];
                nd[y] = (preU[m] - preU[y] + MOD) % MOD;
            }

            up = nu;
            down = nd;
        }

        long ans = 0;

        if (n == 2) {
            return (int)((long)m * (m - 1) % MOD);
        }

        for (int i = 1; i <= m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int)ans;
    }
}