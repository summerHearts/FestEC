package com.example.latte.app;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by Kenvin on 2017/9/27.
 */


//final 限制为终类，不能被继承和修改
public final class Latte {

    public  static  Configurator init(Context context){
        getConfigurations().put(ConfigKeys.APPLICATION_CONTEXT,context.getApplicationContext());
        return  Configurator.getInstance();
    }


    private  static HashMap<Object,Object> getConfigurations(){
        return  Configurator.getInstance().getLatteConfigs();
    }
}
