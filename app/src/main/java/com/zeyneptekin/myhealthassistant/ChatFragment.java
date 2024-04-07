package com.zeyneptekin.myhealthassistant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
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

        // Arayüz elemanlarına erişim sağlama
        ListView chatListView = view.findViewById(R.id.chatListView);
        EditText messageEditText = view.findViewById(R.id.messageEditText);
        Button sendButton = view.findViewById(R.id.sendButton);

        // Mesajlar için ArrayList oluşturma
        messages = new ArrayList<>();

        // Adapter oluşturma
        adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, messages);
        chatListView.setAdapter(adapter);

        // Gönderme butonuna tıklama işlemi ekleme
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText'ten alınan metni mesaj listesine ekleme
                String messageText = messageEditText.getText().toString();
                ChatMessageClass message = new ChatMessageClass(messageText);

                if (!message.getContent().isEmpty()) {

                    messages.add(message);
                    adapter.notifyDataSetChanged();
                    // Mesaj gönderildikten sonra EditText'i temizleme
                    messageEditText.getText().clear();
                }
            }
        });

        return view;
    }
}
