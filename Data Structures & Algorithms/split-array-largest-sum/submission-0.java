class Solution {
    public int splitArray(int[] nums, int k) {
        int l = nums[0];
        int h = nums[0];

        for(int i = 1; i < nums.length; i++) {
            l = Math.max(l, nums[i]);
            h += nums[i];
        }

        while(l <= h) {
            int mid = l + (h - l) / 2;

            int t = is(nums, mid);

            if(t > k) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return l;
    }

    public static int is(int[] nums, int k) {
        int sum = 0;
        int count = 1;
        for(int num : nums) {
            if(sum + num > k) {
                count++;
                sum = num;
            } else {
                sum += num;
            }
        }

        return count;
    }
}