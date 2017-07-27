
package com.yoyiyi.soleil.network.support.cookie.store;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.yoyiyi.soleil.network.support.cookie.SerializableCookie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import okhttp3.Cookie;
import okhttp3.HttpUrl;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/7/12 17:04
 * 描述:sp持久化cookie
 */
public class SPCookieStore implements CookieStore {

    private static final String COOKIE_PREFS = "okhttp_cookie";           //cookie使用prefs保存
    private static final String COOKIE_NAME_PREFIX = "cookie_";         //cookie持久化的统一前缀

    /**
     * 数据结构如下
     * Url.host -> cookieToken1,cookieToken2,cookieToken3
     * cookie_cookieToken1 -> cookie1
     * cookie_cookieToken2 -> cookie2
     * cookie_cookieToken3 -> cookie3
     */
    private final Map<String, ConcurrentHashMap<String, Cookie>> cookies;
    private final SharedPreferences cookiePrefs;

    public SPCookieStore(Context context) {
        cookiePrefs = context.getSharedPreferences(COOKIE_PREFS, Context.MODE_PRIVATE);
        cookies = new HashMap<>();

        //将持久化的cookies缓存到内存中,数据结构为 Map<Url.host, Map<CookieToken, Cookie>>
        Map<String, ?> prefsMap = cookiePrefs.getAll();
        for (Map.Entry<String, ?> entry : prefsMap.entrySet()) {
            if ((entry.getValue()) != null && !entry.getKey().startsWith(COOKIE_NAME_PREFIX)) {
                //获取url对应的所有cookie的key,用","分割
                String[] cookieNames = TextUtils.split((String) entry.getValue(), ",");
                for (String name : cookieNames) {
                    //根据对应cookie的Key,从xml中获取cookie的真实值
                    String encodedCookie = cookiePrefs.getString(COOKIE_NAME_PREFIX + name, null);
                    if (encodedCookie != null) {
                        Cookie decodedCookie = SerializableCookie.decodeCookie(encodedCookie);
                        if (decodedCookie != null) {
                            if (!cookies.containsKey(entry.getKey())) {
                                cookies.put(entry.getKey(), new ConcurrentHashMap<String, Cookie>());
                            }
                            cookies.get(entry.getKey()).put(name, decodedCookie);
                        }
                    }
                }
            }
        }
    }

    private String getCookieToken(Cookie cookie) {
        return cookie.name() + "@" + cookie.domain();
    }

    /** 当前cookie是否过期 */
    private static boolean isCookieExpired(Cookie cookie) {
        return cookie.expiresAt() < System.currentTimeMillis();
    }

    /** 将url的所有Cookie保存在本地 */
    @Override
    public synchronized void saveCookie(HttpUrl url, List<Cookie> urlCookies) {
        for (Cookie cookie : urlCookies) {
            saveCookie(url, cookie);
        }
    }

    @Override
    public synchronized void saveCookie(HttpUrl url, Cookie cookie) {
        if (!cookies.containsKey(url.host())) {
            cookies.put(url.host(), new ConcurrentHashMap<String, Cookie>());
        }
        //当前cookie是否过期
        if (isCookieExpired(cookie)) {
            removeCookie(url, cookie);
        } else {
            saveCookie(url, cookie, getCookieToken(cookie));
        }
    }

    /** 保存cookie，并将cookies持久化到本地 */
    private void saveCookie(HttpUrl url, Cookie cookie, String cookieToken) {
        //内存缓存
        cookies.get(url.host()).put(cookieToken, cookie);
        //文件缓存
        SharedPreferences.Editor prefsWriter = cookiePrefs.edit();
        prefsWriter.putString(url.host(), TextUtils.join(",", cookies.get(url.host()).keySet()));
        prefsWriter.putString(COOKIE_NAME_PREFIX + cookieToken, SerializableCookie.encodeCookie(url.host(), cookie));
        prefsWriter.apply();
    }

    /** 根据当前url获取所有需要的cookie,只返回没有过期的cookie */
    @Override
    public synchronized List<Cookie> loadCookie(HttpUrl url) {
        List<Cookie> ret = new ArrayList<>();
        if (!cookies.containsKey(url.host())) return ret;

        Collection<Cookie> urlCookies = cookies.get(url.host()).values();
        for (Cookie cookie : urlCookies) {
            if (isCookieExpired(cookie)) {
                removeCookie(url, cookie);
            } else {
                ret.add(cookie);
            }
        }
        return ret;
    }

    /** 根据url移除当前的cookie */
    @Override
    public synchronized boolean removeCookie(HttpUrl url, Cookie cookie) {
        if (!cookies.containsKey(url.host())) return false;
        String cookieToken = getCookieToken(cookie);
        if (!cookies.get(url.host()).containsKey(cookieToken)) return false;

        //内存移除
        cookies.get(url.host()).remove(cookieToken);
        //文件移除
        SharedPreferences.Editor prefsWriter = cookiePrefs.edit();
        if (cookiePrefs.contains(COOKIE_NAME_PREFIX + cookieToken)) {
            prefsWriter.remove(COOKIE_NAME_PREFIX + cookieToken);
        }
        prefsWriter.putString(url.host(), TextUtils.join(",", cookies.get(url.host()).keySet()));
        prefsWriter.apply();
        return true;
    }

    @Override
    public synchronized boolean removeCookie(HttpUrl url) {
        if (!cookies.containsKey(url.host())) return false;

        //内存移除
        ConcurrentHashMap<String, Cookie> urlCookie = cookies.remove(url.host());
        //文件移除
        Set<String> cookieTokens = urlCookie.keySet();
        SharedPreferences.Editor prefsWriter = cookiePrefs.edit();
        for (String cookieToken : cookieTokens) {
            if (cookiePrefs.contains(COOKIE_NAME_PREFIX + cookieToken)) {
                prefsWriter.remove(COOKIE_NAME_PREFIX + cookieToken);
            }
        }
        prefsWriter.remove(url.host());
        prefsWriter.apply();

        return true;
    }

    @Override
    public synchronized boolean removeAllCookie() {
        //内存移除
        cookies.clear();
        //文件移除
        SharedPreferences.Editor prefsWriter = cookiePrefs.edit();
        prefsWriter.clear();
        prefsWriter.apply();
        return true;
    }

    /** 获取所有的cookie */
    @Override
    public synchronized List<Cookie> getAllCookie() {
        List<Cookie> ret = new ArrayList<>();
        for (String key : cookies.keySet()) {
            ret.addAll(cookies.get(key).values());
        }
        return ret;
    }

    @Override
    public synchronized List<Cookie> getCookie(HttpUrl url) {
        List<Cookie> ret = new ArrayList<>();
        Map<String, Cookie> mapCookie = cookies.get(url.host());
        if (mapCookie != null) ret.addAll(mapCookie.values());
        return ret;
    }
}
