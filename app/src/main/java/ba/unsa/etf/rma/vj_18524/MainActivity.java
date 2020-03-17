package ba.unsa.etf.rma.vj_18524;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;
    private ListView listView;
    private ArrayList<Movie> entries;
    private ArrayAdapter<Movie> adapter;
    private MovieListAdapter movieListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
        listView = (ListView) findViewById(R.id.listView);

        entries = MoviesModel.getInstance().getMovies();
        adapter = new MovieListAdapter(this, R.layout.list_element, entries);

        listView.setAdapter(adapter);

        /*button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                entries.add(0,editText.getText().toString());
                adapter.notifyDataSetChanged();
                editText.setText("");
            }
        });*/
        listView.setOnItemClickListener(listItemClickListener);

    }

    private AdapterView.OnItemClickListener listItemClickListener =
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    Intent movieDetailIntent = new Intent(MainActivity.this,
                            MovieDetailActivity.class);
                    Movie movie = movieListAdapter.getMovie(position);
                    movieDetailIntent.putExtra("title", movie.getTitle());
                    MainActivity.this.startActivity(movieDetailIntent);
                }
            };
}
