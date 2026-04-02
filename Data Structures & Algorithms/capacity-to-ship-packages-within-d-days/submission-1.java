class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int h = 0;
        int l = 0;

        for(int w : weights) {
            h += w;
            l = Math.max(l, w);
        }

        while(l <= h) {
            int mid = l + (h - l) / 2;

            int requiredDays = is(weights, mid);

            if(requiredDays > days) {
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

        for(int i = 0; i < nums.length; i++) {
            if(sum + nums[i] > k) {
                count++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }

        return count;
    }
}