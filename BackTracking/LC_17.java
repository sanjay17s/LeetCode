package BackTracking;

import java.util.*;
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
class LC_17 {
    List<String> list = new ArrayList<>();
    Map<Integer, String> mp;
    int[] arr;

    public LC_17() {
        mp = new HashMap<>();
        mp.put(2, "abc");
        mp.put(3, "def");
        mp.put(4, "ghi");
        mp.put(5, "jkl");
        mp.put(6, "mno");
        mp.put(7, "pqrs");
        mp.put(8, "tuv");
        mp.put(9, "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return list;
        arr = new int[digits.length()];
        for (int i = 0; i < arr.length; i++) arr[i] = Character.getNumericValue(digits.charAt(i));
        bt(0, arr, new StringBuilder());
        return list;
    }

    public void bt(int index, int[] arr, StringBuilder res) {
        if (index == arr.length) {
            list.add(res.toString());
            return;
        } else {
            String s = mp.get(arr[index]);
            for (char ch : s.toCharArray()) {
                res.append(ch);
                bt(index + 1, arr, res);
                res.deleteCharAt(res.length()-1);
            }
        }
    }
}
