package com.example.latteec.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by Kenvin on 2017/9/27.
 */

public enum  ECIcon  implements Icon {

    icon_check('\ue645'),
    icon_loading('\ue64f');

    private  char character;

    ECIcon(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }
    @Override
    public  char character() {
        return character;
    }
}
