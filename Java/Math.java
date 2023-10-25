public class Math {
    public static long binpow(long a, long b){
        if(b==0) return 1;
        long ans = binpow(a, b/2);
        if(b%2==0) return ans * ans;
        else return ans * ans * a;
    }
    

}
