package com.art.demo4.Configuration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

public class ClearRequestCacheLogoutHandler implements LogoutHandler {

    private final RequestCache requestCache;

    public ClearRequestCacheLogoutHandler(RequestCache requestCache) {
        this.requestCache = requestCache;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        if (requestCache != null) {
            requestCache.removeRequest(request, response);
        }
    }
}
