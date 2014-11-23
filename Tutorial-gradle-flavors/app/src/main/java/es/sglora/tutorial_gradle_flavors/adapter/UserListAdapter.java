package es.sglora.tutorial_gradle_flavors.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import es.sglora.tutorial_gradle_flavors.R;
import es.sglora.tutorial_gradle_flavors.model.RandomUserDTO;

/**
 * Created by fabiomsr on 23/11/14.
 */
public class UserListAdapter extends ArrayAdapter<RandomUserDTO.UserDTO>{

  class Holder {
    TextView titleView;
    TextView fullNameTitleView;
  }

  LayoutInflater mInflater;

  public UserListAdapter(Context context, int resource) {
    super(context, resource);
    mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View view = convertView;
    Holder holder = null;
    if (view != null) {
      holder = (Holder) view.getTag();
    } else {
      view = mInflater.inflate(R.layout.adapter_user_list_item, parent, false);
      holder = new Holder();
      holder.titleView = (TextView) view.findViewById(R.id.adapter_user_list_title);
      holder.fullNameTitleView = (TextView) view.findViewById(R.id.adapter_user_list_full_name);

      view.setTag(holder);
    }

    RandomUserDTO.UserDTO userDTO = getItem(position);
    holder.titleView.setText(userDTO.name.title);
    holder.fullNameTitleView.setText(userDTO.name.first + " " + userDTO.name.last);

    return view;
  }
}
