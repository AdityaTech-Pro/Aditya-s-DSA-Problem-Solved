class Solution {
    public int trailingZeroes(int n) {
//count factor of 5 in n! eg : 100! == 100/5 , 20/5, 4/5 == 20, 4, 0 == 24 Trailing Zeroes
        int count=0;
        while(n >= 5){
            n/=5;
            count+=n;
        }
        return count;
    }
}