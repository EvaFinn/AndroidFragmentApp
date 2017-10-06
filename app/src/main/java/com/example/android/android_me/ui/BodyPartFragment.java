package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {
    private static final String TAG = "BodyPartFragment";
    private static final String IMAGE_ID_LIST = "image_ids";
    private static final String LIST_INDEX = "list_index";

    private List<Integer> imageIds;
    private int listIndex;

    public BodyPartFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            imageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            listIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        View bodyPart = inflater.inflate(R.layout.fragment_body_part, container, false);
        final ImageView imageView = (ImageView) bodyPart.findViewById(R.id.iv_fragment_body_part);

        if (imageIds != null) {
            imageView.setImageResource(imageIds.get(listIndex));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listIndex < imageIds.size() - 1) {
                        listIndex++;
                    } else {
                        listIndex = 0;
                    }
                    imageView.setImageResource(imageIds.get(listIndex));
                }
            });
        } else {
            Log.v(TAG, "Image id is not set");
        }
        return bodyPart;
    }

    public void setImageIds(List<Integer> imageIds) {
        this.imageIds = imageIds;
    }

    public void setListIndex(int index) {
        this.listIndex = index;
    }

    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) imageIds);
        currentState.putInt(LIST_INDEX, listIndex);
    }
}
