package com.example.lib.base;


import com.example.lib.R;

/**
 * @author:: wangjianchi
 * @time: 2018/1/23  16:52.
 * @description: activity 配置,简化相同activity 处理
 */

public class BaseActivityOptions {

    /////     标题栏部分
    /**
     * 是否展示通用标题栏
     */
    public boolean enableCommomTitleBar = false;


    public int titleColorId = R.color.white;
    /**
     * 标题名字
     */
    public String titleTextStr = "默认标题";


    /**
     * 标题颜色
     */
    public int titleTextColorId = R.color.black;


    /**
     * 是否展示左侧图片
     */
    public boolean showLeftImage = true;
    /**
     * 是否展示右侧图片(默认不展示)
     */
    public boolean showRightImage = false;

    /**
     * 是否展示右侧图片(默认不展示) 第二张
     */
    public boolean showRightImage02 = false;

    /**
     * 展示右侧文字
     */
    public boolean showRightText = false;

    /**
     * 右侧文字内容
     */
    public String rightTextStr = "";
    /**
     * 右侧文字内容
     */
    public int rightTextColor = R.color.black;

    /**
     * 标题左侧按钮资源ID
     */
//    public int titleLeftId = R.mipmap.ic_back_black;
//    /**
//     * 标题右侧侧按钮资源ID
//     */
//    public int titleRightId = R.mipmap.ic_launcher;
//
//    /**
//     * 标题右侧侧按钮资源ID 第二张
//     */
//    public int titleRightId02 = R.mipmap.ic_launcher;

    /**
     * 标题左侧按钮是否返回 默认返回
     */
    public boolean titleLeftBack = true;


    /**
     * 是否使用通用动画
     */
    public boolean enableAnimation = true;

    /**
     * 进入动画
     */
    public boolean enableEnterAnimation = true;

    /*
    退出动画
     */
    public boolean enableExitAnimation = true;

    /**
     * 状态栏是否变成黑色
     */
    public boolean enableStatusBarLightMode = true;

    /*********************以下配置与滚动渐变效果有关************************/

    /**
     * 是否显示（界面默认隐藏滑动出现的情况）
     */
    public boolean titleVisibility = true;

    /**
     * 是否开启滚动渐变效果
     */
    public boolean scrollEffectEnable = false;
    /**
     * 是否显示滚动效果标题左边按钮（默认开启）
     */
    public boolean showScrollLeft = true;
    /**
     * 是否显示滚动效果标题右侧按钮（默认开启）
     */
    public boolean showScrollRight = false;
    /**
     * 左侧按钮是否是返回
     */
    public boolean scrollLeftCanBack = true;

//    /**
//     * 第二标题栏左侧资源id
//     */
//    public int scrollLeftId = R.mipmap.ic_launcher;
//    /**
//     * 第二标题栏右侧资源id
//     */
//    public int scrollRightId = R.mipmap.ic_launcher;

    /**
     * 右侧标题颜色
     */
    public int titleRightTextColorId = R.color.black;
    /**
     * 展示阴影
     */
    public boolean showElevation = true;

    /**
     * 全屏显示
     */
    public boolean showFullScreen = true;


}
