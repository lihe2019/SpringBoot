import java.util.Arrays;

class Solution88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0){
            return;
        }
        if (m == 0){
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
//            nums1 = Arrays.copyOfRange(nums2,0,n);
            return;
        }

        int[] nums3 = new int[m];
        for (int i = 0; i < m; i++) {
            nums3[i] = nums1[i];
        }

        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < m+n; i++) {
            if (i1 >= m){
                nums1[i] = nums2[i2];
                i2++;
            }else if (i2 >= n){
                nums1[i] = nums3[i1];
                i1++;
            }else if(nums3[i1] < nums2[i2]){
                nums1[i] = nums3[i1];
                i1++;
            }else{
                nums1[i] = nums2[i2];
                i2++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 0};
        int m = 1;
        int[] nums2 = {1};
        int n = 1;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

    }
}