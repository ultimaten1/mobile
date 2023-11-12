package com.example.photo_firebase;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    Button btn_choosefile, btn_upload;
    TextView txt_showupload;
    EditText edit_filename;
    ImageView imageview;
    ProgressBar progressbar;

    private Uri ImageUri;

    private StorageReference StorageRef;
    private DatabaseReference DatabaseRef;
    private StorageTask UploadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_choosefile = findViewById(R.id.btn_choosefile);
        btn_upload = findViewById(R.id.btn_upload);
        txt_showupload = findViewById(R.id.txt_showupload);

        edit_filename = findViewById(R.id.edit_filename);
        imageview = findViewById(R.id.imageview);
        progressbar = findViewById(R.id.progressbar);

        StorageRef = FirebaseStorage.getInstance().getReference("uploads");
        DatabaseRef = FirebaseDatabase.getInstance().getReference("uploads");

        btn_choosefile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFileChooser();

            }
        });

        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (UploadTask != null && UploadTask.isInProgress()){
                    Toast.makeText(MainActivity.this,"Upload in progress",Toast.LENGTH_SHORT).show();
                } else {
                    uploadFile();
                }


            }
        });

        txt_showupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openImagesActivity();
            }
        });
    }

    private void openFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null){

            ImageUri = data.getData();
            Picasso.get().load(ImageUri).into(imageview);
            //imageview.setImageURI(ImageUri); --> sử dụng khi không dùng Picasso
        }
    }

    private String getFileExtension(Uri uri){
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }
    private void uploadFile(){
        if (ImageUri != null){
            StorageReference fileReference = StorageRef.child( System.currentTimeMillis()
            + "." + getFileExtension(ImageUri));

            UploadTask = fileReference.putFile(ImageUri).
                    addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progressbar.setProgress(0);
                        }
                    },500);

                    Toast.makeText(MainActivity.this, "Upload Successful", Toast.LENGTH_LONG).show();

                    /*Upload upload = new Upload(edit_filename.getText().toString().trim(),
                            taskSnapshot.getStorage().getDownloadUrl().toString());

                    String uploadId = DatabaseRef.push().getKey();
                    DatabaseRef.child(uploadId).setValue(upload);*/

                    Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                    while (!urlTask.isSuccessful());
                    Uri downloadUrl = urlTask.getResult();

                    //Log.d(TAG, "onSuccess: firebase download url: " + downloadUrl.toString()); //use if testing...don't need this line.
                    Upload upload = new Upload(edit_filename.getText().toString().trim(),downloadUrl.toString());

                    String uploadId = DatabaseRef.push().getKey();
                    DatabaseRef.child(uploadId).setValue(upload);

                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                            progressbar.setProgress((int) progress);

                        }
                    });
            
        } else{
            Toast.makeText(this, "No file selected", Toast.LENGTH_SHORT).show();
        }
    }

    private void openImagesActivity(){
        Intent intent = new Intent(this, ImagesActivity.class);
        startActivity(intent);
    }
}