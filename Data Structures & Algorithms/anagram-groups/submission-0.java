class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
          HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] freq = new int[26];
            // Count characters
            for (char ch : str.toCharArray()) {
                freq[ch - 'a']++;
            }
            // Create unique key
            StringBuilder key = new StringBuilder();
            for (int count : freq) {
                key.append(count).append('#');
            }
            // Add string to its group
            map.computeIfAbsent(key.toString(), k -> new ArrayList<>())
               .add(str);
        }

        return new ArrayList<>(map.values());
    }
}
