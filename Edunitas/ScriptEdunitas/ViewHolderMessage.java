package com.mgi.edunitas;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by acer on 1/19/2017.
 */

public class ViewHolderMessage  extends RecyclerView.ViewHolder{
    public TextView tvNama,tvTime,tvMessage;
    public RelativeLayout relativeLayout;
    public LinearLayout linearLayout;

    public ViewHolderMessage(View itemView) {
        super(itemView);
        tvNama = (TextView) itemView.findViewById(R.id.tvNama);
        tvTime = (TextView) itemView.findViewById(R.id.tvTime);
        tvMessage = (TextView) itemView.findViewById(R.id.tvChat);
        relativeLayout = (RelativeLayout)itemView.findViewById(R.id.chatContainerParent);
        linearLayout = (LinearLayout) itemView.findViewById(R.id.chatContainer);
    }

    public void bindToPost(PojoMessage pojoMessage,String nama, Activity context){
        if(pojoMessage.getCreatedBy().equals(nama)) {
            relativeLayout.setGravity(Gravity.END);
            linearLayout.setBackgroundColor(Color.YELLOW);
            linearLayout.setGravity(Gravity.END);
        }
        else {
            relativeLayout.setGravity(Gravity.START);
            linearLayout.setBackgroundColor(Color.GREEN);
            linearLayout.setGravity(Gravity.START);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy, HH:mm:ss");
        sdf.setTimeZone(Calendar.getInstance().getTimeZone());

        tvNama.setText(pojoMessage.getCreatedBy());
        tvTime.setText(sdf.format(new Date(pojoMessage.getCreatedOn())));
        tvMessage.setText(pojoMessage.getMessage());
    }


}
