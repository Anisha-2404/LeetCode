class Solution {
    public boolean validDigit(int n, int x) {
        String s = String.valueOf(n);
        char d = (char)(x + '0');
        if(s.charAt(0)==d)
        {
            return false;
        }
        int a = s.length();
        for(int i=0;i<a;i++)
        {
            if(s.charAt(i)==d)
            {
                return true;
            }
        }        
        return false;
    }
}