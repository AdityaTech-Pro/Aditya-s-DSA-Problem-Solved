// class Solution {
//     public long countCommas(long n) {
//         long comma=0;
//         if(n>=1000){
//             for(int i=1000; i<=n; i++){
//                 int count=0;
//                 int num=i;
//                 while(num>0){
//                     count++;
//                     num=num/10;
//                 }
//                 comma+=(count-1)/3;
//             }
//         }
//         return comma;
//     }
// }

// 1,000          → p = 1000
// 1,000,000      → p = 1,000,000
// 1,000,000,000  → p = 1,000,000,000

class Solution {
    public long countCommas(long n) {
        long commas=0;
        for(long i=1000; i<=n; i*=1000){
            commas+= n-i+1;
        }
        return commas;
    }
}