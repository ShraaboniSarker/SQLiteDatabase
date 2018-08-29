package najmul.bitm.sqlitedatabaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Trainer on 3/29/2017.
 */

public class MovieDatabaseSource {
    private MovieDatabaseHelper movieDatabaseHelper;
    private SQLiteDatabase sqLiteDatabase;
    private Movie movie;

    public MovieDatabaseSource(Context context) {
        movieDatabaseHelper = new MovieDatabaseHelper(context);
    }

    public void open(){
        sqLiteDatabase = movieDatabaseHelper.getWritableDatabase();
    }
    public void close(){
        sqLiteDatabase.close();
    }

    public boolean addMovie(Movie movie){
        this.open();
        ContentValues values = new ContentValues();
        values.put(MovieDatabaseHelper.COL_NAME,movie.getMovieName());
        values.put(MovieDatabaseHelper.COL_YEAR,movie.getMovieYear());
        long id = sqLiteDatabase.insert(MovieDatabaseHelper.TABLE_MOVIE,null,values);
        this.close();
        if(id > 0){
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Movie> getAllMovie(){
        ArrayList<Movie>movies = new ArrayList<>();
        this.open();
        /*Cursor cursor = sqLiteDatabase.rawQuery("select * from "+MovieDatabaseHelper.TABLE_MOVIE,null);*/

        Cursor cursor = sqLiteDatabase.query(MovieDatabaseHelper.TABLE_MOVIE,null,null,null,null,null,null);
        cursor.moveToFirst();
        if(cursor != null && cursor.getCount() > 0){
            for(int i = 0; i < cursor.getCount(); i++){
                int id = cursor.getInt(cursor.getColumnIndex(MovieDatabaseHelper.COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(MovieDatabaseHelper.COL_NAME));
                String year = cursor.getString(cursor.getColumnIndex(MovieDatabaseHelper.COL_YEAR));
                movie = new Movie(name,year,id);
                movies.add(movie);
                cursor.moveToNext();
            }
        }
        cursor.close();
        this.close();
        return movies;

    }
}
