class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        int b =s.length();
        int a = s.lastIndexOf(" ");
        
        return b-a-1;
    }
}