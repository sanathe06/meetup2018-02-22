package com.colombomobilemeetup.demo2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

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
