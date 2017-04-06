package Algorithm.Leetcode189_RotateArray;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by hasee on 2017/4/5.
 * Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */
public class RotateArray {
    private static int[] a = {1,2,3,4,5,6,7};
    private static int k = 0;

//Sollution 1.
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        if(k>n){
            k = k%n;
        }
        int newArray1 [] = new int[n];
        int newArray2 [] = new int[n];
        System.arraycopy(nums,(n-k),newArray1,0,k);
        System.arraycopy(nums,0,newArray2,k,n-k);
        System.arraycopy(newArray1,0,newArray2,0,k);
        System.arraycopy(newArray2,0,nums,0,n);
    }

//    Sollution 2
    public void rotate2(int [] nums, int k){
        int n = nums.length;
        if(k>n){
            k = k%n;
        }
        for( int i=0;i<k;i++){
            for (int j=n-1;j>0;j--){
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(nums[i]);
        }
    }

//    Time Limit Exceed
    public void rotate3(int [] nums, int k){
        int n = nums.length;
        if(k>n){
            k = k%n;
        }
        reverseArray(nums,0,n-k-1);
        reverseArray(nums,n-k,n-1);
        reverseArray(nums,0,n-1);
        for(int i=0;i<n;i++){
            System.out.println(nums[i]);
        }
    }

    public void reverseArray(int [] a, int startIndex, int endIndex){
        int len = endIndex - startIndex + 1;
        for(int i=0;i<(int)len/2;i++){
            int temp = a[endIndex];
            a[endIndex] = a[startIndex];
            a[startIndex] = temp;
            startIndex ++;
            endIndex--;
        }

    }

    public static void main(String [] args){
        RotateArray ra = new RotateArray();
        int [] Array1 = {1,2,3,4,5,6,7};
        int k = 2;
        ra.rotate3(Array1,k);
    }

}

