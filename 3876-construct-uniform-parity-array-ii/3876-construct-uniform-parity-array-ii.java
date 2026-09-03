// class Solution {
//     public boolean uniformArray(int[] nums1) {
//         boolean ans=false;
//         int n=nums1.length;
//         int even=0;
//         int odd=0;
//         for(int i=0; i<n; i++){
//             if(nums1[i]%2==0){
//                 even++;
//             }else{
//                 odd++;
//             }
//         }
//         if(even==n || odd==n){
//             return true;
//         }

//         if(even<=odd){
//             int e=even;
//             e=ConvertEven(nums1,e);
//             if(e==0){
//                 ans=true;
//             }
//         }
//         if(ans==false){
//             int o=odd;
//             o=ConvertOdd(nums1, o);
//             if(o==0){
//                 ans=true;
//             }
//         }
//         if(ans==false){
//             int ev=even;
//             ev=ConvertEven(nums1,ev);
//             if(ev==0){
//                 ans=true;
//             }
//         }

//         return ans;
//     }
//     public int ConvertEven(int[] nums1, int e){
//         int n=nums1.length;
//         //int[] nums2=new int[n];

//         for(int i=0; i<n; i++){
//             if(nums1[i]%2==0){
//                 for(int j=0; j<n; j++){
//                     if(nums1[j]<nums1[i] && (nums1[i]-nums1[j]) % 2 == 1){
//                         e--;
//                         break;
//                     }
//                 }
//             }
//         }
//         return e;
//     }
//     public int ConvertOdd(int[] nums1, int o){
//         int n=nums1.length;

//         for(int i=0; i<n; i++){
//             if(nums1[i]%2==1){
//                 for(int j=0; j<n; j++){
//                     if(nums1[j]<nums1[i] && (nums1[i]-nums1[j]) % 2 == 0){
//                         o--;
//                         break;
//                     }
//                 }
//             }
//         }
//         return o;
//     }
// }

class Solution {
    public boolean uniformArray(int[] nums) {

        int minOdd = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num % 2 != 0) {
                minOdd = Math.min(minOdd, num);
            }
        }

        // No odd number
        if (minOdd == Integer.MAX_VALUE) {
            return true;
        }

        for (int num : nums) {
            // An even number smaller than the minimum odd
            // cannot be converted to odd.
            if (num % 2 == 0 && num < minOdd) {
                return false;
            }
        }

        return true;
    }
}