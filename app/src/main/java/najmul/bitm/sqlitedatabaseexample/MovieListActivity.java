package najmul.bitm.sqlitedatabaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MovieListActivity extends AppCompatActivity {

    private ListView mListView;
    private MovieAdapter movieAdapter;
    private ArrayList<Movie>movies;
    private MovieDatabaseSource movieDatabaseSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        mListView = (ListView) findViewById(R.id.movieList);
        movieDatabaseSource = new MovieDatabaseSource(this);
        movies = movieDatabaseSource.getAllMovie();

        movieAdapter = new MovieAdapter(this, movies);
        mListView.setAdapter(movieAdapter);
    }
}
