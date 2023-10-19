# Android-Toast
- 安卓自定义气泡通知，支持Android13，包含成功提示、普通提示、错误提示、警告提示 颜色为绿色、蓝色、红色、橙色
- 默认是从顶部向下滑出气泡


### 使用指南（此项目免费且开源）
- 图片预览
![image](https://raw.githubusercontent.com/colalall/Toast_test/master/app/src/main/res/drawable/img.png)

[ 点击下载APK文件：Toast 1.0](app/src/main/res/drawable/Toast.apk)

- 1.下载完成以后，将/res/layout目录下的4个布局文件和/res/drawable目录下的5个资源文件复制到您对应的目录中

- app/src/main/res/layout    toast_success.xml/ toast_info.xml / toast_error.xml / toast_warn.xml    

- app/src/main/res/drawable  ic_1.xml/ ic_2.xml/ ic_3.xml/ ic_4.xml/-toast_bg.xml

- 2.将APP/java目录中的的自定义类ToastUtil复制到您的目录中


### 开始使用

- 通过我们的ToastUtil类来调用气泡通知，只需传入一个Context context，加上提示信息即可，如下
- 我们在MainActivity界面中，定义Context mcontext,和String  msg
- 传入mcontext和msg，也可直接传入字符串
- ToastUtil.showSuccessToast(mcontext,"这是一个正确气泡通知");
- ToastUtil.showInfoToast(mcontext,"这是一个普通气泡通知");
- ToastUtil.showErrorToast(mcontext,"这是一个错误气泡通知");
- ToastUtil.showWarningToast(mcontext,"这是一个警告气泡通知");

### 自定义
- 您可以自定义修改资源文件中的图标，大小，颜色，字体，阴影等
- 当然如果你是大佬的话您也可以修改ToastUtil类中的代码，来实现更多的功能



