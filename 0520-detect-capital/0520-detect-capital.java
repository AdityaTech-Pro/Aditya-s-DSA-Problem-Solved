class Solution {
    public boolean detectCapitalUse(String word) {
        int len=word.length();
        int cap=0;
        int smal=0;
        for(int i=0; i<word.length(); i++){
            char c=word.charAt(i);
            if(Character.isLowerCase(c)){
                smal++;
            }
            if(Character.isUpperCase(c)){
                cap++;
            }
            if(len==smal || len==cap){
                return true;
            }
            if(Character.isUpperCase(word.charAt(0)) && smal==len-1){
                return true;
            }

        }
        return false;
    }
}