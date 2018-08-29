package najmul.bitm.sqlitedatabaseexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Trainer on 3/27/2017.
 */

public class MovieAdapter extends ArrayAdapter<Movie> {
    private Context context;
    private ArrayList<Movie>persons;
    public MovieAdapter(@NonNull Context context, ArrayList<Movie> persons) {
        super(context, R.layout.row_layout,persons);
        this.context = context;
        this.persons = persons;
    }


    class ViewHolder{
        TextView nameTV;
        TextView phoneTV;
        ImageView myImage;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.row_layout,parent,false);
            holder.nameTV = (TextView) convertView.findViewById(R.id.movieName);
            holder.phoneTV = (TextView) convertView.findViewById(R.id.movieYear);
            holder.myImage = (ImageView) convertView.findViewById(R.id.myImage);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }


        holder.nameTV.setText(persons.get(position).getMovieName());
        holder.phoneTV.setText(persons.get(position).getMovieYear());
        return convertView;
    }
}
