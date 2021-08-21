package com.example.capstone_design;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public class nonmember_Fragment_Locker extends Fragment {
    Button nomember_Locker_btn;
    private View view;

    public static nonmember_Fragment_Locker newInstance() {
        nonmember_Fragment_Locker nonmember_fragment_locker = new nonmember_Fragment_Locker();
        return nonmember_fragment_locker;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.nonmember_fragment_locker, container, false);

        nomember_Locker_btn = view.findViewById(R.id.nomember_locker_btn);
        nomember_Locker_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "로그인후 이용해주세요.",Toast.LENGTH_SHORT).show();
            }
        });

        MapView mapView =new MapView(getActivity());
        mapView.setDaumMapApiKey("API KEY");
        ViewGroup mapViewContainer = view.findViewById(R.id.nomember_map_view);

        MapPoint mapPoint0 = MapPoint.mapPointWithGeoCoord(37.58774248693334, 127.09810988725502);
        mapView.setMapCenterPoint(mapPoint0, true);

        MapPoint mapPoint1 = MapPoint.mapPointWithGeoCoord(37.587472393937986, 127.09786327536433);
        mapView.setMapCenterPoint(mapPoint1, true);

        MapPoint mapPoint2 = MapPoint.mapPointWithGeoCoord(37.58734832671474, 127.09808106450836);
        mapView.setMapCenterPoint(mapPoint2, true);

        MapPoint mapPoint3 = MapPoint.mapPointWithGeoCoord(37.58698994471383, 127.09836647742945);
        mapView.setMapCenterPoint(mapPoint3, true);

        MapPoint mapPoint4 = MapPoint.mapPointWithGeoCoord(37.586202080323574, 127.09775971440708);
        mapView.setMapCenterPoint(mapPoint4, true);

        MapPoint mapPoint5 = MapPoint.mapPointWithGeoCoord(37.58632410706217, 127.09728434979463);
        mapView.setMapCenterPoint(mapPoint5, true);

        MapPoint mapPoint6 = MapPoint.mapPointWithGeoCoord(37.5863424435297, 127.09689942540258);
        mapView.setMapCenterPoint(mapPoint6, true);

        MapPoint mapPoint7 = MapPoint.mapPointWithGeoCoord(37.58589136001045, 127.09761212284582);
        mapView.setMapCenterPoint(mapPoint7, true);

        MapPoint mapPoint8 = MapPoint.mapPointWithGeoCoord(37.58570707227179, 127.09710805715339);
        mapView.setMapCenterPoint(mapPoint8, true);

        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(37.586695326318875, 127.09781696977936), 0, true);


        //true면 앱 실행 시 애니메이션 효과가 나오고 false면 애니메이션이 나오지않음.
        mapViewContainer.addView(mapView);

        MapPOIItem marker0 = new MapPOIItem();
        marker0.setItemName("서일대학교 호천관");
        marker0.setTag(0);
        marker0.setMapPoint(mapPoint0);
        // 기본으로 제공하는 BluePin 마커 모양.
        marker0.setMarkerType(MapPOIItem.MarkerType.BluePin);
        // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        marker0.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        mapView.addPOIItem(marker0);

        MapPOIItem marker1 = new MapPOIItem();
        marker1.setItemName("서일대학교 초일관");
        marker1.setTag(0);
        marker1.setMapPoint(mapPoint1);
        // 기본으로 제공하는 BluePin 마커 모양.
        marker1.setMarkerType(MapPOIItem.MarkerType.BluePin);
        // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        marker1.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        mapView.addPOIItem(marker1);

        MapPOIItem marker2 = new MapPOIItem();
        marker2.setItemName("서일대학교 흥학관");
        marker2.setTag(0);
        marker2.setMapPoint(mapPoint2);
        // 기본으로 제공하는 BluePin 마커 모양.
        marker2.setMarkerType(MapPOIItem.MarkerType.BluePin);
        // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        marker2.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        mapView.addPOIItem(marker2);

        MapPOIItem marker3 = new MapPOIItem();
        marker3.setItemName("서일대학교 세종관");
        marker3.setTag(0);
        marker3.setMapPoint(mapPoint3);
        // 기본으로 제공하는 BluePin 마커 모양.
        marker3.setMarkerType(MapPOIItem.MarkerType.BluePin);
        // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        marker3.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        mapView.addPOIItem(marker3);

        MapPOIItem marker4 = new MapPOIItem();
        marker4.setItemName("서일대학교 서일관");
        marker4.setTag(0);
        marker4.setMapPoint(mapPoint4);
        // 기본으로 제공하는 BluePin 마커 모양.
        marker4.setMarkerType(MapPOIItem.MarkerType.BluePin);
        // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        marker4.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        mapView.addPOIItem(marker4);

        MapPOIItem marker5 = new MapPOIItem();
        marker5.setItemName("서일대학교 지덕관");
        marker5.setTag(0);
        marker5.setMapPoint(mapPoint5);
        // 기본으로 제공하는 BluePin 마커 모양.
        marker5.setMarkerType(MapPOIItem.MarkerType.BluePin);
        // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        marker5.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        mapView.addPOIItem(marker5);

        MapPOIItem marker6 = new MapPOIItem();
        marker6.setItemName("서일대학교 누리관");
        marker6.setTag(0);
        marker6.setMapPoint(mapPoint6);
        // 기본으로 제공하는 BluePin 마커 모양.
        marker6.setMarkerType(MapPOIItem.MarkerType.BluePin);
        // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        marker6.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        mapView.addPOIItem(marker6);

        MapPOIItem marker7 = new MapPOIItem();
        marker7.setItemName("서일대학교 세방도서관");
        marker7.setTag(0);
        marker7.setMapPoint(mapPoint7);
        // 기본으로 제공하는 BluePin 마커 모양.
        marker7.setMarkerType(MapPOIItem.MarkerType.BluePin);
        // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        marker7.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        mapView.addPOIItem(marker7);

        MapPOIItem marker8 = new MapPOIItem();
        marker8.setItemName("서일대학교 배양관");
        marker8.setTag(0);
        marker8.setMapPoint(mapPoint8);
        // 기본으로 제공하는 BluePin 마커 모양.
        marker8.setMarkerType(MapPOIItem.MarkerType.BluePin);
        // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        marker8.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        mapView.addPOIItem(marker8);

        return  view;
    }
}
