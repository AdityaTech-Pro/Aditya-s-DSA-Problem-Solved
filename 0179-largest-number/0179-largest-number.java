class Solution {
    public String largestNumber(int[] nums) {
        int n=nums.length;
        String[] s=new String[n];

        // Convert to strings once.
        for(int i=0; i<n; i++){
            s[i]=String.valueOf(nums[i]);
        }
        // Core comparator:
        // a comes before b if (a+b) is lexicographically larger than (b+a).
        Arrays.sort(s, (a,b) -> (b+a).compareTo(a+b));
        //Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // All-zero case.
        if(s[0].equals("0")) return "0";

        StringBuilder  sb=new StringBuilder();
        for(String part : s){
            sb.append(part);
        }
        return sb.toString();
    }
}