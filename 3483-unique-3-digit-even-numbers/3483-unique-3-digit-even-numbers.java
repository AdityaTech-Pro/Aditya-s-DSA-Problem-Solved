class Solution {
    public int totalNumbers(int[] digits) {
        // int n=digits.length;
        // int even=0;
        // for(int i=0; i<n; i++){
        //     if(digits[i]%2==0){
        //         even++;
        //     }
        // }
        // int ans=0
        // if(even>0 && n>=3){
        //     ans=(n*(n-1)*(n-2));
        // }
        // return ans1*even;
        int n=digits.length;
        int[] fre=new int[10];
        int res=0;
        for(int i=0; i<n; i++){
            fre[digits[i]]++;
        }
        for(int i=1; i<=9; i++){
            for(int j=0; j<=9; j++){
                for(int k=0; k<=8; k+=2){
                    fre[i]--;
                    fre[j]--;
                    fre[k]--;
                    if(fre[i] >= 0 && fre[j]>=0 && fre[k]>=0) res++;
                    fre[i]++;
                    fre[j]++;
                    fre[k]++;
                }
            }
        }
        return res;

    }
}