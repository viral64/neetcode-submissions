class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        int l = 0;
        for (int r = 0; r < s2.length(); r++) {
            char ch = s2.charAt(r);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
           
            while ((r - l + 1) > s1.length()) {
                char left = s2.charAt(l);
                map2.put(left, map2.get(left) - 1);

                if (map2.get(left) == 0) {
                    map2.remove(left);
                }
                l++;
            }
             if (r - l + 1 == s1.length()) {
                if (check(map1, map2)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean check(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        if (map1.size() != map2.size()) {
            return false;
        }
        for (char ch : map1.keySet()) {
            if (map2.get(ch) != map1.get(ch)) {
                return false;
            }
        }
        return true;
    }
}
