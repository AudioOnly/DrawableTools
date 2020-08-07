package com.yrn.drawableemple.autosize;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yrn.drawableemple.R;
import com.yrn.drawableemple.adapter.CircleOfFriendsMsgAdapter;
import com.yrn.drawableemple.bean.MomentMsgBean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * DrawableEmple
 * <今日头条 屏幕适配方案测试>
 * Created by Xinhoo on 2020/8/7
 * Describe:
 */
public class AutoSizeActivity extends AppCompatActivity {
    private final String TAG = AutoSizeActivity.class.getSimpleName();
    private RecyclerView rv;
    private CircleOfFriendsMsgAdapter adapter;
    private MomentMsgBean msgBean;

    private Gson gson = new GsonBuilder().create();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autosize);
        findViewById(R.id.back_view).setOnClickListener(v -> onBackPressed());
        rv = findViewById(R.id.rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        adapter = new CircleOfFriendsMsgAdapter();
        //设置适配器
        rv.setAdapter(adapter);
        msgBean = gson.fromJson(getJsonStrFromAssets("test.json"), MomentMsgBean.class);
        if (msgBean != null && msgBean.getList() != null) {
            updateRV(msgBean.getList());
        } else {
            Log.e(TAG,"朋友圈全量消息onSuccess--json解析成功：object is null");
        }
    }

    /**
     * 解析 Assets文件
     * @param fileName
     * @return
     */
    private String getJsonStrFromAssets(String fileName) {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();
        AssetManager am = getAssets();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    am.open(fileName)));
            String next = "";
            while (null != (next = br.readLine())) {
                sb.append(next);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            sb.delete(0, sb.length());
        }
        return sb.toString().trim();
    }
    /**
     * 更新RV
     *
     * @param data
     */
    private void updateRV(List<MomentMsgBean.ListBean> data) {
//        runOnUiThread(() -> {
            if (data.size() > 0) {
                Log.e(TAG,"新的消息：" + data.toString());
                if (adapter.getData().size() > 0) {
                    adapter.getData().clear();
                }
                adapter.getData().addAll(data);

                adapter.notifyDataSetChanged();
            } else {
                Log.e(TAG, "数据为空");
            }
//        });

    }
}
