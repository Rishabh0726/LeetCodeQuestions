class Solution {
    public int uniquePaths(int m, int n) {
        HashMap<String, Integer> hm=new HashMap<>();
        return uniquePathLogic(m,n,hm);
    }
    private int uniquePathLogic(int m, int n, HashMap<String, Integer> hm){
        String key1=m+","+n;
        String key2=n+","+m;

        if(hm.containsKey(key1)){
            return hm.get(key1);
        }
        if(hm.containsKey(key2)){
            return hm.get(key2);
        }
        if (m==0||n==0){
            hm.put(key1,0);
            hm.put(key2,0);
            return 0;
        }
        if(m==1 || n==1){
            hm.put(key1, 1);
            hm.put(key2, 1);
            return 1;
        }
        if(m==1 && n==1){
            hm.put(key1, 0);
            hm.put(key2, 0);
            return 0;
        }
        int result=uniquePathLogic(m, n-1, hm)+uniquePathLogic(m-1, n, hm);
        hm.put(key1, result);
        hm.put(key2, result);
        return result;
    }
}