package com.mrybka.java;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class ListLectureActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lecture);
        ButterKnife.bind(this);
        listView.setAdapter(new ListAdapter());
    }

    @OnItemClick(R.id.listView)
    public void openPdf(int position) {
        Intent intent = new Intent(this, SlideActivity.class);
        intent.putExtra(SlideActivity.LECTURE, Utils.LECTURES[position]);//przekazanie wartości przez intent
        startActivity(intent);// odpalenie aktywności z odpowiednim pdfem
    }

    public class ListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Utils.LECTURES.length;
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
            ((TextView) rowView.findViewById(R.id.text)).setText(Utils.LECTURES_NAMES[i]);
            return rowView;
        }
    }
}
