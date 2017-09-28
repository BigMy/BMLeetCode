import java.util.Arrays;

public class No_42_H_Trapping_Rain_Water {


    public static void main(String args[]) {

        int[] height = new int[] {5,5,4,7,8,2,6,9,4,5};

        System.out.println("input:" + Arrays.toString(height));
        System.out.println("output:" + new No_42_H_Trapping_Rain_Water().trap(height));
    }

    public int trap(int[] height) {

        int containerLeftSidePos = 0;
        int trapResult = 0;
        while (true) {

            if (containerLeftSidePos >= height.length - 2)
                break;

            if (height[containerLeftSidePos] == 0 || height[containerLeftSidePos + 1] >= height[containerLeftSidePos]) {
                containerLeftSidePos++;
                continue;
            }
            int filedWaterMeter = fillWaterLayerByLayer(height, containerLeftSidePos);
            if (filedWaterMeter > 0)
                trapResult += filedWaterMeter;
            else
                containerLeftSidePos ++;
        }

        return trapResult;
    }

    private int fillWaterLayerByLayer(int[] height, int leftPos) {
        int waterMeter = 0;
        int subLeftPos = leftPos;
        int subRightPos = leftPos + 2;
        while (subLeftPos < height.length - 2 && subRightPos < height.length) {
            if (height[subRightPos] > height[subRightPos - 1]) {
                // 填补子容器的水，返回填的容量
                int alignmentHeight = Math.min(height[subLeftPos], height[subRightPos]);
                for (int idx = subLeftPos + 1; idx < subRightPos; idx ++) {
                    waterMeter += alignmentHeight - height[idx];
                    height[idx] = alignmentHeight;
                }
                return waterMeter;
                
            } else if (height[subRightPos] < height[subRightPos - 1]) {
                subLeftPos = subRightPos - 1;
            }
            subRightPos ++;
        }
        return waterMeter;
    }
}
