package com.bodax.home.configuration.internationalization;

import org.springframework.context.i18n.LocaleContextHolder;

public class LocaleContext {

    public static final String HTTP_REQUEST_PARAM_NAME = "lan";

    public static int getLocaleId() {
        return Lang.toLangCode(LocaleContextHolder.getLocale().toLanguageTag());
    }
}
