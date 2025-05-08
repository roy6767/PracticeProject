package org.example.practiceproject1.security;

import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    // "login" is default for GitHub, change to "email" if that's what you want
    private static final String NAME_ATTRIBUTE = "login";
    private static final String EMAIL_KEY = "email";

    private final GitHubEmailFetcher emailFetcher;
    private final OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();

    public CustomOAuth2UserService(GitHubEmailFetcher emailFetcher) {
        this.emailFetcher = emailFetcher;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oauth2User = delegate.loadUser(userRequest);
        if(!userRequest.getClientRegistration().getRegistrationId().equals("github")) {
            return oauth2User;
        }

        String primaryEmailAddress = extractPrimaryEmailAddress(
                oauth2User,
                userRequest.getAccessToken().getTokenValue());

        if (primaryEmailAddress == null) {
            return oauth2User;
        }

        Map<String, Object> updatedAttributes = new HashMap<>(oauth2User.getAttributes());

        updatedAttributes.put(EMAIL_KEY, primaryEmailAddress);

        return new DefaultOAuth2User(
                oauth2User.getAuthorities(),
                updatedAttributes,
                NAME_ATTRIBUTE);
    }

    private String extractPrimaryEmailAddress(
            OAuth2User oauth2User,
            String token) {
        String primaryEmailAddress = oauth2User.getAttribute(EMAIL_KEY);

        if (!(primaryEmailAddress == null || primaryEmailAddress.isBlank())) {
            return primaryEmailAddress;
        }

        return emailFetcher.fetchPrimaryEmailAddress(token);
    }
}