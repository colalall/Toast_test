package com.example.toast_test;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


/**
      * 这个类主要是自定义的气泡通知 Toast
      *  showSuccessToast   成功提示   绿色
     *   showInfoToast      普通提示   蓝色
     *   showErrorToast     错误提示   红色
     *   showWarningToast   警告提示   橙色
     *   调用方法
 *      ToastUtil.showSuccessToast(MainActivity.this,"登录成功！")
 *      或者，都一样
 *      ToastUtil.showSuccessToast(context,"登录成功！")
     * 带有动画效果，从顶部向下滑动显示toast，
    * */


public class ToastUtil {


    private static Queue<Toast> toastQueue = new ConcurrentLinkedQueue<>();


    public static void showSuccessToast(Context context, String message) {
        showToast(context, message, R.layout.toast_success);
    }

    public static void showInfoToast(Context context, String message) {
        showToast(context, message, R.layout.toast_info);
    }

    public static void showErrorToast(Context context, String message) {
        showToast(context, message, R.layout.toast_error);
    }

    public static void showWarningToast(Context context, String message) {
        showToast(context, message, R.layout.toast_warn);
    }

    private static void showToast(final Context context, final String message, final int layoutId) {
        View toastView = LayoutInflater.from(context).inflate(layoutId, null);
        TextView textView = toastView.findViewById(R.id.toast_text);
        textView.setText(message);
        final Toast toast = new Toast(context);
        toast.setView(toastView);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 10);

        animateToast(toastView);

        synchronized (ToastUtil.class) {
            if (toastQueue.isEmpty()) {
                toast.show();
            }
            toastQueue.offer(toast);
        }

        toast.getView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View view) {
                // do nothing
            }

            @Override
            public void onViewDetachedFromWindow(View view) {
                synchronized (ToastUtil.class) {
                    toastQueue.remove(toast);
                    Toast nextToast = toastQueue.peek();
                    if (nextToast != null) {
                        nextToast.show();
                        animateToast(nextToast.getView());
                    }
                }
            }
        });
    }

    private static void animateToast(final View toastView) {
        toastView.post(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator animator = ObjectAnimator.ofFloat(
                        toastView,
                        "translationY",
                        -toastView.getHeight(),
                        0f
                );
                animator.setDuration(300);
                animator.start();
            }
        });
    }
}

