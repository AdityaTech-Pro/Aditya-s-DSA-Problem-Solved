class Solution {
    public int countCommas(int n) {
        int comma=0;
        
        if(check(n)>3){
            System.out.print(check(n));
            for(int i=1000; i<=n; i++){
                comma+=(check(i)-1)/3;                     
            }
        }
        return comma;
    }
    public int check(int n){
        int count=0;
        while(n>0){
            //n%10;
            n=n/10;
            count++;
        }
        return count;
    }
}