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
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length())
                    .append('#')
                    .append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0, n = s.length();
        while (i < n) {
            int j = s.indexOf('#', i);
            int len = Integer.parseInt(s.substring(i, j));
            String str = s.substring(j + 1, j + 1 + len);
            res.add(str);
            i = j + 1 + len;
        }
        return res;
    }
    //}

    public int[] productExceptSelf(int[] nums) {
        //https://neetcode.io/problems/products-of-array-discluding-self?list=blind75
        int n = nums.length;
        int zeroCount = 0;
        long totalProduct = 1L;

        // 1) Count zeros and build product of non-zero values
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                totalProduct *= num;
            }
        }

        int[] result = new int[n];

        // 2) Fill result based on zeroCount
        for (int i = 0; i < n; i++) {
            if (zeroCount > 1) {
                result[i] = 0;
            }
            else if (zeroCount == 1) {
                result[i] = (nums[i] == 0)
                        ? (int) totalProduct
                        : 0;
            }
            else {
                result[i] = (int) (totalProduct / nums[i]);
            }
        }

        return result;
    }

    public int longestConsecutive(int[] nums) {
        //https://neetcode.io/problems/longest-consecutive-sequence?list=blind75
        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);
        int longest = 1;
        int current = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] == nums[i - 1] + 1) {
                current++;
            } else {
                longest = Math.max(longest, current);
                current = 1;
            }
        }
        return Math.max(longest, current);
    }
}
