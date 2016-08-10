package com.app.yunrich.luaframe;

import android.content.Context;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.ResourceFinder;
import org.luaj.vm2.lib.jse.JsePlatform;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/8/10.
 */
public class Lua implements ResourceFinder{

    Context context;
    public Globals globals;


    public Lua(Context context){
        this.context = context;
        globals = JsePlatform.standardGlobals();
        globals.finder = this;
    }

    public void load(String file){
         globals.loadfile(file).call();
    }
    public void load(String file, LuaValue arg1){
         globals.loadfile(file).call(arg1);
    }
    public void load(String file, LuaValue arg1, LuaValue arg2){
         globals.loadfile(file).call(arg1,arg2);
    }



    @Override
    public InputStream findResource(String s) {
        try {
            return context.getAssets().open(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
