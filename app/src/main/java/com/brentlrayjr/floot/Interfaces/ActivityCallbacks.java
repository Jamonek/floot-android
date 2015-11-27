package com.brentlrayjr.floot.Interfaces;

/**
 * Created by blray on 11/26/2015.
 */
public interface ActivityCallbacks {

    void onBackgroundStart(String message);

    void onBackgroundSuccess(String message);

    void onBackgroundFail(String message, String action);

    void onLogOutAction();

}
