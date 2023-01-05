package com.training.scheduler.configuration;

public class AuthenticationContext {

    private static ThreadLocal<String> currentSession= new ThreadLocal<>();

    public static void setJwtToken(String token) {
        currentSession.set(token);
    }

    public static String getJwtToken() {
        return currentSession.get();
    }

    public static void clear(){
        currentSession.remove();
    }
}
