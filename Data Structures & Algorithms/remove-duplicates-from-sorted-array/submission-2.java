class Solution {
    public int removeDuplicates(int[] nums) {
       if(nums.length == 0) return 0;
       if(nums.length == 1) return 1;
       int k = 1;
       int[] numsCopy = Arrays.copyOf(nums, nums.length);

       for(int i = 1; i < nums.length; i++) {
        if(nums[i] != nums[i - 1]) k++;
       }
        int i = 0, idx = 0;
        while(idx < nums.length - 1) {
            if(numsCopy[idx] < numsCopy[idx+1]) nums[i++] = numsCopy[idx++];
            else {
                idx++;
            }
        }

        if(numsCopy[nums.length - 1] >= numsCopy[nums.length - 2]) nums[k - 1] = numsCopy[nums.length - 1];

       return k;
    }
}