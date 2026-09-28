class Solution {
    public int maxDepth(String s) {
        int count=0;
        int n=s.length();
        int ans=0;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='('){
                count++;
            }
            else if(s.charAt(i)==')'){
                count--;
            }
            ans=Math.max(ans, count);
        }
        return ans;
    }
}