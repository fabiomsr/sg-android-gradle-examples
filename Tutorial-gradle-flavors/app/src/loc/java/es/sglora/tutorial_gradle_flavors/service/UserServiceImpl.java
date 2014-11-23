package es.sglora.tutorial_gradle_flavors.service;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import es.sglora.tutorial_gradle_flavors.model.RandomUserDTO;

/**
 * Created by fabiomsr on 22/11/14.
 */
public class UserServiceImpl implements UserService {

  private static final String TAG = UserServiceImpl.class.getSimpleName();

  Gson mGson = new Gson();

  @Override
  public RandomUserDTO.ResultDTO[] getUsers(Context context) {

    InputStream inputStream = null;

    try {
      inputStream = context.getAssets().open("user.json");
      Reader reader = new InputStreamReader(inputStream);
      RandomUserDTO randomUserDTO = mGson.fromJson(reader, RandomUserDTO.class);
      return randomUserDTO.results;
    }catch (Exception e){
      Log.e(TAG, e.getMessage(), e);
    }finally {
      try {
        if (inputStream != null) {
          inputStream.close();
        }
      }catch (Exception e){
        Log.e(TAG, e.getMessage(), e);
      }
    }

    return new RandomUserDTO.ResultDTO[0];
  }
}
