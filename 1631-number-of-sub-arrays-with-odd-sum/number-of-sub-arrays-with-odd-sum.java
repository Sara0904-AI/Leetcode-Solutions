class Solution {
    public int numOfSubarrays(int[] arr) {
        int m = 1000000007, ans = 0, sum = 0, even = 1, odd = 0;

        for (int x : arr) {
            sum += x;

            if (sum % 2 != 0) {
                ans = (ans + even) % m;
                odd++;
            } else {
                ans = (ans + odd) % m;
                even++;
            }
        }

        return ans;
    }
}
