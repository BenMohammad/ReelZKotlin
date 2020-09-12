package com.benmohammad.reelzapp.data.model;

import com.benmohammad.reelzapp.data.api.ApiHandler;

public class PostData
{
    private String clientId;
    private String clientSecret;
    private String script;
    private String language;
    private String versionIndex;

    public PostData(String script) {
        this.script = script;
        this.clientId = ApiHandler.API_ID;
        this.clientSecret = ApiHandler.API_SECRET;
        this.language = ApiHandler.LANGUAGE;
        this.versionIndex = ApiHandler.VERSION_INDEX;
    }

    public PostData() {
        this.clientId = ApiHandler.API_ID;
        this.clientSecret = ApiHandler.API_SECRET;
    }
}
