package es.sglora.tutorial_gradle_flavors;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import es.sglora.tutorial_gradle_flavors.adapter.UserListAdapter;
import es.sglora.tutorial_gradle_flavors.model.RandomUserDTO;
import es.sglora.tutorial_gradle_flavors.service.UserService;
import es.sglora.tutorial_gradle_flavors.service.UserServiceImpl;

/**
 * Created by fabiomsr on 22/11/14.
 */
public class UserListActivity extends ListActivity {

  ProgressBar mLoadingView;
  UserListAdapter mUserListAdapter;
  UserService mUserService;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user_list);

    mLoadingView = (ProgressBar)findViewById(R.id.activity_user_list_loading);

    mUserListAdapter = new UserListAdapter(this, R.layout.adapter_user_list_item);
    mUserService = new UserServiceImpl();

    setListAdapter(mUserListAdapter);

    GetUserListTask getUserListTask = new GetUserListTask();
    getUserListTask.execute();
  }

  private void addUsers(RandomUserDTO.ResultDTO[] resultDTOs){
    for (RandomUserDTO.ResultDTO resultDTO : resultDTOs) {
      mUserListAdapter.add(resultDTO.user);
    }

    mUserListAdapter.notifyDataSetChanged();
    mLoadingView.setVisibility(View.GONE);
    getListView().setVisibility(View.VISIBLE);
  }

  private class GetUserListTask extends AsyncTask<Void,Void,RandomUserDTO.ResultDTO[]>{

    @Override
    protected RandomUserDTO.ResultDTO[] doInBackground(Void... params) {
      return mUserService.getUsers(UserListActivity.this);
    }

    @Override
    protected void onPostExecute(RandomUserDTO.ResultDTO[] userDTOs) {
      addUsers(userDTOs);
    }
  }
}
