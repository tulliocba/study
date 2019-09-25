package com.github.tulliocba.money.api.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("moneyapi")
public class MoneyApiProperty {

    private final Security security = new Security();

    private String allowedOrigin = "http://localhost:8000";

    public Security getSecurity() {
        return security;
    }

    public String getAllowedOrigin() {
        return allowedOrigin;
    }

    public void setAllowedOrigin(String allowedOrigin) {
        this.allowedOrigin = allowedOrigin;
    }

    public static class Security{
        private boolean enableHttps;

        public boolean isEnableHttps() {
            return enableHttps;
        }

        public void setEnableHttps(boolean enableHttps) {
            this.enableHttps = enableHttps;
        }
    }


}
