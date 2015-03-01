package com.example.michael.fragmentsprogram;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Michael on 2/22/2015.
 */
public class ShoppingListFragment extends Fragment {

    private View mView;
    private ListView mListView;
    private String[] shopping;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.list_fragment, null);
        mListView = (ListView) mView.findViewById(R.id.list_view);

        shopping = new String[] {"Chicken", "Potato", "Tomato", "Beef", "Pasta"};
        MyAdapter adapter = new MyAdapter(getActivity().getApplicationContext(), shopping);
        mListView.setAdapter(adapter);

        return mView;
    }

    class MyAdapter extends ArrayAdapter {

        private Context context;
        private String[] values;

        public MyAdapter(Context context, String[] values) {
            super(context, R.layout.list_item, values);
            this.context = context;
            this.values = values;
        }

        @Override
        public int getCount() {
            return values.length;
        }

        @Override
        public Object getItem(int position) {
            return values[position];
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;

            if (convertView == null) {
                view = LayoutInflater.from(context).inflate(R.layout.list_item, null);
            }
            else {
                view = convertView;
            }

            TextView textView = (TextView) view.findViewById(R.id.list_view_item);
            textView.setText(values[position]);
            return view;
        }
    }
}
