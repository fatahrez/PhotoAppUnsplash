package com.example.photoapp.networking;

public class NetworkUtil {
    private static NetworkService networkService;

    public static NetworkService ApiInstance() {
        if (networkService == null) {
            networkService = NetworkClient.getRetrofit().create(NetworkService.class);
        }
        return networkService;
    }
}
