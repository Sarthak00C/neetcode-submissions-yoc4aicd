class Solution {
    public boolean search(int[] nums, int target) {
        int peak = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1]) {
                peak = i - 1;
            }
        }

        if(binarySearch(nums, 0, peak, target)) {
            return true;
        } else if(binarySearch(nums, peak + 1, nums.length - 1, target)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean binarySearch(int[] nums, int l, int r, int target) {
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] > target) {
                r = mid - 1;
            } else if(nums[mid] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}