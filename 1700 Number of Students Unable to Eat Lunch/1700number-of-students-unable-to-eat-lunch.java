public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] counts = new int[2]; // counts[0] for circular, counts[1] for square
        
        // Count student preferences
        for (int student : students) {
            counts[student]++;
        }
        
        // Match with sandwiches in strict order
        for (int sandwich : sandwiches) {
            if (counts[sandwich] > 0) {
                counts[sandwich]--; // A student takes it and leaves
            } else {
                // No remaining student wants this top sandwich
                break; 
            }
        }
        
        // The remaining sandwiches equal the number of hungry students
        return counts[0] + counts[1]; 
    }
}
