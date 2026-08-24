class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int n=s.length();
        int count=0;
        int ans=0;
        int i=0; 
        int j=0;
        while(i<n){
            char c=s.charAt(i);
            if(set.contains(c)){
                set.remove(s.charAt(j));
                j++;
                count--;
            }else{
                set.add(c);
                count++;
                i++;
            }
            ans=Math.max(ans, count);
        }
        return ans;
    }
}