package com.yohann.traffic107.utils;

import android.content.Context;

import cn.bmob.v3.Bmob;

/**
 * Created by Yohann on 2016/8/26.
 */
public class BmobUtils {
    public static void init(Context context) {
        Bmob.initialize(context, "3faacf82c27b45b17f6fd36db5ad7f07");
    }
}
