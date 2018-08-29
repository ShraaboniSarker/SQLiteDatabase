package najmul.bitm.sqlitedatabaseexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nameET;
    private EditText yearET;
    private Movie movie;
    private MovieDatabaseSource movieDatabaseSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameET = (EditText) findViewById(R.id.movieNameET);
        yearET = (EditText) findViewById(R.id.movieYearET);
        movieDatabaseSource = new MovieDatabaseSource(this);
    }

    public void addMovie(View view) {
        String name = nameET.getText().toString();
        String year = yearET.getText().toString();
        if(name.isEmpty()){
            nameET.setError("This field must not be empty");
        }else if(year.isEmpty()){
            yearET.setError("This field must not be empty");
        }else{
            movie = new Movie(name,year);
            boolean status = movieDatabaseSource.addMovie(movie);
            if(status){
                Toast.makeText(this, "Successfull", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,MovieListActivity.class));
            }else{
                Toast.makeText(this, "Could not save", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
