package com.tanke.demo.devise.strategy;

import java.util.Comparator;

/**
 * created by zyj on 2020/5/22
 */
public class CatWeightComparator implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.weight>o2.weight)return 1;
        else if (o1.weight<o2.weight) return -1;
        else return 0;
    }
}
