package com.yohann.traffic107.utils;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;

import com.amap.api.maps.AMap;
import com.amap.api.maps.overlay.DrivingRouteOverlay;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DriveRouteResult;

import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkRouteResult;

import java.util.List;

/**
 * Project  : Traffic-107
 * Author   : 郭朕
 * Date     : 2018/5/11
 */
public class CustomGDRouteResearch implements RouteSearch.OnRouteSearchListener {
    private static final String TAG = "RouteListenerInfo";
    private Context mContext;
    private AMap mAmp;
    private CustomDrivingRouteOverlay mDrivingRouteOverlay;

    public CustomDrivingRouteOverlay getmDrivingRouteOverlay() {
        return mDrivingRouteOverlay;
    }

    public void setmDrivingRouteOverlay(CustomDrivingRouteOverlay mDrivingRouteOverlay) {
        this.mDrivingRouteOverlay = mDrivingRouteOverlay;
    }

//    private DriveRouteResult mDriveRouteResult;
//    private BusRouteResult mBusRouteResult;

    public CustomGDRouteResearch(Context mContext, AMap mAmp) {
        this.mContext = mContext;
        this.mAmp = mAmp;
    }

    public void planPath(LatLonPoint from, LatLonPoint to, List<List<LatLonPoint>> avoid) {
        RouteSearch routeSearch = new RouteSearch(mContext);
        routeSearch.setRouteSearchListener(this);
        RouteSearch.FromAndTo fromAndTo = new RouteSearch.FromAndTo(from, to);
        RouteSearch.DriveRouteQuery query = new RouteSearch.DriveRouteQuery(fromAndTo, RouteSearch.DrivingDefault, null, avoid, "");
        routeSearch.calculateDriveRouteAsyn(query);
    }

    //公交车换乘路径规划结果回调方法
    @Override
    public void onBusRouteSearched(BusRouteResult busRouteResult, int i) {

    }

    //驾车路线规划结果回调方法
    @Override
    public void onDriveRouteSearched(DriveRouteResult driveRouteResult, int i) {
        Log.i(TAG, "onDriveRouteSearched: 触发了路径规划监听器");
        List<DrivePath> paths = driveRouteResult.getPaths();
        DrivePath drivePath = paths.get(0);
        mDrivingRouteOverlay = new CustomDrivingRouteOverlay(mContext, mAmp, drivePath
                , driveRouteResult.getStartPos(), driveRouteResult.getTargetPos());
        mDrivingRouteOverlay.setColorAndWidth(Color.RED, mDrivingRouteOverlay.getRouteWidth());
        mDrivingRouteOverlay.addToMap();
        mDrivingRouteOverlay.setNodeIconVisibility(false);
        mDrivingRouteOverlay.zoomToSpan();
    }

    //步行路线规划结果回调方法
    @Override
    public void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i) {

    }

}
