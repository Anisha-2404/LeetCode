class Solution {
    public int searchInsert(int[] nums, int target) {
        int a = nums.length;
        
        for(int i = 0; i < a; i++) {
            // 1. If found, or if we hit a number larger than target,
            // this index 'i' is exactly where the target belongs.
            if(nums[i] == target || nums[i] > target) {
                return i;
            }
        }
        
        // 2. If the loop finishes, the target is larger than every 
        // number in the array, so it belongs at the very end.
        return a;
    }
}
