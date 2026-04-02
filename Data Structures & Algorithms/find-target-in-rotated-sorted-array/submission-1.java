class Solution {
    public int search(int[] nums, int target) {
        int max = nums[0];
        int peak = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] >= max) {
                peak = i;
                max = nums[i];
            }
        }

        int ans1 = binarySearch(nums, 0, peak, target);
        int ans2 = binarySearch(nums, peak + 1, nums.length - 1, target);

        return ans1 == -1 ? ans2 : ans1;

    }

    public static int binarySearch(int[] nums, int l, int r, int target) {
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] > target) {
                r = mid - 1;
            } else if(nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
