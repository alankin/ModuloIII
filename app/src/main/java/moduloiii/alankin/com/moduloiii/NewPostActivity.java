package moduloiii.alankin.com.moduloiii;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import moduloiii.alankin.com.moduloiii.model.Post;
import moduloiii.alankin.com.moduloiii.network.NewPostAsyncTask;

public class NewPostActivity extends AppCompatActivity {
    private EditText titlePost;
    private EditText contentPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        titlePost = (EditText) findViewById(R.id.title_post);
        contentPost = (EditText) findViewById(R.id.content_post);
    }

    public void savePost(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        int user_id = sharedPreferences.getInt("user_id", -1);

        Post post = new Post();
        post.setTitle(titlePost.getText().toString());
        post.setContent(contentPost.getText().toString());

        NewPostAsyncTask task = new NewPostAsyncTask(this);
        task.execute(post, user_id);

        finish();
    }
}
