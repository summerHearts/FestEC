package com.example.latte.app;

import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.IconFontDescriptor;

import java.util.ArrayList;
import java.util.WeakHashMap;

/**
 * Created by Kenvin on 2017/9/27.
 */

public class Configurator {

    private  static  final WeakHashMap<String,Object> LATTE_CONFIGS = new WeakHashMap<>();

    private  static  final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

    private  Configurator(){

        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),false);
    }

    private  static  class Holder {

        private  static  final  Configurator INSTANCE = new Configurator();
    }

    public  final void configure(){
        initIcons();
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),true);
    }

    final  WeakHashMap<String ,Object> getLatteConfigs(){
        return LATTE_CONFIGS;
    }

    public static Configurator getInstance() {
        return  Holder.INSTANCE;
    }

    public  final  Configurator withApiHost (String  host){
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(),host);
        return this;
    }

    private  void checkConfiguration(){
        final  boolean isReady =  (Boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady){
            throw new RuntimeException("Configuration is not ready ,call configure");
        }
    }

    private void  initIcons (){

        if (ICONS.size()>0){
            final Iconify.IconifyInitializer  initializers = Iconify.with(ICONS.get(0));
            for (int i = 1;i< ICONS.size();i++){
                initializers.with(ICONS.get(i));
            }
        }
    }

    public final  Configurator withIcon(IconFontDescriptor descriptor){
        ICONS.add(descriptor);
        return this;
    }

    @SuppressWarnings("unckecked")
    final  <T> T getConfiguration(Enum<ConfigType> key){
        checkConfiguration();
        return (T)LATTE_CONFIGS.get(key.name());
    }


}
