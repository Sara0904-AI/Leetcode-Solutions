class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int best =1, up=1, down=1;
        for(int i=1; i<nums.length; i++){
            if (nums[i-1]<nums[i]) up=up+1;
            else up=1;

            if(nums[i-1]>nums[i]) down=down+1;
            else down=1;

            best=Math.max(best, Math.max(up,down)); 
        }
        return best;
    }
}