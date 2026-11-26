class Solution {
    public boolean canAliceWin(int n) {
        int count=1;
        boolean ans=false;
        if(n<10){
            return false;
        }
        for(int i=10; i>0; i--){
            n=n-i;
            if(n<i-1){
                if(i%2==0){
                    ans=true;
                }
                break;
            }
        }
        return ans;
    }
}