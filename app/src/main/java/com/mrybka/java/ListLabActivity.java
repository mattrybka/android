package com.mrybka.java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class ListLabActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lab);
        ButterKnife.bind(this);
        listView.setAdapter(new ListAdapter());
    }

    @OnItemClick(R.id.listView)
    public void openPdf(int position) {
        Intent intent = new Intent(this, LabActivity.class);
        intent.putExtra(LabActivity.LAB, Utils.LABS[position]);
        startActivity(intent);
    }

    public class ListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Utils.LABS.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = getLayoutInflater();
            View rowView = inflater.inflate(R.layout.list_lab_item, null, true);
            ((TextView) rowView.findViewById(R.id.text)).setText(Utils.LABS_NAMES[i]);
            return rowView;
        }
    }
}
