package moduloiii.alankin.com.moduloiii.network;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;

import moduloiii.alankin.com.moduloiii.LoginActivity;
import moduloiii.alankin.com.moduloiii.NewPostActivity;
import moduloiii.alankin.com.moduloiii.PostActivity;
import moduloiii.alankin.com.moduloiii.R;
import moduloiii.alankin.com.moduloiii.model.Post;
import moduloiii.alankin.com.moduloiii.model.User;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewPostAsyncTask extends AsyncTask<Object, Void, Post> {
    private NewPostActivity postActivity;

    public NewPostAsyncTask(NewPostActivity activity) {
        postActivity = activity;
    }

    @Override
    protected Post doInBackground(Object... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dip-androiducbv2.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostService service = retrofit.create(PostService.class);
        Call<Post> call = service.post((Post) params[0], (Integer) params[1]);
        try {
            Response<Post> response = call.execute();
            Post post = response.body();
            return post;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Post post) {
        if (post == null) {
            Toast.makeText(postActivity, "The post was not created, try again please.", Toast.LENGTH_LONG).show();
        } else {
            System.out.println("The created post is " + post.getTitle());
            Toast.makeText(postActivity, "The post was created successfully.", Toast.LENGTH_LONG).show();
        }
    }
}
