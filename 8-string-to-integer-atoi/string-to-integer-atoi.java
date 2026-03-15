class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        int i=0;
        int sign=1;
        long num=0;
        if (i<s.length() && s.charAt(i)=='+'){
            i++;
        } else if (i<s.length() && s.charAt(i)=='-') {
            i++;
            sign=-1;
        }
        for ( ;i<s.length(); i++){
            char c1=s.charAt(i);
            if (c1>=48 && c1<=57){
                num=(num*10)+(c1-48);

                // clamp(matlab agar num int ki range se bahar ho raha ho to return kar int min/max)
                if (num*sign>Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                if (num*sign<Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            }
            else{
                break;
            }
        }
        return (int)num*sign;
    }
}