package sg.edu.rp.c346.id20042741.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etElement;
    EditText etPos;
    Button btnAdd;
    ListView lvColour;
    ArrayList<String> alColours;
    ArrayAdapter<String> aaColours;
    String getETColour;
    String getETIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTxtID);
        btnAdd = findViewById(R.id.btnAdd);
        lvColour = findViewById(R.id.listViewColour);
        etPos = findViewById(R.id.editTxtID2);

        alColours = new ArrayList<String>();
        alColours.add("Red");
        alColours.add("Orange");
        aaColours = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColours);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getETColour = etElement.getText().toString();
                getETIndex = etPos.getText().toString();
                alColours.add(Integer.parseInt(getETIndex), getETColour);
                aaColours.notifyDataSetChanged();

            }
        });
    }
}