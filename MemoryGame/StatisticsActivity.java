package Filip.Milovanovic.MemoryGame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class StatisticsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        adapter = new MyAdapter(this);
        ListView lista = findViewById(R.id.lista);
        lista.setAdapter(adapter);

        adapter.addElement(new Model("Filip","filip@gmail","Best","Worst","41","7"));
        adapter.addElement(new Model("Filip","filip@gmail","Best","Worst","23","7"));
        adapter.addElement(new Model("Filip","filip@gmail","Best","Worst","68","7"));

        adapter.addElement(new Model("Marko","marko1@yahoo","Best","Worst","32","2"));
        adapter.addElement(new Model("Marko","marko1@yahoo","Best","Worst","31","2"));
        adapter.addElement(new Model("Marko","marko1@yahoo","Best","Worst","28","2"));

        adapter.addElement(new Model("Milos","misoo@milos","Best","Worst","21","1"));
        adapter.addElement(new Model("Milos","misoo@milos","Best","Worst","19","1"));
        adapter.addElement(new Model("Milos","misoo@milos","Best","Worst","12","1"));

        adapter.addElement(new Model("Veljko","velje19@yahoo","Best","Worst","20","5"));


        lista.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this,DetailsActivity.class);
        final String name = adapter.getElementUserNameById(i);
//        final String bestScore = adapter.getBestResult(name, i);
        final ArrayList<String> scores = adapter.getResults(name);




        Bundle bundle = new Bundle();
        bundle.putString("Username", name);
//        bundle.putString("Score", bestScore);
        bundle.putStringArrayList("Scores", scores);
        intent.putExtras(bundle);
        startActivity(intent);
    }




}

