package com.brentlrayjr.floot.Interfaces;

import com.brentlrayjr.floot.Models.User;

/**
 * Created by blray on 11/27/2015.
 */
public interface SessionListener {

    void onLoginAttempt();

    void onLogoutAttempt();

    void onLoginSuccess(String session);

    void onLoginFail(String message, String action);

    void onLogOutSuccess();

    void onDeregisterAttempt(User user);

    void onDeregisterFail(String message);

}
