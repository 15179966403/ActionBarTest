package com.hrc.administrator.actionbartest;

import android.content.Intent;
import android.graphics.Point;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button= (Button) findViewById(R.id.btn_child);
        int w=View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        int h=View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        button.measure(w,h);
        int height=button.getMeasuredHeight();
        int width=button.getMeasuredWidth();
        Log.d("sbsbsbsb","Button height:"+height+"  Button width:"+width);
        Display display=getWindowManager().getDefaultDisplay();
        Point size=new Point();
        display.getSize(size);
        Log.d("sbsbsbsb","width:"+size.x+"  height:"+size.y);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ChildActivity.class);
                startActivity(intent);
            }
        });
        Toolbar toolbar= (Toolbar) findViewById(R.id.activity_main_toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("标题");
        toolbar.setSubtitle("副标题");
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        MenuItem searchItem=menu.findItem(R.id.action_first);
        //控件的展开与缩入监听
        MenuItemCompat.OnActionExpandListener listener=new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                Toast.makeText(MainActivity.this, "expand", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                Toast.makeText(MainActivity.this, "collapse", Toast.LENGTH_SHORT).show();
                return true;
            }
        };
        MenuItemCompat.setOnActionExpandListener(searchItem,listener);
        return true;
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_first:
                Toast.makeText(this, "第一个", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_second:
                Toast.makeText(this, "第二个", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_three:
                Toast.makeText(this, "第三个", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
