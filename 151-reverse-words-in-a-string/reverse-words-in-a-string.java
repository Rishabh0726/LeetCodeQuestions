class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        s=s.trim();
        int i=s.length()-1;
        while(i>=0){
            int j=i;
            while(i>=0 && s.charAt(i)!=' '){
                i--;
            }
            sb.append(s.substring(i+1, j+1)).append(" ");
            while(i>=0 && s.charAt(i)==' '){
                i--;
            }
        }
        return sb.toString().trim();
    }
}