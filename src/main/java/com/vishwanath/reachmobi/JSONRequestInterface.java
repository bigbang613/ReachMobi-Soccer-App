package com.vishwanath.reachmobi;

import android.view.View;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by vishwanath on 2/3/18.
 */

public interface JSONRequestInterface {

    @GET(".json")
    Call<JSONResponse> getJSON();

}
