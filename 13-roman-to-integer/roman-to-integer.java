class Solution {
    public int romanToInt(String s) {

        if (s.isEmpty())
            return 0;

        HashMap<Character, Integer> map=new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum=map.get(s.charAt(s.length()-1));

        for (int i=s.length()-1; i>0; i--){
            int n1=map.get(s.charAt(i));
            int n2=map.get(s.charAt(i-1));
            if (n2<n1)
                sum=sum-n2;
            else {
                sum=sum+n2;
            }
        }
        return sum;
    }
}