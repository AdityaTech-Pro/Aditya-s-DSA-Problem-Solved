class Solution {
    public int longestValidParentheses(String s) {
        int o=0;
        int c=0;
        int ans=0;

        int n=s.length();
        for(int i=0; i<n; i++){
            char ch=s.charAt(i);
            if(ch=='('){
                o++;
            }else{
                c++;
            }

            if(o==c){
                ans=Math.max(ans,2*c);
            }
            if(c>o){
                o=0;
                c=0;
            }
        }
        o=0;
        c=0;
        for(int i=n-1; i>=0; i--){
            char ch=s.charAt(i);
            if(ch=='('){
                o++;
            }else{
                c++;
            }

            if(o==c){
                ans=Math.max(ans,2*o);
            }
            if(c<o){
                o=0;
                c=0;
            }
        }

        return ans;
    }
}