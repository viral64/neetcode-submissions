class Solution {
    public String minWindow(String s, String t) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map1.put(t.charAt(i), map1.getOrDefault(t.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        int l = 0;
        int ans = Integer.MAX_VALUE;
        for (int r = 0; r < s.length(); r++) {
            map2.put(s.charAt(r), map2.getOrDefault(s.charAt(r), 0) + 1);
            while (l <= r && check(map1, map2)) {
                 ans = Math.min(ans, r - l + 1);
                int getFreq = map2.get(s.charAt(l));
                if (getFreq - 1 == 0) {
                    map2.remove(s.charAt(l));
                } else {
                    map2.put(s.charAt(l), getFreq - 1);
                }

               
                l++;
            }
        }
        l = 0;
        int ind1 = -1;
        int ind2 = -1;
        int flag = 0;
        map2.clear();
        for (int r = 0; r < s.length(); r++) {
            map2.put(s.charAt(r), map2.getOrDefault(s.charAt(r), 0) + 1);
            while (l <= r && check(map1, map2)) {
                 if (ans == r - l + 1) {
                    ind1 = l;
                    ind2 = r;
                    flag = 1;
                }
                int getFreq = map2.get(s.charAt(l));
                map2.put(s.charAt(l), getFreq - 1);
               
                l++;
            }
            if (flag == 1) {
                break;
            }
        }
        if (ind1 == -1) {
            return "";
        }
        for (int i = ind1; i <= ind2; i++) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
    private boolean check(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        int count = 0;
        for (char ch : map1.keySet()) {
            if (map2.containsKey(ch) && map2.get(ch) >= map1.get(ch)) {
                count++;
            }
        }
        return count == map1.size();
    }
}
