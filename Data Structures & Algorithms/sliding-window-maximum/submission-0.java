class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         int n = nums.length;
        if (n == 0) return new int[0];

        Deque<Integer> dq = new ArrayDeque<>(); // stores indices
        int[] result = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i < n; i++) {

            // 1️⃣ Remove indices out of current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // 2️⃣ Maintain decreasing order (remove smaller elements from back)
            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.pollLast();
            }

            // 3️⃣ Add current index
            dq.offerLast(i);

            // 4️⃣ Record result when window size is reached
            if (i >= k - 1) {
                result[idx++] = nums[dq.peekFirst()];
            }
        }

        return result;
        }
    }

