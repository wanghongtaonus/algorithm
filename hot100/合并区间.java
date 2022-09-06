//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
//
//
//
// 示例 1：
//
//
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2：
//
//
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
//
//
// 提示：
//
//
// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104
//
// Related Topics 数组 排序
// 👍 1627 👎 0


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public class newComparator implements Comparator<int[]>{
        public int compare(int[] a,int[] b){
            return a[0]-b[0];
        }
    }
    //[1,4]  [4,5]
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new newComparator());
        List<int[]> res=new ArrayList<int[]>();
        for(int i=0;i< intervals.length;i++){
            int[] temp=new int[2];
            temp[0]=intervals[i][0];
            int max=intervals[i][1];
            while(i+1< intervals.length && intervals[i+1][0]<=max){
                i++;
                max=Math.max(max,intervals[i][1]);
            }
            temp[1]=max;
            res.add(temp);
        }
        int[][] ans=new int[res.size()][2];
        for(int i=0;i<res.size();i++){
            ans[i][0]=res.get(i)[0];
            ans[i][1]=res.get(i)[1];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
