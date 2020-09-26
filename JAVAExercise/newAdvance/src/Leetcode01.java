import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode01 {
    public static void main(String[] args) {
        int[] i = {1,2,3,4};
        System.out.println(Leetcode01.rotate(i));

    }
    public static boolean rotate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;

        for(int i =0 ;i< len ;i++){
            set.add(nums[i]);
        }
        if(set.size() != len){
            return true;
        }
        return false;
        
    }
}
