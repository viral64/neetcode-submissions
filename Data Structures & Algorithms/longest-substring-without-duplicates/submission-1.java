class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int left = -1;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            if (map.containsKey(current)) {
                left = Math.max(left, map.get(current));
            }

            map.put(current, right);

            ans = Math.max(ans, right - left);
        }

        return ans;
    }
}
