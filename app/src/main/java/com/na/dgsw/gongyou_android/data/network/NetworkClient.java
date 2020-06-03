package com.na.dgsw.gongyou_android.data.network;

import android.util.Log;

import com.na.dgsw.gongyou_android.data.GenericResponse;

import org.json.JSONObject;

import java.util.Objects;

import io.reactivex.functions.Function;
import retrofit2.Response;

/**
 * Created by NA on 2020-06-02
 * skehdgur8591@naver.com
 */
public class NetworkClient {

    <T> Function<Response<GenericResponse<T>>, T> getResponseObjectsFunction() {
        return response -> {
            checkResponseErrorBody(response);
            Log.e("Status", response.body().getStatus() + "");
            return response.body().getData();
        };
    }

    Function<retrofit2.Response<GenericResponse>, String> getResponseMessageFunction() {
        return response -> {
            checkResponseErrorBody(response);
            Log.e("Status", response.body().getStatus() + "");
            return response.body().getMeesage();
        };
    }

    private void checkResponseErrorBody(retrofit2.Response response) throws Exception {
        if (!response.isSuccessful()) {
            JSONObject errorBody = new JSONObject(Objects
                    .requireNonNull(
                            response.errorBody()).string());
            Log.e("Status", errorBody.getInt("status") + "");
            response.errorBody().close();
            throw new Exception(errorBody.getString("message"));
        }
    }
}
