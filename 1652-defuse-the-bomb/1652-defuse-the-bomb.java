class Solution {

    public int[] decrypt(int[] code, int k) {

        int n = code.length;

        int[] arr = new int[n];

        if(k == 0){
            return arr;
        }

        // Duplicate array
        int[] nums = new int[n + n];

        for(int i = 0; i < n; i++){
            nums[i] = code[i];
        }

        int idx = 0;

        for(int i = n; i < n + n; i++){
            nums[i] = code[idx++];
        }

        for(int i = 0; i < n; i++){
            arr[i] = cal(i, k, nums, n);
        }

        return arr;
    }

    public int cal(int i, int k, int[] nums, int n){

        int val = 0;

        if(k > 0){

            // Next k elements
            for(int j = i + 1; j <= i + k; j++){
                val += nums[j];
            }

        } else {

            // Previous |k| elements
            for(int j = n + i + k; j < n + i; j++){
                val += nums[j];
            }
        }

        return val;
    }
}