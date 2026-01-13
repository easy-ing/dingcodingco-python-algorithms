import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (int num : numbers) {
            Map<Integer, Integer> next = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                int sum = entry.getKey();
                int cnt = entry.getValue();

                next.put(sum + num, next.getOrDefault(sum + num, 0) + cnt);
                next.put(sum - num, next.getOrDefault(sum - num, 0) + cnt);
            }
            dp = next;
        }

        return dp.getOrDefault(target, 0);
    }
}