class Solution {
    public int convertTime(String current, String correct) {
        int currentMinutes =
            Integer.parseInt(current.substring(0, 2)) * 60
            + Integer.parseInt(current.substring(3, 5));

        int correctMinutes =
            Integer.parseInt(correct.substring(0, 2)) * 60
            + Integer.parseInt(correct.substring(3, 5));

        int difference = correctMinutes-currentMinutes;
        int operations =0;
        operations += difference / 60;
difference %= 60;

operations += difference / 15;
difference %= 15;

operations += difference / 5;
difference %= 5;

operations += difference;       
        return operations;
    }
}