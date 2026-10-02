class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String>list=new ArrayList<>();
        CreateParentheses(list,"",0,0,n);
        return list;
    }
    void CreateParentheses(ArrayList<String>list, String s, int open, int close, int n){
        if(open==n && close==n){
            list.add(s);
            return;
        }
        
        if(open<n){
            CreateParentheses(list, s+'(', open+1, close, n);
        }
        
        if(open>close){
            CreateParentheses(list, s+')', open, close+1, n);
        }
    }
}