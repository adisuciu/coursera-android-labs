package course.labs.fragmentslab;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FeedFragment extends Fragment {

	private static final String TAG = "Lab-Fragments";

	private TextView mTextView;
	private static FeedFragmentData feedFragmentData;

    private int pos = -1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i(TAG, "Feed.onCreateView()");

        return inflater.inflate(R.layout.feed, container, false);

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		// Read in all Twitter feeds
		Log.i(TAG, "Feed.onActivityCreated()");
		if (null == feedFragmentData) { 
			
			feedFragmentData = new FeedFragmentData(getActivity());
		}
        if(pos!=-1)
            updateFeedDisplayFromRetainedInstance();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "FeedFragDestroyed");
	}

	// Display Twitter feed for selected feed

	void updateFeedDisplay(int position) {

		Log.i(TAG, "Entered updateFeedDisplay()");
        pos = position;
		mTextView = (TextView) getView().findViewById(R.id.feed_view);
		mTextView.setText(feedFragmentData.getFeed(position));

	}

    void updateFeedDisplayFromRetainedInstance()
    {
        updateFeedDisplay(pos);
    }


}
