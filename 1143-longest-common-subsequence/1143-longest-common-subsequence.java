class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int t1=text1.length();
        int t2=text2.length();

        int[][] ans=new int[t1+1][t2+1];
        for(int i=0; i<=t2; i++){
            ans[0][i]=0;
        }
        for(int i=0; i<=t1; i++){
            ans[i][0]=0;
        }

        for(int i=1; i<=t1; i++){
            for(int j=1; j<=t2; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    ans[i][j]=ans[i-1][j-1] + 1;
                }else{
                    ans[i][j]=Math.max(ans[i-1][j], ans[i][j-1]);
                }
            }
        }
    return ans[t1][t2];
    }
}