//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 子数组 是数组中的一个连续部分。
//
//
//
// 示例 1：
//
//
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//
//
// 示例 2：
//
//
//输入：nums = [1]
//输出：1
//
//
// 示例 3：
//
//
//输入：nums = [5,4,-1,7,8]
//输出：23
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
//
//
//
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
// Related Topics 数组 分治 动态规划
// 👍 5265 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        //输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
        //输出：6
        //动态规划 无后效性
//        int res=Integer.MIN_VALUE;
//        int[] dp=new int[nums.length];
//        for(int i=0;i<nums.length;i++){
//            if(i==0){
//                dp[i]=nums[i];
//            }
//            else{
//                dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
//            }
//            res=Math.max(res,dp[i]);
//        }
//        return res;
        //分治法
        int len=nums.length;
        if(len==0){
            return 0;
        }
        return maxSubArray(nums,0,len-1);
    }

    public int maxCrossArray(int[] nums,int left,int mid,int right){
        int sum=0;
        int leftSum=Integer.MIN_VALUE;
        for(int i=mid;i>=left;i--){
            sum+=nums[i];
            leftSum=Math.max(sum,leftSum);
        }
        sum=0;
        int rightSum=Integer.MIN_VALUE;
        for(int i=mid+1;i<=right;i++){
            sum+=nums[i];
            rightSum=Math.max(sum,rightSum);
        }
        return leftSum+rightSum;
    }

    public int maxSubArray(int[] nums,int left,int right){
        if(left==right){
            return nums[left];
        }
        int mid=left+(right-left)/2;
        return Max(maxSubArray(nums,left,mid),maxSubArray(nums,mid+1,right),maxCrossArray(nums,left,mid,right));
    }

    public int Max(int a,int b,int c){
        return Math.max(Math.max(a,b),c);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
