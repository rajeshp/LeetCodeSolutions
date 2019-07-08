import java.util.Arrays;

/**
 * 189 - Rotate Array
 *
 * Use shifting and modular arithmetic to find the final insert position
 *
 *  i = insert index, n = length of array
 *  result[i] = nums[(n-k-i)%n]
 *
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) return ;

        int[] result = new int[nums.length];
        k = k % nums.length;

        result = Arrays.copyOf(nums, nums.length);

        for(int i=0;i<result.length;i++){
            nums[i] = result[(nums.length-k+i) % nums.length];
            //System.out.print(nums[i] + " ");
        }
    }

    public static void main(String[] args) {
        RotateArray obj = new RotateArray();
        int[] A = new int[] {1,2,3,4,5,6,7};
        obj.rotate(A, 3);
        //print output
        Arrays.stream(A).forEach(x -> System.out.print(x + " "));
    }

}
