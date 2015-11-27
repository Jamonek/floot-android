package com.brentlrayjr.floot.Models;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by blray on 11/26/2015.
 */
public class RESTClient {

    private static final String BASE_URL = "http://www.floot.co/";

    private AsyncHttpClient client;
    private RequestParams requestParams;

    public RESTClient(RequestParams requestParams) {

        this.client = new AsyncHttpClient();
        this.requestParams = requestParams;

    }

    public RESTClient(RESTClient restClient) {

        this.client = restClient.client;
        this.requestParams = restClient.requestParams;

    }

    public RESTClient() {

        this.client = new AsyncHttpClient();
        this.requestParams = null;


    }

    public void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(buildURL(url), params, responseHandler);
    }

    public void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(buildURL(url), params, responseHandler);
    }

    private String buildURL(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }

    public void setRequestParams(RequestParams requestParams) {

        this.requestParams = requestParams;

    }

    public RequestParams getRequestParams() {

        return this.requestParams;

    }


}
