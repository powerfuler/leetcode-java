package q011_020.q011_盛最多水的容器.code;

/**
 * 双指针遍历 o(n)
 *
 *算法流程：
 * 设置双指针 i,j 分别位于容器壁两端，根据规则移动指针（后续说明），并且更新面积最大值 res，直到 i == j 时返回 res。
 *
 * 指针移动规则与证明：
 *
 * 每次选定围成水槽两板高度 h[i],h[j] 中的短板，向中间收窄 11 格。
 * 以下证明：
 * 设每一状态下水槽面积为 S(i, j)S(i,j),(0 <= i < j < n)(0<=i<j<n)，由于水槽的实际高度由两板中的短板决定，则可得面积公式 S(i, j) = min(h[i], h[j]) × (j - i)S(i,j)=min(h[i],h[j])×(j−i)。
 * 在每一个状态下，无论长板或短板收窄 11 格，都会导致水槽 底边宽度 -1−1：
 * 若向内移动短板，水槽的短板 min(h[i], h[j])min(h[i],h[j]) 可能变大，因此水槽面积 S(i, j)S(i,j) 可能增大。
 * 若向内移动长板，水槽的短板 min(h[i], h[j])min(h[i],h[j]) 不变或变小，下个水槽的面积一定小于当前水槽面积。
 * 因此，向内收窄短板可以获取面积最大值。换个角度理解：
 * 若不指定移动规则，所有移动出现的 S(i, j) 的状态数为 C(n,2)，即暴力枚举出所有状态。
 * 在状态 S(i, j) 下向内移动短板至 S(i + 1, j)（假设 h[i] < h[j]h[i]<h[j] ），则相当于消去了 {S(i, j - 1), S(i, j - 2), ... , S(i, i + 1)}S(i,j−1),S(i,j−2),...,S(i,i+1) 状态集合。而所有消去状态的面积一定 <= S(i, j)<=S(i,j)：
 * 短板高度：相比 S(i, j) 相同或更短（<= h[i]<=h[i]）；
 * 底边宽度：相比 S(i, j) 更短。
 * 因此所有消去的状态的面积都 < S(i, j)。通俗的讲，我们每次向内移动短板，所有的消去状态都不会导致丢失面积最大值 。
 *
 * 复杂度分析：
 * 时间复杂度 O(N)，双指针遍历一次底边宽度 N 。
 * 空间复杂度 O(1)，指针使用常数额外空间。
 *
 */
public class Solution1 {
    public int maxArea(int[] height) {
        if(height.length < 2) {return 0;}
        int left = 0, right = height.length - 1, result = 0;
        while (left < right) {
            result = height[left] < height[right] ?
                    Math.max(result, (right - left) * height[left++]) :
                    Math.max(result, (right - left) * height[right--]);
        }
        return result;
    }
}
