class Solution {
    public int reverseDegree(String s) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int n=s.length();
        for(int i=0; i<n; i++){
            int val='z' - s.charAt(i) + 1;
            map.put(i+1, map.getOrDefault(i+1, 0)+val);
        }
        int sum=0;
        for(int key : map.keySet()){
            sum+=key*map.get(key);
        }
        return sum;
    }
}