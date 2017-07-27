
package com.yoyiyi.soleil.network.support.cookie.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.Cookie;
import okhttp3.HttpUrl;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/7/12 17:04
 * 描述:cookie内存管理
 */

public class MemoryCookieStore implements CookieStore {

    private final Map<String, List<Cookie>> memoryCookies = new HashMap<>();

    /**
     * 保存cookie
     *
     * @param url url
     * @param cookies cookie
     */
    @Override
    public synchronized void saveCookie(HttpUrl url, List<Cookie> cookies) {
        List<Cookie> oldCookies = memoryCookies.get(url.host());
        List<Cookie> needRemove = new ArrayList<>();
        for (Cookie newCookie : cookies) {
            for (Cookie oldCookie : oldCookies) {
                if (newCookie.name().equals(oldCookie.name())) {
                    needRemove.add(oldCookie);
                }
            }
        }
        oldCookies.removeAll(needRemove);
        oldCookies.addAll(cookies);
    }

    /**
     * 保存cookie
     *
     * @param url url
     * @param cookie cookie
     */
    @Override
    public synchronized void saveCookie(HttpUrl url, Cookie cookie) {
        List<Cookie> cookies = memoryCookies.get(url.host());
        List<Cookie> needRemove = new ArrayList<>();
        for (Cookie item : cookies) {
            if (cookie.name().equals(item.name())) {
                needRemove.add(item);
            }
        }
        cookies.removeAll(needRemove);
        cookies.add(cookie);
    }

    /**
     * 获取所有cookie
     *
     * @param url
     * @return
     */
    @Override
    public synchronized List<Cookie> loadCookie(HttpUrl url) {
        List<Cookie> cookies = memoryCookies.get(url.host());
        if (cookies == null) {
            cookies = new ArrayList<>();
            memoryCookies.put(url.host(), cookies);
        }
        return cookies;
    }

    /**
     * 获取所有cookie
     *
     * @return
     */
    @Override
    public synchronized List<Cookie> getAllCookie() {
        List<Cookie> cookies = new ArrayList<>();
        Set<String> httpUrls = memoryCookies.keySet();
        for (String url : httpUrls) {
            cookies.addAll(memoryCookies.get(url));
        }
        return cookies;
    }

    /**
     * 获取cookie
     *
     * @param url
     * @return
     */
    @Override
    public List<Cookie> getCookie(HttpUrl url) {
        List<Cookie> cookies = new ArrayList<>();
        List<Cookie> urlCookies = memoryCookies.get(url.host());
        if (urlCookies != null) cookies.addAll(urlCookies);
        return cookies;
    }

    @Override
    public synchronized boolean removeCookie(HttpUrl url, Cookie cookie) {
        List<Cookie> cookies = memoryCookies.get(url.host());
        return (cookie != null) && cookies.remove(cookie);
    }

    /**
     * 删除cookie
     *
     * @param url
     * @return
     */
    @Override
    public synchronized boolean removeCookie(HttpUrl url) {
        return memoryCookies.remove(url.host()) != null;
    }

    /**
     * 移除所有cookie
     *
     * @return
     */
    @Override
    public synchronized boolean removeAllCookie() {
        memoryCookies.clear();
        return true;
    }
}
