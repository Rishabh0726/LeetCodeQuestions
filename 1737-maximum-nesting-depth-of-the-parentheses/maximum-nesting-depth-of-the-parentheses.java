class Solution {
    public int maxDepth(String s) {
        int depth=0;
        int count=0;
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(c=='('){
                count++;
                depth=Math.max(count, depth);
            }
            if(c==')'){
                count--;
            }
        }
        return depth;
    }
}