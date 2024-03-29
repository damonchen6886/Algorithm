package SlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class SlidingWindowMax239 {
    //思想： 双边队列：
    //  头部      -> 尾部
    //  [x, x, x, x, x]   offerFirst =  add 左边    offerLast = add右边
    // 保持队列的头部永远是最大值 因为加的时候只加尾部 但是尾部又在每次添加比较的时候更新  这样队列是一个递增双边队列
    // 1. 比较要加的元素的index 和队列里的第一个的index 如果越界
    // 2. 吧头部index所对应的元素删掉
    // 3. 比较尾部和当前值得大小 如果尾部比当前值小 删掉 直到队列尾部比当前值大  这样的目的是保持队列是一个递减队列 左边永远最大
    // 4. 给队列的尾部加当前index
    // 5. 检查是否需要给结果集赋值
    //                               max         dq(index)  [first.....last]
    //[1]  3  -1 -3  5  3  6  7       /             [0]
    //[1  3]  -1 -3  5  3  6  7       /             [] -> [1]
    //[1  3  -1] -3  5  3  6  7       3             [1,2]
    // 1 [3  -1  -3] 5  3  6  7       3             [1,2,3]
    // 1  3 [-1  -3  5] 3  6  7       5             [1,2,3] -> [2,3] -> [2] ->[] -> [4]
    // 1  3  -1 [-3  5  3] 6  7       5             [4,5]
    // 1  3  -1  -3 [5  3  6] 7       6             [4,5] -> [4]  -> [] -> [6]
    // 1  3  -1  -3  5 [3  6  7]      7             [6] -> [] -> [7]
//    time : O(n)
//    space : O(k);
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];

        int left =0;
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        Deque<Integer> dq = new ArrayDeque<>();
        for(int right =0; right<nums.length;right++){
            if(dq.size() > 0 && dq.peekFirst() <= right-k){
                dq.pollFirst();
            }
            while(dq.size() > 0 && nums[dq.peekLast()] < nums[right]){
                dq.pollLast();
            }
            dq.offerLast(right);
            if(right >= k-1){
                result[right-k+1] = nums[dq.peekFirst()];
            }
        }
        return result;

    }

//    PQ version: nlog(k)
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->{
            return Integer.compare(nums[b], nums[a]);
        });
        for(int i = 0; i < k - 1; i++) pq.offer(i);
        for(int i = k - 1; i < nums.length; i++){
            pq.offer(i);
            while(pq.size() > 0 && pq.peek() < i - k + 1) pq.poll();
            int index = pq.peek();
            ans[i - k + 1] = nums[index];
        }
        return ans;
    }




}
