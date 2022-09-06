//这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr
//[i]。
//
// 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
//
// 注意，不管是什么情况下，你都无法跳到数组之外。
//
//
//
// 示例 1：
//
// 输入：arr = [4,2,3,0,3,1,2], start = 5
//输出：true
//解释：
//到达值为 0 的下标 3 有以下可能方案：
//下标 5 -> 下标 4 -> 下标 1 -> 下标 3
//下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
//
//
// 示例 2：
//
// 输入：arr = [4,2,3,0,3,1,2], start = 0
//输出：true
//解释：
//到达值为 0 的下标 3 有以下可能方案：
//下标 0 -> 下标 4 -> 下标 1 -> 下标 3
//
//
// 示例 3：
//
// 输入：arr = [3,0,2,1,2], start = 2
//输出：false
//解释：无法到达值为 0 的下标 1 处。
//
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 5 * 10^4
// 0 <= arr[i] < arr.length
// 0 <= start < arr.length
//
// Related Topics 深度优先搜索 广度优先搜索 数组
// 👍 127 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //[4,2,3,0,3,1,2], start = 0
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[arr.length];
        queue.offer(start);
        while(!queue.isEmpty()){
            int cur=queue.poll();
            if(visited[cur]){
                continue;
            }
            if(arr[cur]==0){
                return true;
            }
            visited[cur]=true;
            if(cur+arr[cur]>=0 && cur+arr[cur]<arr.length){
                queue.offer(cur+arr[cur]);
            }
            if(cur-arr[cur]>=0 && cur-arr[cur]<arr.length){
                queue.offer(cur-arr[cur]);
            }
        }
        return false;

    }
//    boolean[] visited;
//    public boolean canReach(int[] arr, int start) {
//        int len=arr.length;
//        visited=new boolean[len];
//        return dfs(arr,start);
//    }

//    boolean dfs(int[] arr,int start){
//        if(start>=arr.length || start<0){
//            return false;
//        }
//        if(arr[start]==0){
//            return true;
//        }
//        if(visited[start]){
//            return false;
//        }
//        visited[start]=true;
//        return dfs(arr,start+arr[start]) || dfs(arr,start-arr[start]);
//
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

