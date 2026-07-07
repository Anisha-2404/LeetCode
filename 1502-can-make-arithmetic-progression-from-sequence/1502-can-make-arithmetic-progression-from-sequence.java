public class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        // Step 1: Sort the array
        Arrays.sort(arr);
        
        // Step 2: Calculate the initial difference
        int diff = arr[1] - arr[0];
        
        // Step 3: Verify the difference for the rest of the array
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }
        
        return true;
    }
}