package Filip.Milovanovic.MemoryGame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PlayerDbHelper extends SQLiteOpenHelper {
    public final String TABLE_NAME = "player";
    public static final String COLUMN_ID = "ID";
    public static final String PLAYER_USERNAME = "Username";
    public static final String PLAYER_EMAIL = "Email";
    public static final String PLAYER_POINTS = "Points";

    private static int i = 0;

    public PlayerDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " TEXT, " + PLAYER_USERNAME + " TEXT, " + PLAYER_EMAIL + " TEXT, " + PLAYER_POINTS + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insert(Model m){
        SQLiteDatabase db = getWritableDatabase();
        String strI = String.valueOf(i);

        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, strI);
        values.put(PLAYER_USERNAME, m.getText11());
        values.put(PLAYER_EMAIL, m.getText12());
        values.put(PLAYER_POINTS, m.getText31());

        db.insert(TABLE_NAME, null, values);
        close();
    }

    public void delete(String username) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, PLAYER_USERNAME + " =?", new String[] {username});
        close();
    }

    public Model[] readPlayers(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);

        if(cursor.getCount() <= 0)
            return null;

        Model[] players = new Model[cursor.getCount()];
        int i = 0;
        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext())
            players[i++] = createPlayer(cursor);

        close();
        return players;
    }

    public Model getPlayer(String username){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, PLAYER_USERNAME + " =?", new String[]{username}, null,null,null,null);

        if(cursor.getCount() <= 0)
            return null;

        cursor.moveToFirst();

        Model player = createPlayer(cursor);

        close();
        return player;
    }

    private Model createPlayer(Cursor cursor){
        String Username = cursor.getString(cursor.getColumnIndexOrThrow(PLAYER_USERNAME));
        String Email = cursor.getString(cursor.getColumnIndexOrThrow(PLAYER_EMAIL));
        String ID = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ID));
        String Points = cursor.getString(cursor.getColumnIndexOrThrow(PLAYER_POINTS));

        return new Model(Username, Email, "Best", "Worst", Points, "5");

    }


}
