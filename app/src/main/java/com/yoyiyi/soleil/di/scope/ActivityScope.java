package com.yoyiyi.soleil.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/4/28 11:47
 * 描述:Activity 生命周期
 */
@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
