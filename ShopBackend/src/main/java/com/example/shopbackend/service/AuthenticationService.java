package com.example.shopbackend.service;

import com.example.shopbackend.model.User;

public interface AuthenticationService { public User signInAndReturnJWT(User signInRequest);
}
