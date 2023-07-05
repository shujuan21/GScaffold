package com.guany.myscaffold.test;

/**
 * @Auther: guany
 * @Date: 2023/07/05
 */
public class Dictation {

    public static void main(String[] args) {
        Dictation dictation = new Dictation();
    }

    /**
     * ①用时12min正确
     * <p>
     * 提示:二分查找到元素位
     */
    public int binarySearch(int[] arr, int target) {
        return -1;
    }

    /**
     * ①用时13min更优化
     */
    public void insertionSort(int[] arr) {

    }

    /**
     * ①10min粗心
     */
    public void bubbleSort(int[] arr) {
    }

    /**
     * ①18min粗心错误
     */
    public void shellSort(int[] arr) {
    }

    /**
     * ①用时10min错误
     */
    public void quickSort(int[] arr) {
    }

    /**
     * ①10min不确定正确否
     */
    public void selectSort(int[] arr) {
    }

    /**
     * ①23min错误
     */
    public void heapSort(int[] arr) {
    }

    /**
     *①20min基本正确
     */
    public void mergeSort(int[] arr) {}


    public static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }


}
