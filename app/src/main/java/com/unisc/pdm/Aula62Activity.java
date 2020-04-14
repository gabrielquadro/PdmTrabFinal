package com.unisc.pdm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class Aula62Activity extends AppCompatActivity {

    private Spinner spinner;

    String [] languages = {"Selecione uma linguagem","C# language","HTML language","PhP language", "XML language"};
    int [] imagens  = { 0, R.drawable.csharp, R.drawable.html, R.drawable.php, R.drawable.xml};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula62);

        spinner = findViewById(R.id.spinner);

        spinner.setAdapter(new MyAdapter(this, R.layout.spinner_item, languages));


    }

    class MyAdapter extends ArrayAdapter {

        public MyAdapter(Context context, int resorces, String[] array) {
            super(context, resorces, array);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return  getCustomView(position, convertView, parent);
        }

        @Override
        public View getDropDownView(int position, View view, ViewGroup viewGroup) {
             return  getCustomView(position, view, viewGroup);
        }

        private View getCustomView(int position, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.spinner_item,viewGroup,false);

            TextView tv = layout.findViewById(R.id.conteudo);
            tv.setText(languages[position]);

            ImageView img = layout.findViewById(R.id.imageView);
            img.setImageResource(imagens[position]);

            if (position == 0) {
                img.setVisibility(View.GONE);
                tv.setTextSize(20f);
                tv.setTextColor(Color.RED);
            }
            return layout;
        }

    }
}
