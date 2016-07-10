package moduloiii.alankin.com.moduloiii.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import moduloiii.alankin.com.moduloiii.PostFragment;
import moduloiii.alankin.com.moduloiii.R;
import moduloiii.alankin.com.moduloiii.model.Post;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsAsyncTask extends AsyncTask <Void, Void, List<Post>> {
    private PostFragment fragment;
    private int user_id;

    public PostsAsyncTask(PostFragment postFragment) {
        fragment = postFragment;

        SharedPreferences sharedPreferences = fragment.getActivity().getSharedPreferences(fragment.getActivity().getString(R.string.app_name), Context.MODE_PRIVATE);
        user_id = sharedPreferences.getInt("user_id", -1);
    }

    @Override
    protected List<Post> doInBackground(Void... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dip-androiducbv2.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostService service = retrofit.create(PostService.class);
        Call<List<Post>> call = service.getPosts(user_id);

        try {
            Response<List<Post>> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    protected void onPostExecute(List<Post> posts) {
        fragment.getAdapter().clear();
        fragment.getAdapter().addAll(posts);
    }
}
