package com.yohann.traffic107.utils;

import android.content.Context;
import android.view.View;

import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.overlay.DrivingRouteOverlay;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.DrivePath;
import com.yohann.traffic107.R;

import java.util.List;

/**
 * Project  : Traffic-107
 * Author   : 郭朕
 * Date     : 2018/5/11
 */
public class CustomDrivingRouteOverlay extends DrivingRouteOverlay {
    public int routeColor;
    public float widthOfRoute;
    public Context context;

    public CustomDrivingRouteOverlay(Context context, AMap aMap, DrivePath drivePath, LatLonPoint latLonPoint, LatLonPoint latLonPoint1) {
        super(context, aMap, drivePath, latLonPoint, latLonPoint1);
    }

    public CustomDrivingRouteOverlay(Context context, AMap aMap, DrivePath drivePath, LatLonPoint latLonPoint, LatLonPoint latLonPoint1, List<LatLonPoint> list) {
        super(context, aMap, drivePath, latLonPoint, latLonPoint1, list);
    }

    //修改路线的颜色和宽度的工具方法
    public void setColorAndWidth(int routeColor, float widthOfRoute) {
        this.routeColor = routeColor;
        this.widthOfRoute = widthOfRoute;
    }
//
//    @Override
//    protected void addStartAndEndMarker() {
//        super.addStartAndEndMarker();
//        BitmapDescriptorFactory bdf = new BitmapDescriptorFactory();
//
//        //自定义设置起止点的标记,记得改了...
//        BitmapDescriptor startbd = bdf.fromView(View.inflate(context, R.layout.marker_start_layout, null));
//        BitmapDescriptor endbd = bdf.fromView(View.inflate(context, R.layout.marker_end_layout, null));
//
//        startMarker = mAMap.addMarker((new MarkerOptions()).position(startPoint).icon(startbd));
//        endMarker = mAMap.addMarker((new MarkerOptions()).position(endPoint).icon(endbd));
//    }
//
//
//    //根据图片资源自定义修改旗子的样式
//    public void setMarkerIcon(int startMarkerIconResourceId, int endMarkerIconResourceId) {
//        Marker startmarker = this.startMarker;
//        startmarker.setIcon(BitmapDescriptorFactory.fromResource(startMarkerIconResourceId));
//        Marker endmarker = this.endMarker;
//        endmarker.setIcon(BitmapDescriptorFactory.fromResource(endMarkerIconResourceId));
//    }
//
//    @Override
    protected float getRouteWidth() {
//        super.getRouteWidth();
        return widthOfRoute;
    }

    @Override
    protected int getDriveColor() {
//        super.getDriveColor();
        return routeColor;
    }
}
