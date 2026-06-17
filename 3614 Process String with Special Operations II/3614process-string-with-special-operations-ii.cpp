class Solution {
public:
    char processStr(string s, long long k) {
        const long long INF = 4e18;

        int n = s.size();
        vector<long long> len(n);

        long long cur = 0;

        for (int i = 0; i < n; i++) {
            char ch = s[i];

            if ('a' <= ch && ch <= 'z') {
                cur = min(INF, cur + 1);
            }
            else if (ch == '*') {
                if (cur > 0) cur--;
            }
            else if (ch == '#') {
                cur = min(INF, cur * 2);
            }
            // '%'
            len[i] = cur;
        }

        if (k >= cur) return '.';

        long long idx = k;

        for (int i = n - 1; i >= 0; i--) {
            long long prev = (i == 0 ? 0 : len[i - 1]);
            char ch = s[i];

            if ('a' <= ch && ch <= 'z') {
                if (idx == prev) return ch;
            }
            else if (ch == '#') {
                if (idx >= prev) idx -= prev;
            }
            else if (ch == '%') {
                idx = len[i] - 1 - idx;
            }
            // '*' needs no index change
        }

        return '.';
    }
};