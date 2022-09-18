package com.ufc.quixada.app;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    //quest 01
    private ToggleButton toggleButton1;

    //quest 02
    private EditText eText;

    //quest 04
    AutoCompleteTextView autoCompleteTextView;
    String [] strings = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
    ArrayAdapter<String> adapter;

    //quest 05
    Spinner spinner;

    //quest o6
    RadioGroup radioGroup;
    RadioButton radioButton;

    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;

    MediaPlayer mySound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //quest 01
        toggleButton1 = findViewById(R.id.toggleButton1);
        Button btnState = findViewById(R.id.btnDisplay);
        btnState.setOnClickListener(view -> {
            String result = "toggleButton1 : " + toggleButton1.getText();
            Toast.makeText(getBaseContext(), result,
                    Toast.LENGTH_SHORT).show();
        });
        //quest 02
        eText = findViewById(R.id.edittext);
        @SuppressLint("CutPasteId") Button btnState2 = findViewById(R.id.button);
        btnState2.setOnClickListener(view -> {
                String str = eText.getText().toString();
                Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
        });

        //quest 03
        //int[] myArray = {1, 2, 3, 4, 5};
        //Log.v("Example", Arrays.toString(myArray));

        //quest 04
        autoCompleteTextView = findViewById(R.id.ac_text_view);
        Button btnState4 = findViewById(R.id.ac_button);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,strings);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(adapter);
        btnState4.setOnClickListener(view -> {
            String str = autoCompleteTextView.getText().toString();
            Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
        });

        //quest 05
        spinner = findViewById(R.id.spinner);
        Button btnState5 = findViewById(R.id.spinner_button);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        btnState5.setOnClickListener(view -> {
            String str = spinner.getSelectedItem().toString();
            Toast.makeText(getBaseContext(), str, Toast.LENGTH_SHORT).show();
        });

        //quest 06
        radioGroup= findViewById(R.id.radioGroup);
        Button btnState6 = findViewById(R.id.rb_button);
        btnState6.setOnClickListener(view -> {
            int radioId = radioGroup.getCheckedRadioButtonId();
            radioButton = findViewById(radioId);
            Toast.makeText(getBaseContext(), radioButton.getText(), Toast.LENGTH_SHORT).show();
        });

        //quest 10
        Button btnState7 = findViewById(R.id.long_press);
        registerForContextMenu(btnState7);

        autoCompleteTxt = findViewById(R.id.auto_complete_txt);

        adapterItems = new ArrayAdapter<>(this, R.layout.list_item, strings);

        autoCompleteTxt.setAdapter(adapterItems);

        autoCompleteTxt.setOnItemClickListener((parent, view, position, id) -> {
            String item = parent.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(), "Item: "+item,Toast.LENGTH_SHORT).show();
        });

        //quest 17
        mySound = MediaPlayer.create(this, R.raw.beep);


    }

    //quest 10
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose your option");
        getMenuInflater().inflate(R.menu.overflow_menu, menu);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_search:
                Toast.makeText(this, "Item Search Selected", Toast.LENGTH_LONG).show();
                break;
            case R.id.item_food:
                Toast.makeText(this, "Item Food Selected", Toast.LENGTH_LONG).show();
                break;
            case R.id.item_chinese:
                Toast.makeText(this, "Item Chinese Selected", Toast.LENGTH_LONG).show();
                break;
            case R.id.item_italian:
                Toast.makeText(this, "Item Italian Selected", Toast.LENGTH_LONG).show();
                break;
            case R.id.item_drinks:
                Toast.makeText(this, "Item Drinks Selected", Toast.LENGTH_LONG).show();
                break;
            case R.id.item_coffee:
                Toast.makeText(this, "Item Coffee Selected", Toast.LENGTH_LONG).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onContextItemSelected(item);
    }

    //quest 07
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.overflow_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_search:
                Toast.makeText(this, "Item Search Selected", Toast.LENGTH_LONG).show();
                break;
            case R.id.item_food:
                Toast.makeText(this, "Item Food Selected", Toast.LENGTH_LONG).show();
                break;
            case R.id.item_chinese:
                Toast.makeText(this, "Item Chinese Selected", Toast.LENGTH_LONG).show();
                break;
            case R.id.item_italian:
                Toast.makeText(this, "Item Italian Selected", Toast.LENGTH_LONG).show();
                break;
            case R.id.item_drinks:
                Toast.makeText(this, "Item Drinks Selected", Toast.LENGTH_LONG).show();
                break;
            case R.id.item_coffee:
                Toast.makeText(this, "Item Coffee Selected", Toast.LENGTH_LONG).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void showPopup(View V) {
        PopupMenu popup = new PopupMenu(this, V);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.overflow_menu);
        popup.show();
    }

    //quest 08
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_search:
                Toast.makeText(this, "Item Search Selected", Toast.LENGTH_LONG).show();
                break;
            case R.id.item_food:
                Toast.makeText(this,  "Item Food Selected", Toast.LENGTH_LONG).show();
                break;
            case R.id.item_chinese:
                Toast.makeText(this, "Item Chinese Selected", Toast.LENGTH_LONG).show();
                break;
            case R.id.item_italian:
                Toast.makeText(this, "Item Italian Selected", Toast.LENGTH_LONG).show();
                break;
            case R.id.item_drinks:
                Toast.makeText(this, "Item Drinks Selected", Toast.LENGTH_LONG).show();
                break;
            case R.id.item_coffee:
                Toast.makeText(this, "Item Coffee Selected", Toast.LENGTH_LONG).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    //quest 17
    public void playSound(View view) {
        Toast.makeText(this, "Play Sound", Toast.LENGTH_LONG).show();
        mySound.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        mySound.release();
    }
}