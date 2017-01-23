package com.mgi.edunitas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;



public class ChatActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    FirebaseRecyclerAdapter<PojoMessage,ViewHolderMessage> mRecyclerAdapter;
    RecyclerView rvChat;
    Button btnSend;
    EditText etText;
    String nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        btnSend = (Button) findViewById(R.id.btnSend);
        etText = (EditText) findViewById(R.id.etText);
        rvChat = (RecyclerView) findViewById(R.id.rvChat);
        rvChat.setLayoutManager(new LinearLayoutManager(ChatActivity.this));
        mAuth = FirebaseAuth.getInstance();
        nama = mAuth.getCurrentUser().getEmail();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        showMessage();

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
                rvChat.smoothScrollToPosition(rvChat.getAdapter().getItemCount());
                etText.setText("");
            }
        });

    }

    public void sendMessage(){
        DatabaseReference mRef = mDatabase.child("chat");
        String text = etText.getText().toString();
        long time =0;
        PojoMessage msg = new PojoMessage(text,time,nama);
        String key=mRef.push().getKey();
        mRef.child(key).setValue(msg);
        mRef.child(key).child("createdOn").setValue(ServerValue.TIMESTAMP);
    }

    public void showMessage(){
        DatabaseReference mRef = mDatabase.child("chat");
        FirebaseRecyclerAdapter<PojoMessage,ViewHolderMessage> mRecyclerAdapter = new FirebaseRecyclerAdapter<PojoMessage, ViewHolderMessage>
                (PojoMessage.class,R.layout.list_chat,ViewHolderMessage.class, mRef) {
            @Override
            protected void populateViewHolder(ViewHolderMessage viewHolder, PojoMessage model, int position) {
                viewHolder.bindToPost(model,nama,ChatActivity.this);
            }
        };
        rvChat.setAdapter(mRecyclerAdapter);
    }
}
