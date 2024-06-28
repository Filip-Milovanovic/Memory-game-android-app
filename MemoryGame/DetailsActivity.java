package Filip.Milovanovic.MemoryGame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {
    TextView userN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bundle = getIntent().getExtras();

        String username = bundle.getString("Username");
        ArrayList<String> scores = new ArrayList<>();
        scores = bundle.getStringArrayList("Scores");
        userN = findViewById(R.id.userNameDet);
        userN.setText(username);

        ListView lista = findViewById(R.id.listaDet);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        for(int i = 0; i < scores.size(); i++){
            adapter.add(scores.get(i));
        }

        lista.setAdapter(adapter);




    }


}