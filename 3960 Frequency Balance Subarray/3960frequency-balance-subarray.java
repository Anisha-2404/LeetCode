class Solution {
    public int getLength(int[] nums) {
        int n = nums.length;
        int ans = 1;

        for (int l = 0; l < n; l++) {
            Map<Integer, Integer> cnt = new HashMap<>();
            Map<Integer, Integer> freq = new HashMap<>();

            for (int r = l; r < n; r++) {
                int x = nums[r];

                int oldFreq = cnt.getOrDefault(x, 0);
                if (oldFreq > 0) {
                    int c = freq.get(oldFreq);
                    if (c == 1) {
                        freq.remove(oldFreq);
                    } else {
                        freq.put(oldFreq, c - 1);
                    }
                }

                int newFreq = oldFreq + 1;
                cnt.put(x, newFreq);
                freq.put(newFreq, freq.getOrDefault(newFreq, 0) + 1);

                if (isBalanced(cnt, freq)) {
                    ans = Math.max(ans, r - l + 1);
                }
            }
        }

        return ans;
    }

    private boolean isBalanced(Map<Integer, Integer> cnt,
                               Map<Integer, Integer> freq) {

        if (cnt.size() == 1) {
            return true;
        }

        if (freq.size() != 2) {
            return false;
        }

        Iterator<Integer> it = freq.keySet().iterator();
        int f1 = it.next();
        int f2 = it.next();

        int small = Math.min(f1, f2);
        int large = Math.max(f1, f2);

        return large == 2 * small;
    }
}