package com.guany.myscaffold.test;

/**
 * @Auther: guany
 * @Date: 2023/06/30
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String ans = solution.binarySearch();
    }

    //从有序数组nums中找到target的位置：根据中间位置判断target在前/中/后
    public int binarySearch(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        int middle;
        while (left <= right) {
            middle = left + (left - right) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    // 双重for循环
    // ① i从1往后遍历排序，故i之前是有序的
    // ② j从i-1往前遍历：j在i-1时比i大的就将j后移并继续往前找，遇到不大于i就把i移到空缺处填补并break
    public void insertionSort(int[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            int value = arr[i];
//            for (int j = i - 1; j >= 0; j--) {
//                if (arr[j] > value) {
//                    arr[j + 1] = arr[j];
//                } else {
//                    arr[j + 1] = value;
//                    break;
//                }
//            }
//        }
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            while (arr[j] > value && j >= 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = value;
        }
    }

    //双重for循环
    //i从前往后遍历，记录遍历次数，一次遍历确认一个最大值，当一轮遍历无交换则排序完成
    //j从前往后遍历到已确认的最大值前：两两比较，将较大值后移,有交换需标记
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean hasSwitch = false;
            for (int j = 0; j < arr.length - (i + 1); j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    hasSwitch = true;
                }
            }
            if (!hasSwitch) {
                break;
            }
        }
    }

    //步长每次除2.对子序列实行插入排序(即前方遇见比i大的就后移，没有了就把填空缺)，
    //步长为step的多个子序列的排序：i从步长step开始向后遍历，使得所有子序列将i插入前方有序数组
    public void shellSort(int[] arr) {
        int step = arr.length / 2;
        while (step > 0) {
            for (int i = step; i < arr.length; i++) {
                int preIndex = i - step;
                int temp = arr[i];
                while (preIndex >= 0 && arr[preIndex] > temp) {
                    arr[preIndex + step] = arr[preIndex];
                    preIndex -= step;
                }
                arr[preIndex + step] = temp;
            }
            step /= 2;
        }
    }

    // 若开始值作为基准，从两侧起：左侧找到一个大于它的,右侧找到一个小于它的就交换，全部交换后把基准值替换到中间
    public void quickSort(int[] arr) {
        subSort(arr, 0, arr.length - 1);
    }

    // 递归：将小于基准值即左侧子序列排序，大于基准值的即右侧的子序列排序
    public static void subSort(int[] data, int start, int end) {
        if (start < end) {
            int base = data[start];
            int low = start + 1;
            int high = end;
            while (true) {
                while (low < end && data[low++] <= base) ;
                while (high > start && data[high--] >= base) ;
                if (low < high) {
                    swap(data, low, high);
                } else break;
            }
            swap(data, start, high);
            subSort(data, start, high - 1);
            subSort(data, high + 1, end);
        }
    }

    public static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    //双重for循环
    // j从i+1往后遍历：找到小于i的就和i处交换，一次遍历确认一个最小值
    public void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    swap(arr, i, j);
                }
            }
        }
        //我写的是少一些交换吗
//        for(int i =0;i<arr.length-1;i++){
//            int p = i;
//            for(int j=i+1;j<arr.length;j++){
//                if(arr[j]<arr[p]){
//                    p=j;
//                }
//            }
//            swap(arr,i,p);
//        }
    }

    //大顶堆即每个结点值都大于或等于其左右孩子，所以对堆顶根节点一定是最大值
    //反复：将堆顶元素和最后一个元素交换，并将除末尾的剩余n-1个元素继续构成大顶堆。就能得到一个有序数组
    public void heapSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            buildMaxedHeap(arr, arr.length - 1 - i);
            swap(arr, 0, arr.length - 1 - i);
        }
    }

    //从(n-1)/2处即最后一个子节点的父节点开始向前遍历：和左右孩子比较，若交换了位置，还要检查孩子下方是否还符合大顶堆
    public static void buildMaxedHeap(int[] data, int lastIndex) {
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            int p = i;
            while (p * 2 + 1 <= lastIndex) { //检查当前结点是否有左右孩子，先比左右谁大再交换
                int c = i * 2 + 1;
                if (c < lastIndex && data[c + 1] > data[c]) { //是否有右孩子且更大
                    c++;
                }
                if (data[c] > data[p]) {
                    swap(data, c, p);
                    p = c;
                } else break;
            }
        }
    }

    //拆分成小问题，再合并
    public void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] data, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(data, left, mid);
            sort(data, mid + 1, right);
            merge(data, left, mid, right);
        }
    }

    //看成两个数组，依次两两比较放入新数组，剩下的也放进新数组。因为被拆分到最小，所以两个数组一定是有序的。
    public static void merge(int[] data, int left, int mid, int right) {
        int[] arr = new int[right-left+1];
        int a = left, b = mid + 1;
        int p = 0;
        while (a <= mid && b <= right) {
            if (data[a] <= data[b]) {
                arr[p++] = data[a++];
            } else {
                arr[p++] = data[b++];
            }
        }
        while (a <= mid) {
            arr[p++] = data[a++];
        }
        while (b <= right) {
            arr[p++] = data[b++];
        }
        for(int i =0;i<=arr.length;i++){
            data[i+left] = arr[i];
        }
    }
}
