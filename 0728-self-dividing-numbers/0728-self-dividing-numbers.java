import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        
        // Loop through each number in the inclusive range
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) {
                result.add(i);
            }
        }
        
        return result;
    }
    
    // Helper method to check if a number is self-dividing
    private boolean isSelfDividing(int num) {
        int temp = num;
        
        while (temp > 0) {
            int digit = temp % 10; // Extract the last digit
            
            // Fail if digit is 0 or if the original number is not divisible by it
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            
            temp /= 10; // Remove the last digit
        }
        
        return true;
    }
}
