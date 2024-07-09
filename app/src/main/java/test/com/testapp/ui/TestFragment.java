package test.com.testapp.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import test.com.testapp.R;
import test.com.testapp.base.BaseFragment;
import test.com.testapp.modal.Post;

public class TestFragment extends BaseFragment implements TestView {

    View mFragmentView;

    @Override
    public void hideLoading() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter.onViewCreated();
    }

    @Override
    protected TestPresenter instantiatePresenter() {
        return new TestPresenter(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onViewDestoryed();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentView = inflater.inflate(R.layout.fragment_test, container, false);
        return mFragmentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mFragmentView.findViewById(R.id.tv_user_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TestPresenter) presenter).loadPosts();
            }
        });
    }

    @Override
    public void updatePosts(List<Post> posts) {
        System.out.println("TestFragment.updatePosts");
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
    }

}
