class Solution {
    public int maxLength(int[] nums) {
        int len=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                len=Math.max(len,check(i,j, nums));
            }
        }
        return len;
    }
    public int check(int start, int end, int[] nums){
        int prod=1;
        for(int i=start; i<=end; i++){
            prod*=nums[i];
        }
        int lcmVal = nums[start];
        int gcdVal = nums[start];
        for(int i=start+1; i<=end; i++){
            lcmVal = lcm(lcmVal, nums[i]);
            gcdVal = gcd(gcdVal, nums[i]);
        }

        if(prod==lcmVal * gcdVal){
            return end-start+1;
        }else{
            return 0;
        }
    }
    public int gcd(int a, int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public int lcm(int a, int b){
        return (a/gcd(a,b)) * b;
    }
}