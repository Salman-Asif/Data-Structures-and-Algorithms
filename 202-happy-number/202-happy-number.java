class Solution {
    
    public int calculateNext(int x) {
        int rem, cur=x, ans=0;
        while(cur!=0) {
            rem = cur%10;
            ans = ans + rem*rem;
            cur = cur/10;
        }
        //System.out.println("ans "+ans);
        return ans;
    }
    
    public boolean isHappy(int n) {
        int a=n,b=n;
        do {
            a = calculateNext(a);
            b = calculateNext(calculateNext(b));
            if(a==1 || b==1)
                return true;
        }while(a!=b);
        return false;
    }
}