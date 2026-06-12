class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        String str = sb.toString();
        String rev = sb.reverse().toString();
        return str.equals(rev);
    }
}