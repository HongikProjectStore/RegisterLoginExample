package com.example.registerloginexample;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class searchActivity extends AppCompatActivity {
    // 기본값을 설정,, 목록을 전역변수에 설정 . 기능 빠르게하려고... 나중에 변경
    private List<String> items = Arrays.asList("과자", "라면", "라볶이", "라라랜드", "커피");

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        SearchView searchView = findViewById(R.id.search_view);
        TextView resultTextView = findViewById(R.id.textView);
        resultTextView.setText(getResult());

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // text 검색창에 작성하고 눌렀을때 호출되는
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // 글자 입력할때마다 글자들이 newtext로 들어오는
                // 이벤트 처리 잘 했다고 하면 잘 했다고 알려야한다. return true;로 변경
                resultTextView.setText(search(newText));
                // 간단히 하려고 textview,, listview 나 recycler view 사용하게 될것
                return true;
            }
        });
    }

    private String search(String query){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<items.size(); i++) {
            String item = items.get(i);
            if (item.toLowerCase().contains(query.toLowerCase())) {
                sb.append(item);
                if (i != items.size() - 1) {
                    //마지막 인덱스가 아니면 "\n"붙인다.
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }


    private String getResult(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<items.size(); i++){
            String item = items.get(i);
            sb.append(item);
            if (i != items.size()-1){
                //마지막 인덱스가 아니면 "\n"붙인다.
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
