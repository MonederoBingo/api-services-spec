/* Copyright 2016 Sabre Holdings */
package com.monederobingo.step_definitions.domain_holders;

import com.monederobingo.api.client.requests.auth.AuthRequest;

public class AuthRequestHolder
{
    private AuthRequest authRequest;

    public void set(AuthRequest authRequest)
    {
        this.authRequest = authRequest;
    }

    public AuthRequest get()
    {
        return authRequest;
    }
}
