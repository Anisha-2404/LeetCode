class Solution {
public:
    double angleClock(int hour, int minutes) {
        double a = 5.5 * minutes;   // 11.0/2 instead of 11/2
        double b = 30 * hour;

        double angle;
        if (a > b) {
            angle = a - b;
        } else {
            angle = b - a;
        }

        return min(angle, 360 - angle);
    }
};