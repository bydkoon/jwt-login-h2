package com.es.api.config.security;

public class JwtProperties {
    public static final String SECRET = "szs";
    public static final int EXPIRATION_TIME = 30 * 60 * 1000; // 30분
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}