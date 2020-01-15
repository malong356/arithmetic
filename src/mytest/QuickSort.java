package mytest;

/**
 *
 * @author malong
 * @since 2020-01-15
 */
public class QuickSort {

    public static void quickSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int temp;
        int k = nums[left];
        int i = left;
        int j = right;
        while (i < j){
            while (nums[j] >= k && i < j){
                j--;
            }
            if(i < j){
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
            while (nums[i] <= k && i < j){
                i++;
            }
            if(i < j){
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
//        nums[left] = nums[i];
//        nums[i] = k;
        quickSort(nums, left , i -1);
        quickSort(nums, i + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = {3,45,78,64,52,11,64,55,99,2,11,18};
        quickSort(nums, 0 , nums.length-1);
        for(int i : nums){
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
