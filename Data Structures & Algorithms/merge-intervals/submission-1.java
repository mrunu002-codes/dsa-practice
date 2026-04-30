class Solution {
    public int[][] merge(int[][] intervals) {

        //strivers logic and code from claude
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();

        for (int[] interval : intervals) {
            // no overlap (list empty OR last end < current start) → just add
            if (list.isEmpty() || list.get(list.size() - 1)[1] < interval[0]) {
                list.add(interval);
            }
            // overlap → extend last interval's end
            else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], interval[1]);
            }
        }

        // convert to 2D array
        int[][] ans = new int[list.size()][2];
        for (int j = 0; j < list.size(); j++) {
            ans[j] = list.get(j);
        }
        return ans;
    }
     
    }

