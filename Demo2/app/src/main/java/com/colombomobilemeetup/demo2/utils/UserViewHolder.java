package com.colombomobilemeetup.demo2.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.colombomobilemeetup.demo2.R;
import com.colombomobilemeetup.demo2.database.User;

public class UserViewHolder extends RecyclerView.ViewHolder {
    public TextView fistName;
    public TextView lastName;

    public UserViewHolder(View itemView) {
        super(itemView);
        fistName = itemView.findViewById(R.id.textViewFirstName);
        lastName = itemView.findViewById(R.id.textViewLasttName);
    }

    public void bind(User user) {
        fistName.setText(user.firstName);
        lastName.setText(user.lastName);
    }
}
