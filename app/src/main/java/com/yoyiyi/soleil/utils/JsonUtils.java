package com.yoyiyi.soleil.utils;

import java.io.InputStream;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/31 11:15
 * 描述:
 */

public class JsonUtils {
    public static String readJson(String jsonFile) {
        InputStream inputStream = FileUtils.openAssetFile(AppUtils.getAppContext(), jsonFile);
        String jsonStr = IOUtils.streamToString(inputStream);
        return jsonStr;
    }
}
