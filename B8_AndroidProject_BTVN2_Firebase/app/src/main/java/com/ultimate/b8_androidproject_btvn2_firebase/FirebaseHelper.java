package com.ultimate.b8_androidproject_btvn2_firebase;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseHelper {
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private List<Article> articles = new ArrayList<>();

    public FirebaseHelper() {
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Articles");
    }

    public interface DataStatus {
        void DataIsLoaded(List<Article> articles, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeteled();
    }

    public void readArticles(final DataStatus dataStatus) {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                articles.clear();
                List<String> keys = new ArrayList<>();

                for (DataSnapshot keyNode : snapshot.getChildren()) {
                    keys.add(keyNode.getKey());
                    Article article = keyNode.getValue(Article.class);
                    articles.add(article);
                }

                dataStatus.DataIsLoaded(articles, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
