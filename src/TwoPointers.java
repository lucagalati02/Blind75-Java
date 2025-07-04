import java.io.*;
import java.util.*;

public class TwoPointers {
    public boolean isPalindrome(String s) {
        //https://neetcode.io/problems/is-palindrome?list=blind75
        int left = 0;
        int right = s.length() - 1;
        char[] pal = s.strip().toCharArray();

        while (left < right) {
            while (!Character.isLetterOrDigit(pal[left]) && left < right) {
                left++;
            }
            while (!Character.isLetterOrDigit(pal[right]) && left < right) {
                right--;
            }
            if (Character.toLowerCase(pal[left]) != Character.toLowerCase(pal[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        //https://neetcode.io/problems/three-integer-sum?list=blind75
        if (nums == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int left = 0;
        int right = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int desire = nums[i];
            if (desire > 0) break;
            left = i + 1;
            right = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            while (left < right) {
                if (nums[left] + nums[right] == -desire) {
                    result.add(new ArrayList<>(List.of(desire, nums[left], nums[right])));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
                else if (nums[left] + nums[right] > -desire) {
                    right--;
                }
                else if (nums[left] + nums[right] < -desire) {
                    left++;
                }
            }
        }
        return result;
    }

    public int maxArea(int[] heights) {
        //https://neetcode.io/problems/max-water-container?list=blind75
        int left = 0;
        int right = heights.length - 1;
        int max = 0;

        while (left < right) {
            int volume = (right - left) * Math.min(heights[left], heights[right]);
            max = Math.max(max, volume);

            if (heights[left] < heights[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return max;
    }
}











































