import java.util.*;

public class Arrays_N_Hashing {
    public boolean hasDuplicate(int[] nums) {
        //https://neetcode.io/problems/duplicate-integer?list=blind75
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean isAnagram(String s, String t) {
        //https://neetcode.io/problems/is-anagram?list=blind75
        char[] s_2 = s.toCharArray();
        char[] t_2 = t.toCharArray();

        Arrays.sort(s_2);
        Arrays.sort(t_2);

        s = Arrays.toString(s_2);
        t = Arrays.toString(t_2);

        return s.equals(t);
    }

    public int[] twoSum(int[] nums, int target) {
        //https://neetcode.io/problems/two-integer-sum?list=blind75
        HashMap<Integer, Integer> map = new HashMap<>(); //value, index
        for (int i = 0; i < nums.length; i++) {
            int new_target = target - nums[i];
            if (map.containsKey(new_target)) {
                return new int[] {map.get(new_target), i};
            }
            else {
                map.put(nums[i], i);
            }
        }
        return new int[] {};
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        //https://neetcode.io/problems/anagram-groups?list=blind75
        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] temp = word.toCharArray();
            Arrays.sort(temp);
            String s_temp = Arrays.toString(temp);

            if (map.containsKey(s_temp)) {
                List<String> a_temp = map.get(s_temp);
                a_temp.add(word);
            }
            else {
                map.put(s_temp, new ArrayList<>(List.of(new String[] {word})));
            }
        }

        return new ArrayList<>(map.values());
    }

    public int[] topKFrequent(int[] nums, int k) {
        //https://neetcode.io/problems/top-k-elements-in-list?list=blind75
        HashMap<Integer, Integer> map = new HashMap<>();

        for (Integer num : nums) {
            if (map.containsKey(num)) {
                int pointer = map.get(num) + 1;
                map.replace(num, pointer);
            }
            else {
                map.put(num, 1);
            }
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort((a, b) -> Integer.compare(map.get(b), map.get(a)));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = keys.get(i);
        }

        return result;
    }

    //{
    //https://neetcode.io/problems/string-encode-and-decode?list=blind75
    public String encode(List<String> strs) {

    }

    public List<String> decode(String str) {

    }
    //}
}



































