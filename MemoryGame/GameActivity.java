package Filip.Milovanovic.MemoryGame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private Button gameButton11,gameButton12,gameButton13,gameButton14,gameButton21,gameButton22,gameButton23,gameButton24,gameButton31,gameButton32,gameButton33,gameButton34,gameButton41,gameButton42,gameButton43,gameButton44;
    private Button statisticsButton, startButton;
    private Button clicked1, clicked2;
    private boolean check = false, GameMode = false, gameOver = false;
    private ImageView openedImg1, openedImg2;
    private ImageView gameImg11,gameImg12,gameImg13,gameImg14,gameImg21,gameImg22,gameImg23,gameImg24,gameImg31,gameImg32,gameImg33,gameImg34,gameImg41,gameImg42,gameImg43,gameImg44;
    int cnt = 2, gameOverCnt = 0, score = 0;
    int arr1[] = {0,1,2,3,4,5,6,7};
    int arr2[] = {0,1,2,3,4,5,6,7};
    String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("Username");


        //Assinging images
        gameImg11 = findViewById(R.id.pic11);
        gameImg12 = findViewById(R.id.pic12);
        gameImg13 = findViewById(R.id.pic13);
        gameImg14 = findViewById(R.id.pic14);
        gameImg21 = findViewById(R.id.pic21);
        gameImg22 = findViewById(R.id.pic22);
        gameImg23 = findViewById(R.id.pic23);
        gameImg24 = findViewById(R.id.pic24);
        gameImg31 = findViewById(R.id.pic31);
        gameImg32 = findViewById(R.id.pic32);
        gameImg33 = findViewById(R.id.pic33);
        gameImg34 = findViewById(R.id.pic34);
        gameImg41 = findViewById(R.id.pic41);
        gameImg42 = findViewById(R.id.pic42);
        gameImg43 = findViewById(R.id.pic43);
        gameImg44 = findViewById(R.id.pic44);

        /////////////////////////////////////////////////////////////////////////////////////////
        //                                      RANDOMIZE                                      //
        /////////////////////////////////////////////////////////////////////////////////////////

        randomShuffle();

        //////////////////////////////////////////////////////////////////////////////////////////
        //**************************************************************************************//
        //////////////////////////////////////////////////////////////////////////////////////////




        //Assigning buttons
        gameButton11 = (Button) findViewById(R.id.gameBtn11);
        gameButton12 = (Button) findViewById(R.id.gameBtn12);
        gameButton13 = (Button) findViewById(R.id.gameBtn13);
        gameButton14 = (Button) findViewById(R.id.gameBtn14);
        gameButton21 = (Button) findViewById(R.id.gameBtn21);
        gameButton22 = (Button) findViewById(R.id.gameBtn22);
        gameButton23 = (Button) findViewById(R.id.gameBtn23);
        gameButton24 = (Button) findViewById(R.id.gameBtn24);
        gameButton31 = (Button) findViewById(R.id.gameBtn31);
        gameButton32 = (Button) findViewById(R.id.gameBtn32);
        gameButton33 = (Button) findViewById(R.id.gameBtn33);
        gameButton34 = (Button) findViewById(R.id.gameBtn34);
        gameButton41 = (Button) findViewById(R.id.gameBtn41);
        gameButton42 = (Button) findViewById(R.id.gameBtn42);
        gameButton43 = (Button) findViewById(R.id.gameBtn43);
        gameButton44 = (Button) findViewById(R.id.gameBtn44);



        statisticsButton = (Button) findViewById(R.id.buttonStatistics);
        startButton = (Button) findViewById(R.id.startButton);

        //Assigning colors to buttons
        startButton.setBackgroundColor(getColor(R.color.red));
        statisticsButton.setBackgroundColor(getColor(R.color.yellow));

        //OnClick listeners
        gameButton11.setOnClickListener(this);
        gameButton12.setOnClickListener(this);
        gameButton13.setOnClickListener(this);
        gameButton14.setOnClickListener(this);
        gameButton21.setOnClickListener(this);
        gameButton22.setOnClickListener(this);
        gameButton23.setOnClickListener(this);
        gameButton24.setOnClickListener(this);
        gameButton31.setOnClickListener(this);
        gameButton32.setOnClickListener(this);
        gameButton33.setOnClickListener(this);
        gameButton34.setOnClickListener(this);
        gameButton41.setOnClickListener(this);
        gameButton42.setOnClickListener(this);
        gameButton43.setOnClickListener(this);
        gameButton44.setOnClickListener(this);
        startButton.setOnClickListener(this);
        statisticsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.startButton:{
                //Changing appereance of buttons
                startButton.setText(R.string.restartBtn);
                startButton.setBackgroundColor(getColor(R.color.blue));

                //Reseting counter and starts the game
                if(!gameOver) {
                    cnt = 0;
                    GameMode = true;
                }

                //Compare images
                if(check && GameMode && !gameOver){
                    if(openedImg1.getTag().equals(openedImg2.getTag())){
                        clicked1.setVisibility(View.INVISIBLE);
                        clicked2.setVisibility(View.INVISIBLE);
                        gameOverCnt++;
                        score += 5;
                    } else{
                        clicked1.setVisibility(View.VISIBLE);
                        clicked2.setVisibility(View.VISIBLE);
                        score -= 1;
                    }
                }

                if(gameOverCnt == 8) {
                    gameOver = true;
                    GameMode = false;
                }

                if(gameOver){
                    gameButton11.setVisibility(View.VISIBLE);
                    gameButton12.setVisibility(View.VISIBLE);
                    gameButton13.setVisibility(View.VISIBLE);
                    gameButton14.setVisibility(View.VISIBLE);
                    gameButton21.setVisibility(View.VISIBLE);
                    gameButton22.setVisibility(View.VISIBLE);
                    gameButton23.setVisibility(View.VISIBLE);
                    gameButton24.setVisibility(View.VISIBLE);
                    gameButton31.setVisibility(View.VISIBLE);
                    gameButton32.setVisibility(View.VISIBLE);
                    gameButton33.setVisibility(View.VISIBLE);
                    gameButton34.setVisibility(View.VISIBLE);
                    gameButton41.setVisibility(View.VISIBLE);
                    gameButton42.setVisibility(View.VISIBLE);
                    gameButton43.setVisibility(View.VISIBLE);
                    gameButton44.setVisibility(View.VISIBLE);

                    startButton.setText(R.string.newGameText);
                    startButton.setBackgroundColor(getColor(R.color.purple_500));


                    cnt = 2;
                    score = 0;
                    gameOverCnt = 0;
                    check = false;
                    GameMode = true;
                    gameOver = false;

                    randomShuffle();
                }
                break;
            }
            case R.id.buttonStatistics:{
                openStatisticsActivity();
                break;
            }
            case R.id.gameBtn11:{
                if(cnt >= 2)
                    GameMode = false;

                if(GameMode) {
                    gameButton11.setVisibility(View.INVISIBLE);


                    //Check if they are same
                    if (cnt == 0) {
                        openedImg1 = findViewById(R.id.pic11);

                        clicked1 = findViewById(R.id.gameBtn11);
                    }

                    if (cnt == 1) {
                        openedImg2 = findViewById(R.id.pic11);

                        clicked2 = findViewById(R.id.gameBtn11);
                    }
                }

            if(GameMode) {
                if (cnt >= 1)
                    check = true;
                else
                    check = false;

                cnt++;
            }
                break;
            }
            case R.id.gameBtn12:{
                if(cnt >= 2)
                    GameMode = false;

                if(GameMode) {
                    gameButton12.setVisibility(View.INVISIBLE);


                    //Check if they are same
                    if (cnt == 0) {
                        openedImg1 = findViewById(R.id.pic12);

                        clicked1 = findViewById(R.id.gameBtn12);
                    }

                    if (cnt == 1) {
                        openedImg2 = findViewById(R.id.pic12);

                        clicked2 = findViewById(R.id.gameBtn12);
                    }
                }
                if(GameMode) {
                    if (cnt >= 1)
                        check = true;
                    else
                        check = false;

                    cnt++;
                }
                break;
            }
            case R.id.gameBtn13:{
                if(cnt >= 2)
                    GameMode = false;

                if(GameMode) {
                    gameButton13.setVisibility(View.INVISIBLE);


                    //Check if they are same
                    if (cnt == 0) {
                        openedImg1 = findViewById(R.id.pic13);

                        clicked1 = findViewById(R.id.gameBtn13);
                    }

                    if (cnt == 1) {
                        openedImg2 = findViewById(R.id.pic13);

                        clicked2 = findViewById(R.id.gameBtn13);
                    }
                }

                if(GameMode) {
                    if (cnt >= 1)
                        check = true;
                    else
                        check = false;

                    cnt++;
                }
                break;
            }
            case R.id.gameBtn14:{
                if(cnt >= 2)
                    GameMode = false;

                if(GameMode) {
                    gameButton14.setVisibility(View.INVISIBLE);


                    //Check if they are same
                    if (cnt == 0) {
                        openedImg1 = findViewById(R.id.pic14);

                        clicked1 = findViewById(R.id.gameBtn14);
                    }

                    if (cnt == 1) {
                        openedImg2 = findViewById(R.id.pic14);

                        clicked2 = findViewById(R.id.gameBtn14);
                    }
                }
                if(GameMode) {
                    if (cnt >= 1)
                        check = true;
                    else
                        check = false;

                    cnt++;
                }
                break;
            }
            case R.id.gameBtn21:{
                if(cnt >= 2)
                    GameMode = false;

                if(GameMode) {
                    gameButton21.setVisibility(View.INVISIBLE);


                    //Check if they are same
                    if (cnt == 0) {
                        openedImg1 = findViewById(R.id.pic21);

                        clicked1 = findViewById(R.id.gameBtn21);
                    }

                    if (cnt == 1) {
                        openedImg2 = findViewById(R.id.pic21);

                        clicked2 = findViewById(R.id.gameBtn21);
                    }
                }

                if(GameMode) {
                    if (cnt >= 1)
                        check = true;
                    else
                        check = false;

                    cnt++;
                }
                break;
            }
            case R.id.gameBtn22:{
                if(cnt >= 2)
                    GameMode = false;

                if(GameMode) {
                    gameButton22.setVisibility(View.INVISIBLE);


                    //Check if they are same
                    if (cnt == 0) {
                        openedImg1 = findViewById(R.id.pic22);

                        clicked1 = findViewById(R.id.gameBtn22);
                    }

                    if (cnt == 1) {
                        openedImg2 = findViewById(R.id.pic22);

                        clicked2 = findViewById(R.id.gameBtn22);
                    }
                }

                if(GameMode) {
                    if (cnt >= 1)
                        check = true;
                    else
                        check = false;

                    cnt++;
                }
                break;
            }
            case R.id.gameBtn23:{
                if(cnt >= 2)
                    GameMode = false;

                if(GameMode) {
                    gameButton23.setVisibility(View.INVISIBLE);


                    //Check if they are same
                    if (cnt == 0) {
                        openedImg1 = findViewById(R.id.pic23);

                        clicked1 = findViewById(R.id.gameBtn23);
                    }

                    if (cnt == 1) {
                        openedImg2 = findViewById(R.id.pic23);

                        clicked2 = findViewById(R.id.gameBtn23);
                    }
                }

                if(GameMode) {
                    if (cnt >= 1)
                        check = true;
                    else
                        check = false;

                    cnt++;
                }
                break;
            }
            case R.id.gameBtn24:{
                if(cnt >= 2)
                    GameMode = false;

                if(GameMode) {
                    gameButton24.setVisibility(View.INVISIBLE);


                    //Check if they are same
                    if (cnt == 0) {
                        openedImg1 = findViewById(R.id.pic24);

                        clicked1 = findViewById(R.id.gameBtn24);
                    }

                    if (cnt == 1) {
                        openedImg2 = findViewById(R.id.pic24);

                        clicked2 = findViewById(R.id.gameBtn24);
                    }
                }

                if(GameMode) {
                    if (cnt >= 1)
                        check = true;
                    else
                        check = false;

                    cnt++;
                }
                break;
            }
            case R.id.gameBtn31:{
                if(cnt >= 2)
                    GameMode = false;

                if(GameMode) {
                    gameButton31.setVisibility(View.INVISIBLE);


                    //Check if they are same
                    if (cnt == 0) {
                        openedImg1 = findViewById(R.id.pic31);

                        clicked1 = findViewById(R.id.gameBtn31);
                    }

                    if (cnt == 1) {
                        openedImg2 = findViewById(R.id.pic31);

                        clicked2 = findViewById(R.id.gameBtn31);
                    }
                }

                if(GameMode) {
                    if (cnt >= 1)
                        check = true;
                    else
                        check = false;

                    cnt++;
                }
                break;
            }
            case R.id.gameBtn32:{
                if(cnt >= 2)
                    GameMode = false;

                if(GameMode) {
                    gameButton32.setVisibility(View.INVISIBLE);


                    //Check if they are same
                    if (cnt == 0) {
                        openedImg1 = findViewById(R.id.pic32);

                        clicked1 = findViewById(R.id.gameBtn32);
                    }

                    if (cnt == 1) {
                        openedImg2 = findViewById(R.id.pic32);

                        clicked2 = findViewById(R.id.gameBtn32);
                    }
                }

                if(GameMode) {
                    if (cnt >= 1)
                        check = true;
                    else
                        check = false;

                    cnt++;
                }
                break;
            }
            case R.id.gameBtn33:{
                if(cnt >= 2)
                    GameMode = false;

                if(GameMode) {
                    gameButton33.setVisibility(View.INVISIBLE);


                    //Check if they are same
                    if (cnt == 0) {
                        openedImg1 = findViewById(R.id.pic33);

                        clicked1 = findViewById(R.id.gameBtn33);
                    }

                    if (cnt == 1) {
                        openedImg2 = findViewById(R.id.pic33);

                        clicked2 = findViewById(R.id.gameBtn33);
                    }
                }

                if(GameMode) {
                    if (cnt >= 1)
                        check = true;
                    else
                        check = false;

                    cnt++;
                }
                break;
            }
            case R.id.gameBtn34:{
                if(cnt >= 2)
                    GameMode = false;

                if(GameMode) {
                    gameButton34.setVisibility(View.INVISIBLE);


                    //Check if they are same
                    if (cnt == 0) {
                        openedImg1 = findViewById(R.id.pic34);

                        clicked1 = findViewById(R.id.gameBtn34);
                    }

                    if (cnt == 1) {
                        openedImg2 = findViewById(R.id.pic34);

                        clicked2 = findViewById(R.id.gameBtn34);
                    }
                }

                if(GameMode) {
                    if (cnt >= 1)
                        check = true;
                    else
                        check = false;

                    cnt++;
                }
                break;
            }
            case R.id.gameBtn41:{
                if(cnt >= 2)
                    GameMode = false;

                if(GameMode) {
                    gameButton41.setVisibility(View.INVISIBLE);


                    //Check if they are same
                    if (cnt == 0) {
                        openedImg1 = findViewById(R.id.pic41);

                        clicked1 = findViewById(R.id.gameBtn41);
                    }

                    if (cnt == 1) {
                        openedImg2 = findViewById(R.id.pic41);

                        clicked2 = findViewById(R.id.gameBtn41);
                    }
                }

                if(GameMode) {
                    if (cnt >= 1)
                        check = true;
                    else
                        check = false;

                    cnt++;
                }
                break;
            }
            case R.id.gameBtn42:{
                if(cnt >= 2)
                    GameMode = false;

                if(GameMode) {
                    gameButton42.setVisibility(View.INVISIBLE);


                    //Check if they are same
                    if (cnt == 0) {
                        openedImg1 = findViewById(R.id.pic42);

                        clicked1 = findViewById(R.id.gameBtn42);
                    }

                    if (cnt == 1) {
                        openedImg2 = findViewById(R.id.pic42);

                        clicked2 = findViewById(R.id.gameBtn42);
                    }
                }

                if(GameMode) {
                    if (cnt >= 1)
                        check = true;
                    else
                        check = false;

                    cnt++;
                }
                break;
            }
            case R.id.gameBtn43:{
                if(cnt >= 2)
                    GameMode = false;

                if(GameMode) {
                    gameButton43.setVisibility(View.INVISIBLE);


                    //Check if they are same
                    if (cnt == 0) {
                        openedImg1 = findViewById(R.id.pic43);

                        clicked1 = findViewById(R.id.gameBtn43);
                    }

                    if (cnt == 1) {
                        openedImg2 = findViewById(R.id.pic43);

                        clicked2 = findViewById(R.id.gameBtn43);
                    }
                }

                if(GameMode) {
                    if (cnt >= 1)
                        check = true;
                    else
                        check = false;

                    cnt++;
                }
                break;
            }
            case R.id.gameBtn44:{
                if(cnt >= 2)
                    GameMode = false;

                if(GameMode) {
                    gameButton44.setVisibility(View.INVISIBLE);


                    //Check if they are same
                    if (cnt == 0) {
                        openedImg1 = findViewById(R.id.pic44);

                        clicked1 = findViewById(R.id.gameBtn44);
                    }

                    if (cnt == 1) {
                        openedImg2 = findViewById(R.id.pic44);

                        clicked2 = findViewById(R.id.gameBtn44);
                    }
                }

                if(GameMode) {
                    if (cnt >= 1)
                        check = true;
                    else
                        check = false;

                    cnt++;
                }
                break;
            }

        }
    }

     public void openStatisticsActivity(){
        Intent intent = new Intent(this, StatisticsActivity.class);
        startActivity(intent);
    }

    public static void rand( int array[], int a)
    {
        // Creating object for Random class
        Random rd = new Random();

        // Starting from the last element and swapping one by one.
        for (int i = a-1; i > 0; i--) {

            // Pick a random index from 0 to i
            int j = rd.nextInt(i+1);

            // Swap array[i] with the element at random index
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

    }




    public void setImageFnc(ImageView img, int num){
        if(num == 0){
            img.setImageResource(R.drawable.img0);
            img.setTag("img0");}
        if(num == 1){
            img.setImageResource(R.drawable.img1);
            img.setTag("img1");}
        if(num == 2){
            img.setImageResource(R.drawable.img2);
            img.setTag("img2");}
        if(num == 3){
            img.setImageResource(R.drawable.img3);
            img.setTag("img3");}
        if(num == 4){
            img.setImageResource(R.drawable.img4);
            img.setTag("img4");}
        if(num == 5){
            img.setImageResource(R.drawable.img5);
            img.setTag("img5");}
        if(num == 6){
            img.setImageResource(R.drawable.img6);
            img.setTag("img6");}
        if(num == 7){
            img.setImageResource(R.drawable.img7);
            img.setTag("img7");}
    }

    public void randomShuffle(){
        int arrSize = arr1.length;
        rand(arr1, arrSize);
        rand(arr2, arrSize);

        //Setting randomized images
        setImageFnc(gameImg11, arr1[0]);
        setImageFnc(gameImg12, arr1[1]);
        setImageFnc(gameImg13, arr1[2]);
        setImageFnc(gameImg14, arr1[3]);
        setImageFnc(gameImg21, arr1[4]);
        setImageFnc(gameImg22, arr1[5]);
        setImageFnc(gameImg23, arr1[6]);
        setImageFnc(gameImg24, arr1[7]);
        setImageFnc(gameImg31, arr2[0]);
        setImageFnc(gameImg32, arr2[1]);
        setImageFnc(gameImg33, arr2[2]);
        setImageFnc(gameImg34, arr2[3]);
        setImageFnc(gameImg41, arr2[4]);
        setImageFnc(gameImg42, arr2[5]);
        setImageFnc(gameImg43, arr2[6]);
        setImageFnc(gameImg44, arr2[7]);
    }

}

