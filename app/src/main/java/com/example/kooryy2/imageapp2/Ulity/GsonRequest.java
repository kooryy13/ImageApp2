package com.example.kooryy2.imageapp2.Ulity;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created by Veteran Commander on 8/26/2016.
 */
public class GsonRequest<T> extends Request<T> {

    protected static Gson mGson = getGson();

    protected final Class<T> clazz;

    protected Response.Listener<T> listener;

    protected Map<String,String> header;

    protected Map<String,String> params;



    public static Gson getGson(){
        return new GsonBuilder().create();
    }



    public GsonRequest(int method, String url, Response.ErrorListener listener, Class<T> clazz) {
        super(method, url, listener);
        this.clazz = clazz;
    }

    public void setListener(Response.Listener<T> listener) {
        this.listener = listener;
    }

    public void setHeader(Map<String, String> header) {
        this.header = header;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;

    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        if (header == null){
            return super.getHeaders();
        } else {
            return header;
        }

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        //return super.getParams();
        return params;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try{
            String json = new String(response.data, Charset.forName("UTF-8"));
            DebugLog.i(json);
            Response<T> success = Response.success(mGson.fromJson(json,clazz), HttpHeaderParser.parseCacheHeaders(response));
            return success;
        } catch (JsonSyntaxException e){
            e.printStackTrace();
            return Response.error(new ParseError());
        }
    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }
}
