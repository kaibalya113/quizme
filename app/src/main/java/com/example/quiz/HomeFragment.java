package com.example.quiz;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import com.example.quiz.databinding.FragmentHomeBinding;
import com.google.firebase.firestore.*;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }
    FragmentHomeBinding binding;
    FirebaseFirestore database;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        database = FirebaseFirestore.getInstance();

        // RecyclerView.Recycler
        final ArrayList<CategoryModel> list = new ArrayList<>();

        final CategoryAdapter categoryAdapter = new CategoryAdapter(getContext(), list);

        database.collection("categories").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                list.clear();
                for(DocumentSnapshot doc : value){
                    CategoryModel model = doc.toObject(CategoryModel.class);
                    model.setCategoryId(doc.getId());
                    list.add(model);
                }
                categoryAdapter.notifyDataSetChanged();

            }
        });
        binding.categorylistid.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.categorylistid.setAdapter(categoryAdapter);
        return binding.getRoot();
    }
}