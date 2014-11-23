package es.sglora.tutorial_gradle_flavors.service;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import es.sglora.tutorial_gradle_flavors.model.RandomUserDTO;

/**
 * Created by fabiomsr on 22/11/14.
 */
public class UserServiceImpl implements UserService {

  private static final String TAG = UserServiceImpl.class.getSimpleName();
  private static final String RANDOM_USER_SERVICE_URL = "http://api.randomuser.me/?results=10";

  OkHttpClient mClient = new OkHttpClient();
  Gson mGson = new Gson();

  @Override
  public RandomUserDTO.ResultDTO[] getUsers(Context context) {

    try {
      Request request = new Request.Builder()
          .url(RANDOM_USER_SERVICE_URL)
          .build();

      Response response = mClient.newCall(request).execute();
      String responseBody = response.body().string();
      RandomUserDTO randomUserDTO = mGson.fromJson(responseBody, RandomUserDTO.class);
      return randomUserDTO.results;
    } catch (Exception e){
      Log.e(TAG, e.getMessage(), e);
    }

    return new RandomUserDTO.ResultDTO[0];
  }
}
