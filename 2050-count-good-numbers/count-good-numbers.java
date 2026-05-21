class Solution {
    int mod=1000000007;
    public int countGoodNumbers(long n) {
        long evenCount=(n+1)/2;
        long oddCount=n/2;
        return (int)(power(5, evenCount, mod)*power(4, oddCount, mod)%mod);
    }
    private long power(long base, long exp, long mod){
        if(exp==0)
        return 1;
        if(exp%2==0){
            long half= power(base, exp/2, mod);
            return (half*half)%mod;
        }
        else{
            return (base*power(base, exp-1, mod)%mod);
        }
        
    }
}