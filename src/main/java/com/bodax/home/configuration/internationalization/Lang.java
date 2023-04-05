package com.bodax.home.configuration.internationalization;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum Lang {

    UA("ua", 2),
    RU("ru", 1);

    private final String langCode;
    private static final Lang DEFAULT = RU;
    private static final String HTTP_REQUEST_PARAM_NAME = "lan";
    private final Integer langId;

    Lang(String langCodeIso, Integer id) {
        this.langCode = langCodeIso;
        this.langId = id;
    }

    public static int toLangCode(String langTag) {
        return Stream.of(Lang.values())
                .filter(lt -> lt.getLangCode().equalsIgnoreCase(langTag))
                .findFirst()
                .orElse(DEFAULT).getLangId();
    }
}
