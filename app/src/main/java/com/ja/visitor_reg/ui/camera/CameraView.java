package com.ja.visitor_reg.ui.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.ja.visitor_reg.common.util.BitmapUtil;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.util.List;

public class CameraView extends SurfaceView {

    private Context mContext;
    private Camera mCamera = null;
    private SurfaceHolder mHolder;
    private Point mPreviewSize; //预览的尺寸
    private Point mPicSize; //图片尺寸
    private boolean mIsPreview = false;
    private int mCameraType = Camera.CameraInfo.CAMERA_FACING_BACK;
    private String mPhotoPath = null;

    public CameraView(Context context) {
        this(context, null);
    }

    public CameraView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;

        mPreviewSize = new Point(640,480);
        mPicSize = new Point(640,480);
        // 获取表面视图的表面持有者
        mHolder = getHolder();
        // 给表面持有者添加表面变更监听器
        mHolder.addCallback(mSurfaceCallback);
        // 去除黑色背景。TRANSLUCENT半透明；TRANSPARENT透明
        mHolder.setFormat(PixelFormat.TRANSPARENT);

    }

    private SurfaceHolder.Callback mSurfaceCallback = new SurfaceHolder.Callback() {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
//            Logger.i("surfaceCreated");
            init_camera();
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
//            Logger.i("SurfaceChangeed");
            try {
                mCamera.stopPreview();
                mCamera.setPreviewDisplay(mHolder);
                mCamera.startPreview();
            } catch (Exception e) {
                Logger.e( "surfaceChanged: " + e.getMessage());
            }
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            Logger.i("surfaceDestroyed");
            // 将预览监听器置空
            mCamera.setPreviewCallback(null);
            // 停止预览画面
            mCamera.stopPreview();
            // 释放相机资源
            mCamera.release();
            mCamera = null;
        }
    };

    private void init_camera() {
        // 打开摄像头
        if (null == mCamera) {
            mCamera = Camera.open(mCameraType);
        }
        if (null != mCamera) {

            try {
                // 获取相机的参数信息
                Camera.Parameters cameraParam = mCamera.getParameters();
                List<Camera.Size> previewSizes = cameraParam.getSupportedPreviewSizes(); // 预览的大小(拍照前看到的图片大小)
                List<Camera.Size> pictureSizes = cameraParam.getSupportedPictureSizes(); // 最终拍摄到的图片的大小(图片的质量)
                for (int i = 0; i < previewSizes.size(); i++) {
                    Camera.Size pSize = previewSizes.get(i);
                    //Logger.i("previewSizes: width = " + pSize.width + " ,height = " + pSize.height);
                }
                for (int i = 0; i < pictureSizes.size(); i++) {
                    Camera.Size pSize = pictureSizes.get(i);
                    //Logger.i("pictureSizes: width = " + pSize.width + " ,height = " + pSize.height);
                }
                // 设置预览界面的尺寸
                cameraParam.setPreviewSize(mPreviewSize.x, mPreviewSize.y);
                // 设置图片的分辨率
                cameraParam.setPictureSize(mPicSize.x, mPicSize.y);
                //设置图片格式
                cameraParam.setPictureFormat(PixelFormat.JPEG);
                //设置jpeg质量
                cameraParam.set("jpeg-quality", 100);
                // 闪光灯模式
                cameraParam.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                //android 2.3.3后不需要添加
                mCamera.setParameters(cameraParam);
                // 设置相机的预览界面
                mCamera.setPreviewDisplay(mHolder);
                //开始预览
                mCamera.startPreview();
                mIsPreview = true;
                //自动对焦
                //mCamera.autoFocus(null);
            } catch (IOException e) {
                e.printStackTrace();
                //关闭摄像头
                if (null != mCamera) {
                    mCamera.release();
                    mCamera = null;
                }
            }
        }

    }


    // 定义一个快门按下的回调监听器。可在此设置类似播放“咔嚓”声之类的操作，默认就是咔嚓。
    private Camera.ShutterCallback mShutterCallback = new Camera.ShutterCallback() {
        public void onShutter() {

        }
    };

    // 下面是单拍的代码
    // 执行拍照动作。外部调用该方法完成拍照
    public void doTakePicture(String picName) {
        mPhotoPath = picName;
        if (mIsPreview && mCamera != null) {
            // 命令相机拍摄一张照片
            mCamera.takePicture(mShutterCallback, null, mPictureCallback);
        }
    }

    //抓拍获取图像
    private Camera.PictureCallback mPictureCallback = new Camera.PictureCallback() {

        @Override
        public void onPictureTaken(byte[] data, Camera camera) {

            Bitmap raw = null;
            //check
            if (null == data) {
                return;
            }
            // 原始图像数据data是字节数组，需要将其解析成位图
            raw = BitmapFactory.decodeByteArray(data, 0, data.length);
            // 停止预览画面
            mCamera.stopPreview();
            mIsPreview = false;
            // 旋转位图
            Bitmap bitmap = BitmapUtil.getRotateBitmap(raw,
                    (mCameraType == Camera.CameraInfo.CAMERA_FACING_BACK) ? 90 : -90);
            // 保存照片文件
            if (null != mPhotoPath) {
                BitmapUtil.saveBitmap(mPhotoPath, bitmap, "jpg", 80);
            }
            Logger.d("bitmap.size=" + (bitmap.getByteCount() / 1024) + "K" + ", path=" + mPhotoPath);
            // 再次进入预览画面
            mCamera.startPreview();
            mIsPreview = true;
        }
    };

}
