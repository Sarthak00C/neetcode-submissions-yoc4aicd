class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int l = 0, r = mountainArr.length() - 1;

        while(l < r) {
            int mid = l + (r - l) / 2;

            int val = mountainArr.get(mid);
            int next = mountainArr.get(mid + 1);

            if(val < next) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        int pivot = l;

        int res1 = binarySearch1(target, mountainArr, 0, pivot);
        int res2 = -1;

        if(res1 == -1) {
            res2 = binarySearch2(target, mountainArr, pivot + 1, mountainArr.length() - 1);
        }

        return res1 == -1 ? res2 : res1;
    }

    public static int binarySearch1(int target, MountainArray mountainArr, int l, int h) {
        while(l <= h) {
            int mid = l + (h - l) / 2;
            int val = mountainArr.get(mid);  

            if(val < target) {
                l = mid + 1;
            } else if(val > target) {
                h = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearch2(int target, MountainArray mountainArr, int l, int h) {
        while(l <= h) {
            int mid = l + (h - l) / 2;
            int val = mountainArr.get(mid);   

            if(val > target) {
                l = mid + 1;   
            } else if(val < target) {
                h = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}