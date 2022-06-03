package sg.edu.rp.c346.id20042741.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etElement;
    EditText etPos;
    Button btnAdd;
    Button btnRemove;
    Button btnUpdate;
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
        etPos = findViewById(R.id.editTxtID2);
        btnAdd = findViewById(R.id.btnAdd);
        btnRemove = findViewById(R.id.btnRemove);
        btnUpdate = findViewById(R.id.btnUpdate);
        lvColour = findViewById(R.id.listViewColour);

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

                if(getETIndex.isEmpty() && getETColour.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter something in the field", Toast.LENGTH_SHORT).show();
                }
                else if(getETColour.isEmpty() && !getETIndex.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter something in the color field", Toast.LENGTH_SHORT).show();
                }
                else if(!getETColour.isEmpty() && getETIndex.isEmpty()){
                    alColours.add(getETColour);
                }
                else if(!getETColour.isEmpty() && !getETIndex.isEmpty()){
                    int toInt = Integer.parseInt(getETIndex);
                    alColours.add(toInt, getETColour);
                }

                aaColours.notifyDataSetChanged();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getETIndex = etPos.getText().toString();
                    if(!getETIndex.isEmpty()){

                        int toInt = Integer.parseInt(getETIndex);
                        Toast.makeText(MainActivity.this, String.format("%d \n %d",toInt, alColours.size()),Toast.LENGTH_SHORT).show();
                        if(toInt == alColours.size()-1 || toInt <= alColours.size()-1){
                            alColours.remove(toInt-1);
                            aaColours.notifyDataSetChanged();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "The position is empty", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Enter a valid position", Toast.LENGTH_SHORT).show();
                    }
                }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getETColour = etElement.getText().toString();
                getETIndex = etPos.getText().toString();
                if (!getETColour.isEmpty() && !getETIndex.isEmpty()) {
                    int toInt = Integer.parseInt(getETIndex);
                    alColours.set(toInt, getETColour);
                    aaColours.notifyDataSetChanged();
                }else{
                    Toast.makeText(MainActivity.this, "Fill in the colour and the index", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}