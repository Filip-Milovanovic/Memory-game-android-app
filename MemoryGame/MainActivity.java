package Filip.Milovanovic.MemoryGame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{
    private Button LoginButton;
    private EditText userEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, GameActivity.class);

        LoginButton =(Button) findViewById(R.id.LoginBtn);
        userEdit = findViewById(R.id.UserEdit);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String userN = userEdit.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("Username", userN);
                intent.putExtras(bundle);
                startActivity(intent);


            }
        });
    }
//    public void openGameActivity(){
//        Intent intent = new Intent(this, GameActivity.class);
//        startActivity(intent);
//    }


}

