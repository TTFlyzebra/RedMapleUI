package com.flyzebra.redmapleui.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.flyzebra.redmapleui.R;

import java.util.List;

public class PermissionActivity extends AppCompatActivity {

    //读写权限
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE};
    //请求状态码
    private static int REQUEST_PERMISSION_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);
            }
        }
        finish();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            finish();
        }
    }

    ((RankListActivity)getActivity()).mAppAction.doGoddessRanking(new Subscriber<HttpResult<ListBean<GoddessRank>>>() {

        @Override
        public void onStart() {
            super.onStart();
        }

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(HttpResult<ListBean<GoddessRank>> listBeanHttpResult) {
            if (listBeanHttpResult.errno == 0) {

                List<GoddessRank> list = listBeanHttpResult.data.items;
                List<GoddessRank> headerList = list.subList(0,3) ;
                for(int i = 0 ;i < headerList.size() ;i++){
                    if(i == 0){
                        RoundedImageView iv = (RoundedImageView) mHeaderView.findViewById(R.id.iv_one) ;
                        iv.setOval(true);
                        ImageTools.loadImage(getActivity(),headerList.get(i).getAvatar(),iv);
                    }else if(i == 1){
                        RoundedImageView iv = (RoundedImageView) mHeaderView.findViewById(R.id.iv_two) ;
                        iv.setOval(true);
                        ImageTools.loadImage(getActivity(),headerList.get(i).getAvatar(),iv);
                    }else if(i == 2){
                        RoundedImageView iv = (RoundedImageView) mHeaderView.findViewById(R.id.iv_three) ;
                        iv.setOval(true);
                        ImageTools.loadImage(getActivity(),headerList.get(i).getAvatar(),iv);
                    }
                }
                mGoddnessBankAdapter.notifyGoddessAdapter(list.subList(4,list.size()));

                mRecyclerView.refreshComplete();
            }
        }
    });
}
