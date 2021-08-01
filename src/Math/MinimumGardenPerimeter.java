package Math;

public class MinimumGardenPerimeter {
    // leetcode 1954
    //In a garden represented as an infinite 2D grid, there is an apple tree planted at every integer coordinate.
    // The apple tree planted at an integer coordinate (i, j) has |i| + |j| apples growing on it.
    //
    //You will buy an axis-aligned square plot of land that is centered at (0, 0).
    //
    //Given an integer neededApples, return the minimum perimeter of a plot
    // such that at least neededApples apples are inside or on the perimeter of that plot.

    //Input: neededApples = 1
    //Output: 8
    //Explanation: A square plot of side length 1 does not contain any apples.
    //However, a square plot of side length 2 has 12 apples inside (as depicted in the image above).
    //The perimeter is 2 * 4 = 8.

    //Input: neededApples = 13
    //Output: 16

    //Input: neededApples = 1000000000
    //Output: 5040

    // 思路 计算每个象限有多少个点 然后用等差数列公式得到所有点sum(x,y) 之和
    // 公式： (0,0） -> (i,i) 展开 sum（x,y）等于 从0到 2*i+1 这么多项
    // 优化： 二分
    // 难点： 找到公式
    public long minimumPerimeter(long neededApples) {
        long sum =0;
        long index= 0;
        while(sum < neededApples){
            index++;
            sum = index * (index+1)*(2*index+1)*2;
            // (2*index+1)*2 -> (2*index+1)/2 *4个象限
            // 或者写成sum += 4*index*2+ 4*index+ 8*((index+1)+(2*index-1))*(index-1)/2;
            //((index+1)+(2*index-1))*(index-1)/2 首项尾项项数和

        }
        return (index)*8; // 8个到xy轴的边
    }

}
