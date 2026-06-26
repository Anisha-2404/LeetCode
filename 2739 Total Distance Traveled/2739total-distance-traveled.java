class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int distance = 0;
        int consumed = 0;

        while (mainTank > 0) {
            mainTank--;
            consumed++;
            distance += 10;

            if (consumed % 5 == 0 && additionalTank > 0) {
                mainTank++;
                additionalTank--;
            }
        }

        return distance;
    }
}