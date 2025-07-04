import java.io.*;
import java.util.*;

public class SlidingWindow {
    public int maxProfit(int[] prices) {
        //https://neetcode.io/problems/buy-and-sell-crypto?list=blind75
        int left = 0;
        int right = 1;
        int max = 0;

        while (right < prices.length) {
            int profit = prices[right] - prices[left];
            max = Math.max(max, profit);

            if (prices[right] < prices[left]) {
                left = right;
            }
            right++;
        }

        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        //https://neetcode.io/problems/longest-substring-without-duplicates?list=blind75
        char[] letters = s.toCharArray();
        int left = 0;
        int longest = 0;
        HashSet<Character> visited = new HashSet<>();

        for (int right = 0; right < letters.length; right++) {
            while (visited.contains(letters[right])) {
                visited.remove(letters[left]);
                left++;
            }
            visited.add(letters[right]);
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }

    public int characterReplacement(String s, int k) {
        //https://neetcode.io/problems/longest-repeating-substring-with-replacement?list=blind75
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;
        int left = 0;
        int maxF = 0;
        char[] letters = s.toCharArray();

        for (int right = 0; right < letters.length; right++) {
            map.put(letters[right], map.getOrDefault(letters[right], 0) + 1);
            maxF = Math.max(maxF, map.get(letters[right]));

            while ((right - left + 1) - maxF > k) {
                map.put(letters[left], map.get(letters[left]) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}