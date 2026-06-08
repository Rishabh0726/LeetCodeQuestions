class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    private int mergeSort(int[] arr, int low, int high) {
        int cnt=0;
        if (low >= high) 
        return cnt;
        
            int mid = low + (high - low) / 2;

            cnt+=mergeSort(arr, low, mid);
            cnt+=mergeSort(arr, mid + 1, high);

            // important line
            cnt+=cntPairs(arr, low, mid, high);
            merge(arr, low, mid, high);

            return cnt;
    }
    
    private void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) L[i] = arr[low + i];
        for (int j = 0; j < n2; ++j) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = low;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private int cntPairs(int[] arr, int low, int mid, int high){
        int right=mid+1;
        int cnt=0;
        for(int i=low; i<=mid; i++){
            while(right<=high && arr[i]>2L*arr[right]){
                right++;
            }
            cnt+=(right-(mid+1));
        }
        return cnt;
    }
}