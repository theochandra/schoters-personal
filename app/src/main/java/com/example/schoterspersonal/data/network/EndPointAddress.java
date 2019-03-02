package com.example.schoterspersonal.data.network;

import com.example.schoterspersonal.BuildConfig;

public class EndPointAddress {

    public static final String RETRIEVE_PERSONAL_CATEGORY = "categories";

    private EndPointAddress() { }

    public static String getSchotersEndpoint(String endpointPath) {
        return BuildConfig.SCHOTERS_SERVER_URL + endpointPath;
    }

}
