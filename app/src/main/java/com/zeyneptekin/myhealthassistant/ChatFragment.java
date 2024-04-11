package com.zeyneptekin.myhealthassistant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class ChatFragment extends Fragment {

    private ArrayList<ChatMessageClass> messages;
    private ArrayAdapter<ChatMessageClass> adapter;

    public ChatFragment() {
        // Boş yapıcı metot
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        ListView chatListView = view.findViewById(R.id.chatListView);
        EditText messageEditText = view.findViewById(R.id.messageEditText);
        Button sendButton = view.findViewById(R.id.sendButton);

        messages = new ArrayList<>();

        adapter = new ArrayAdapter<ChatMessageClass>(requireContext(), android.R.layout.simple_list_item_1, messages) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView textView = view.findViewById(android.R.id.text1);
                ChatMessageClass message = messages.get(position);

                textView.setText(message.getContent());

                // Mesajın kullanıcı tarafından mı asistan tarafından mı gönderildiğini kontrol et
                if (message.getIsUserMessage()) {
                    // Kullanıcı tarafından gönderilmişse
                    textView.setBackgroundResource(R.drawable.user_message_background);
                } else {
                    // Asistan tarafından gönderilmişse
                    textView.setBackgroundResource(R.drawable.assistant_message_background);
                }

                return view;
            }
        };

        chatListView.setAdapter(adapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = messageEditText.getText().toString();
                ChatMessageClass userMessage = new ChatMessageClass("Siz\n" + messageText, true); // Kullanıcı tarafından gönderilen mesaj
                ChatMessageClass assistantMessage = new ChatMessageClass("Assistan\n"+"Deneme", false); // Asistan tarafından gönderilen mesaj

                if (!userMessage.getContent().isEmpty()) {
                    messages.add(userMessage);
                    messages.add(assistantMessage);
                    adapter.notifyDataSetChanged();
                    messageEditText.getText().clear();
                }
            }
        });

        return view;
    }
}
