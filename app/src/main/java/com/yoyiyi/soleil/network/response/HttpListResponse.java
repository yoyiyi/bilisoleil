package com.yoyiyi.soleil.network.response;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/4/27 14:20
 * 描述:统一处理HttpListResponse
 */

public class HttpListResponse<T> {
    public List<T> data;//数据
    public List<T> result;//数据
    public String message;//信息
    public int code;//服务器状态
}
