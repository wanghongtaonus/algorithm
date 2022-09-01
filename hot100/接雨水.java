//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 示例 1：
//
//
//
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//
// 示例 2：
//
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
//
//
//
// 提示：
//
//
// n == height.length
// 1 <= n <= 2 * 104
// 0 <= height[i] <= 105
//
// Related Topics 栈 数组 双指针 动态规划 单调栈
// 👍 3754 👎 0


import java.util.ArrayDeque;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        Deque<Integer> stack=new ArrayDeque<>();
        int res=0;
        for(int i=0;i<height.length;i++){
            while(!stack.isEmpty() && height[stack.peek()]<height[i]){
                int h=height[stack.pop()];
                if(stack.isEmpty()){
                    break;
                }
                int distance=i-stack.peek()-1;
                int min=Math.min(height[i],height[stack.peek()]);
                res+=distance*(min-h);
            }
            stack.push(i);
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

