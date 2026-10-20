class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;
        
        List<Integer> divs = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divs.add(i);
                if (i * i != n) {
                    divs.add(n / i);
                }
            }
        }
        
        for (int k : divs) {
            if (check(nums, n, k)) {
                ans += k;
            }
        }
        
        return ans;
    }
    
    private boolean check(int[] nums, int n, int k) {
        int m = n / k;
        int pMax = Integer.MIN_VALUE;
        
        for (int b = 0; b < m; b++) {
            int s = b * k;
            int e = s + k;
            
            int cMin = Integer.MAX_VALUE;
            int cMax = Integer.MIN_VALUE;
            int drop = -1;
            
            for (int i = s; i < e; i++) {
                cMin = Math.min(cMin, nums[i]);
                cMax = Math.max(cMax, nums[i]);
                
                if (i > s && nums[i] < nums[i - 1]) {
                    if (drop != -1) {
                        return false;
                    }
                    drop = i;
                }
            }
            
            if (drop != -1) {
                if (nums[e - 1] > nums[s]) {
                    return false;
                }
            }
            
            if (cMin < pMax) {
                return false;
            }
            
            pMax = cMax;
        }
        
        return true;
    }
}
