package com.tanke.demo.devise.strategy;

import java.util.Comparator;

/**
 * created by zyj on 2020/5/21
 * 策略模式
 */
public class Sorter<T> {

    public  void bubbleSort(T[] arr, Comparator<T> comparator){
        //一定要记住判断边界条件，很多人不注意这些细节，面试官看到你的代码的时候都懒得往下看，你的代码哪个项目敢往里面加？
        if(arr==null||arr.length<2){
            return;
        }
        for(int i = 0 ;i<arr.length-1;i++){
            //第i趟比较
            for(int j = 0 ;j<arr.length-i-1;j++){
                //开始进行比较，如果arr[j]比arr[j+1]的值大，那就交换位置
                if(comparator.compare(arr[j],arr[j+1])>0){
                    T temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }

        }
//        System.out.println("最终得出的数组为：");
//        for (int k =0 ; k < arr.length;k++){
//            System.out.print(arr[k]+" ");
//        }
    }
}
