package moduloiii.alankin.com.moduloiii;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import moduloiii.alankin.com.moduloiii.adapter.PostAdapter;
import moduloiii.alankin.com.moduloiii.network.PostsAsyncTask;

public class PostFragment extends Fragment {
    private ListView listView;
    private PostAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);

        listView = (ListView) view.findViewById(R.id.post_list_view);
        adapter = new PostAdapter(getActivity());
        listView.setAdapter(adapter);

        PostsAsyncTask task = new PostsAsyncTask(this);
        task.execute();

        return view;
    }

    public PostAdapter getAdapter() {
        return adapter;
    }
}
