package com.example.quiz;

import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.quiz.databinding.FragmentWalletBinding;
import com.example.quiz.model.User;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class WalletFragment extends Fragment {

    public WalletFragment() {
        // Required empty public constructor
    }


    FragmentWalletBinding walletBinding;
    FirebaseFirestore database;
    User user;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        walletBinding = FragmentWalletBinding.inflate(inflater, container, false);

        database = FirebaseFirestore.getInstance();
        database.collection("user").document(FirebaseAuth.getInstance().getUid())
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    // In this listener error chances are less
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                 user = documentSnapshot.toObject(User.class);
                walletBinding.coin.setText(String.valueOf(user.getCoins()));
                if(user.getCoins() < 50000){
                    walletBinding.upibtn.setEnabled(false);
                    walletBinding.upibtn.setBackgroundColor(Color.GRAY);
                    walletBinding.upibtn.setTextColor(Color.WHITE);
                }
            }
        });
        walletBinding.upibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String upiId = walletBinding.upibox.getText().toString();
                // do the operation

            }
        });
        // Inflate the layout for this fragment
        return walletBinding.getRoot();
    }

}