package array;

import java.util.Arrays;

public class RelativeSortArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(relativeSortArray(new int[]{26,21,11,20,50,34,1,18}, new int[]{21,11,26,20})));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int arr[]= new int[1001];
        int j=0;
        for(int i=0;i<arr1.length;i++)
        {
            arr[arr1[i]]++;
        }
        for(int i=0;i<arr2.length;i++)
        {
            while(arr[arr2[i]]-- > 0)
            {
                arr1[j]=arr2[i];
                j++;
            }
        }
        for(int i=0;i<arr.length;i++)
        {
            while(arr[i]-- >0)
            {
                arr1[j]=i;
                j++;
            }
        }
        return arr1;

    }
}
