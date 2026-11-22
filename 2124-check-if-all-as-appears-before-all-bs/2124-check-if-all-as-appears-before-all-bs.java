class Solution {
    public boolean checkString(String s) {
        boolean ans=true;
        int b=0;
        int c=0;
        int n=s.length();
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='b'){
                b++;
            }
            else if(b>0 && s.charAt(i)=='a'){
                ans=false;
                break;
            }
            System.out.println(b);
        }
        return ans;
    }
}