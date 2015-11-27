package com.brentlrayjr.floot.ModelControllers;

import android.app.Activity;

import com.bluelinelabs.logansquare.LoganSquare;
import com.brentlrayjr.floot.Interfaces.SessionListener;
import com.brentlrayjr.floot.Models.RESTClient;
import com.brentlrayjr.floot.Models.User;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by blray on 11/26/2015.
 */
public class UserController {

    private RESTClient restClient;
    private ArrayList<User> users;
    private Activity activity;

    private static SessionListener sessionListener;

    private static User currentUser;
    private static User targetUser;

    private RequestParams params;

    public UserController(Activity activity) {

        this.restClient = new RESTClient();
        this.users = new ArrayList<>();
        this.activity = activity;
        this.params = null;
        setCurrentUser(null);
        setTargetUser(null);


    }

    public static User getCurrentUser() {

        return currentUser;
    }

    public static void setCurrentUser(User user) {

        currentUser = user;
    }

    public static void setTargetUser(User user) {

        targetUser = user;
    }

    public static User getTargetUser() {

        return targetUser;
    }

    public void setParams(User user) {

        this.params = new RequestParams();

        this.params.add("identity", user.getUsername());
        this.params.add("password", user.getPassword());
        this.params.add("email", user.getEmail());
        this.restClient.setRequestParams(this.params);

    }

    public User createUser(String email, String username, String password) {

        User user = new User(email, username, password);

        return user;

    }

    public void register(final User user) {

        if (user != null) {

            this.setParams(user);

            restClient.post("users.php", restClient.getRequestParams(), new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    // If the response is JSONObject instead of expected JSONArray

                }

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray jsonArray) {
                    // Pull out the first event on the public timeline
                    Boolean success = false;
                    String sessionToken = "";
                    String message = "";

                    try {

                        success = LoganSquare.parse(jsonArray.getString(0), Boolean.class);

                        if (success) {
                            sessionToken = jsonArray.getString(1);
                        }


                    } catch (Exception e) {
                        message = e.getMessage();
                    }

                    if (success) {

                        setCurrentUser(user);
                        sessionListener.onLoginSuccess(sessionToken);
                    } else {
                        sessionListener.onLoginFail(message, "Retry");
                    }

                }
            });

            setCurrentUser(user);
            setTargetUser(null);

        }

    }


    public void login(final User user) {


        if (user != null) {

            this.setParams(user);

            restClient.post("login.py", restClient.getRequestParams(), new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    // If the response is JSONObject instead of expected JSONArray

                }

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray jsonArray) {
                    // Pull out the first event on the public timeline
                    Boolean success = false;
                    String sessionToken = "";
                    String message = "";

                    try {

                        success = LoganSquare.parse(jsonArray.getString(0), Boolean.class);

                        if (success) {
                            sessionToken = jsonArray.getString(1);
                        }


                    } catch (Exception e) {
                        message = e.getMessage();
                    }

                    if (success) {

                        setCurrentUser(user);
                        sessionListener.onLoginSuccess(sessionToken);
                    } else {
                        sessionListener.onLoginFail(message, "Retry");
                    }

                }
            });

            setCurrentUser(user);
            setTargetUser(null);

        }

    }


    public void deregister() {

        restClient.post("deregister.py", restClient.getRequestParams(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray jsonArray) {
                // Pull out the first event on the public timeline
                Boolean success = null;
                String message = "";

                try {

                    success = LoganSquare.parse(jsonArray.getString(0), Boolean.class);
                    users = null;

                } catch (Exception e) {
                    message = e.getMessage();
                }

                if (success) {
                    sessionListener.onDeregisterAttempt(getCurrentUser());
                } else {
                    sessionListener.onDeregisterFail(message);
                }

            }
        });

    }

    public static void logout() {

        if (getCurrentUser() != null) {

            sessionListener.onLoginAttempt();


        }
    }

    public void upVote(User u) {

        restClient.post("users.php", restClient.getRequestParams(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray jsonArray) {
                // Pull out the first event on the public timeline
                Boolean success = null;
                String message = "";

                try {

                    success = jsonArray.getBoolean(0);
                    message = jsonArray.getString(1);
                    users = null;
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });


    }

    public void downVote(User u) {

        restClient.post("users.php", restClient.getRequestParams(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray jsonArray) {
                // Pull out the first event on the public timeline
                Boolean success = null;
                String message = "";

                try {

                    success = jsonArray.getBoolean(0);
                    message = jsonArray.getString(1);
                    users = null;

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }


        });


    }


    public ArrayList<User> getUsers() {

        return this.users;
    }


    public void queryUsers() {

        restClient.post("users.php", restClient.getRequestParams(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray jsonArray) {
                // Pull out the first event on the public timeline
                Boolean success = null;
                String message = "";

                try {

                    success = jsonArray.getBoolean(0);
                    message = jsonArray.getString(1);
                    users = null;

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });


    }


}
