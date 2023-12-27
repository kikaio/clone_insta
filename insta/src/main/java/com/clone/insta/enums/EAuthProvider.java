package com.clone.insta.enums;

public enum EAuthProvider {
    NONE("none", "not exist provider", false)
    , APP("app", "sign in with app", false)
    , GOOGLE("google", "sign in with google oauth", true)
    , NAVER("naver", "sign in with naver", false)
    , KAKAO("kakao", "sign in with kakao", false)
    , GITHUB("github", "sign in with github", false)
    ;
    public final String provider;
    public final String desc;
    public final boolean useable;

    private EAuthProvider(String provider, String desc, boolean useable)
    {
        this.provider = provider;
        this.desc = desc;
        this.useable = useable;
    }
}
