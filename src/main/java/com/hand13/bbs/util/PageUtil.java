package com.hand13.bbs.util;

/**
 * Created by hd110 on 2017/11/3.
 * edited by hand13
 */
public class PageUtil {
    public static int pages(int size,int pageSize) {
        int a = size/pageSize;
        int b = size%pageSize;
        if(b != 0)
            a += 1;
        return a;
    }
}
