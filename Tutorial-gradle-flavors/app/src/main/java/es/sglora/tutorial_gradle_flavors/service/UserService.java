package es.sglora.tutorial_gradle_flavors.service;

import android.content.Context;

import es.sglora.tutorial_gradle_flavors.model.RandomUserDTO;


/**
 * Created by fabiomsr on 22/11/14.
 */
public interface UserService {
  RandomUserDTO.ResultDTO[] getUsers(Context context);
}
