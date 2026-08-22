class Solution {
    public boolean checkDivisibility(int n) {
        int m=n;
        int sum=0;
        int p=1;
        while(m>0){
            sum+=m%10;
            p*=m%10;
            m/=10;
        }
        int add=sum+p;
        System.out.print(add);
        if(n%add==0){
            return true;
        }
        return false;

    }
}