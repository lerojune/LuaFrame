package com.app.yunrich.luaframe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.CoerceLuaToJava;

public class MainActivity extends AppCompatActivity {

    TextView title;
    LinearLayout content;

    Lua lua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (TextView) findViewById(R.id.tv_title);
        content = (LinearLayout) findViewById(R.id.content);

        lua = new Lua(this);
        //初始化Lua脚步必须调用call才会执行
        lua.load("demo.lua", CoerceJavaToLua.coerce(this), CoerceJavaToLua.coerce(title));
        //调用函数
        LuaValue button = lua.globals.get("button").call(CoerceJavaToLua.coerce(listener));
        //反向解析
        content.addView((View) CoerceLuaToJava.coerce(button,Button.class));
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            title.setText("this is demo for lua use");
        }
    };
}
