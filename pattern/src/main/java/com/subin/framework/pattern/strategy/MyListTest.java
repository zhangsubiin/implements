package com.subin.framework.pattern.strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author: subiin
 * @date: 2018/2/4 下午3:14
 * @description:
 */
public class MyListTest {

    public static void main(String[] args) {

//        new MyList().sort(new NumberComparator());

        //策略模式
        List<Long> numbers = new ArrayList<>();

        numbers.sort(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return 0;
            }
        });
    }
}
