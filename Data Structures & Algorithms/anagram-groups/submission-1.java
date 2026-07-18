class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<HashMap<Character, Integer>> list = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (char val : strs[i].toCharArray()) {
                map.put(val, map.getOrDefault(val, 0) + 1);
            }
            list.add(map);
        }
        List<List<String>> ans = new ArrayList<>();
        if (strs.length == 0) {
            return ans;
        }
        boolean visited[]=new boolean[strs.length];
        for (int i = 0; i < list.size(); i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;

            List<String> group = new ArrayList<>();
            group.add(strs[i]);

            for (int j = i + 1; j < list.size(); j++) {
                if (!visited[j] && compareMap(list.get(i), list.get(j))) {
                    visited[j] = true;
                    group.add(strs[j]);
                }
            }

            ans.add(group);
        }

        return ans;
    }
    private boolean compareMap(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        if (map1.size() != map2.size()) {
            return false;
        }

        for (char ch : map1.keySet()) {
            if (!map2.containsKey(ch)) {
                return false;
            }

            if (!map1.get(ch).equals(map2.get(ch))) {
                return false;
            }
        }
        return true;
    }
}
