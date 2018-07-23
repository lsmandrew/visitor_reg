package com.ja.visitor_reg.serve;

import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaRouter;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import com.ja.visitor_reg.ui.second.SecondPresentation;

/**
 * 用于显示副屏的服务
 */
public class SecondService extends Service {


    private static final String TAG = "SecondService";

    private MediaRouter mMediaRouter = null;
    private SecondPresentation mPresentation = null;

    public SecondService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Get the media router service.
        mMediaRouter = (MediaRouter)getSystemService(Context.MEDIA_ROUTER_SERVICE);
        // Listen for changes to media routes.
        mMediaRouter.addCallback(MediaRouter.ROUTE_TYPE_LIVE_VIDEO, mMediaRouterCallback);
        updatePresentation();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresentation != null){
            mPresentation.dismiss();
            mPresentation = null;
        }
    }

    private final MediaRouter.SimpleCallback mMediaRouterCallback = new MediaRouter.SimpleCallback() {
        @Override
        public void onRouteSelected(MediaRouter router, int type, MediaRouter.RouteInfo info) {
            Log.d(TAG, "onRouteSelected: type=" + type + ", info=" + info);
            //updatePresentation();
        }

        @Override
        public void onRouteUnselected(MediaRouter router, int type, MediaRouter.RouteInfo info) {
            Log.d(TAG, "onRouteUnselected: type=" + type + ", info=" + info);
            //updatePresentation();
        }

        @Override
        public void onRoutePresentationDisplayChanged(MediaRouter router, MediaRouter.RouteInfo info) {
            Log.d(TAG, "onRoutePresentationDisplayChanged: info=" + info);
            //updatePresentation();
        }
    };


    private void updatePresentation() {
        // Get the current route and its presentation display.
        MediaRouter.RouteInfo route = mMediaRouter.getSelectedRoute(MediaRouter.ROUTE_TYPE_LIVE_VIDEO);
        Display presentationDisplay = route != null ? route.getPresentationDisplay() : null;

        // Dismiss the current presentation if the display has changed.
        if (mPresentation != null && mPresentation.getDisplay() != presentationDisplay) {
            Log.i(TAG, "Dismissing presentation because the current route no longer "
                    + "has a presentation display.");
            mPresentation.dismiss();
            mPresentation = null;
        }

        // Show a new presentation if needed.
        if (mPresentation == null && presentationDisplay != null) {
            Log.i(TAG, "Showing presentation on display: " + presentationDisplay);
            mPresentation = new SecondPresentation(this, presentationDisplay);
            mPresentation.setOnDismissListener(mOnDismissListener);
            try {
                mPresentation.show();
            } catch (WindowManager.InvalidDisplayException ex) {
                Log.w(TAG, "Couldn't show presentation!  Display was removed in "
                        + "the meantime.", ex);
                mPresentation = null;
            }
        }

        // Update the contents playing in this activity.
        updateContents();
    }

    private final DialogInterface.OnDismissListener mOnDismissListener = new DialogInterface.OnDismissListener() {
        @Override
        public void onDismiss(DialogInterface dialog) {
            if (dialog == mPresentation) {
                Log.i(TAG, "Presentation was dismissed.");
                mPresentation = null;
                updateContents();
            }
        }
    };

    private void updateContents() {
        // Show either the content in the main activity or the content in the presentation
        // along with some descriptive text about what is happening.

    }
}
