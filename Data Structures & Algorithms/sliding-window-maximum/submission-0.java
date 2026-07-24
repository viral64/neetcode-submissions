class Solution {
    static class Pair {
        int ele;
        int ind;
        public Pair(int ele, int ind) {
            this.ele = ele;
            this.ind = ind;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int ans[] = new int[nums.length - k + 1];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            ans[0] = Math.max(ans[0], nums[i]);
        }
        for (int i = 0; i + k - 1 < nums.length; i++) {
            ans[i] = map.lastKey();

            // remove left
            int getFreq = map.get(nums[i]);
            if (getFreq - 1 == 0) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], getFreq - 1);
            }

            // add right
            if (i + k < nums.length) { // <-- prevent out of bounds
                map.put(nums[i + k], map.getOrDefault(nums[i + k], 0) + 1);
            }
            // map.put(nums[i+k],map.getOrDefault(nums[i+k],0)+1);
        }
        return ans;
    }
}
