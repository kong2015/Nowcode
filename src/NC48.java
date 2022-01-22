/**
 * @author dingxudong
 * @create 2021-09-05 23:03
 * @Description
 *   在旋转过的有序数组中寻找目标值
 * [6,8,10,0,2,4],10
 * 2
 */
public class NC48 {
    public int search (int[] nums, int target) {
        // write code here
        return binarySearch(nums, 0, nums.length - 1, target);
    }
    private int binarySearch(int[] nums, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >= nums[left]){//[left,mid]肯定是有序的,接下来让target在区间的三个位置进行判断
                if(target < nums[left]){
                    left = mid + 1;
                }else{
                    if(nums[mid] > target){
                        right = mid - 1;
                    }else{
                        left = mid + 1;
                    }
                }
            }else if(nums[mid] <= nums[right]){//[mid,right]肯定是有序的，接下来让target在区间的三个位置进行判断（但是right右边的位置已经在上面处理了）
                if(nums[mid] > target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
