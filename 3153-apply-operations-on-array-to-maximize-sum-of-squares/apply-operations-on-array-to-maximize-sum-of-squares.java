class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long M = 1_000_000_007;
        int[] cnt = new int[31];
        for (int x : nums) {
            for (int i = 0; i < 31; i++) {
                if (((x >> i) & 1) == 1) {
                    cnt[i]++;
                }
            }
        }
        long ans = 0;
        for (int j = 0; j < k; j++) {
            long cur = 0;
            for (int i = 0; i < 31; i++) {
                if (cnt[i] > 0) {
                    cur |= (1L << i);
                    cnt[i]--;
                }
            }
            ans = (ans + (cur * cur) % M) % M;
        }
        return (int) ans;
    }
}
