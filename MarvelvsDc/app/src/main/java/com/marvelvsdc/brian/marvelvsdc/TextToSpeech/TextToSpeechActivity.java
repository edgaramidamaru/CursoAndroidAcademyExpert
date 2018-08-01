package com.marvelvsdc.brian.marvelvsdc.TextToSpeech;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.marvelvsdc.brian.marvelvsdc.R;

import java.util.ArrayList;
import java.util.Locale;

public class TextToSpeechActivity extends AppCompatActivity  implements TextToSpeech.OnInitListener{


    private TextToSpeech textToSpeech;
    private EditText editText;
    private TextView txtSearch;
    private static final int VOICE_RECOGNITION_REQUEST_CODE = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        final Button btnSpanish = (Button) findViewById( R.id.btnSpanish );
        final Button btnEnglish = ( Button ) findViewById( R.id.btnEnglish );
        final Button btnVoz = findViewById(R.id.btn_voz);

        txtSearch = findViewById(R.id.txt_search);
        textToSpeech = new TextToSpeech( this, this );
        editText = ( EditText ) findViewById( R.id.editTextWords );

        btnSpanish.setOnClickListener( new View.OnClickListener()
        {
            @Override public void onClick( View v )
            {
                textToSpeech.setLanguage( new Locale( "spa", "ESP" ) );
                speak( editText.getText().toString() );
            }
        } );

        btnEnglish.setOnClickListener( new View.OnClickListener()
        {
            @Override public void onClick( View v )
            {
                textToSpeech.setLanguage( Locale.ENGLISH );
                speak( editText.getText().toString() );
            }
        } );
        btnVoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "");
                startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
            }
        });
    }


    @Override
    public void onInit( int status )
    {
        if ( status == TextToSpeech.LANG_MISSING_DATA | status == TextToSpeech.LANG_NOT_SUPPORTED )
        {
            Toast.makeText( this, "ERROR LANG_MISSING_DATA | LANG_NOT_SUPPORTED", Toast.LENGTH_SHORT ).show();
        }
    }

    private void speak( String str )
    {
        textToSpeech.speak( str, TextToSpeech.QUEUE_FLUSH, null );
        textToSpeech.setSpeechRate( 0.0f );
        textToSpeech.setPitch( 0.0f );
    }

    @Override
    protected void onDestroy()
    {
        if ( textToSpeech != null )
        {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == VOICE_RECOGNITION_REQUEST_CODE && resultCode ==
                RESULT_OK) {
            ArrayList<String> matches =
                    data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            final CharSequence[] items = new CharSequence[matches.size()];
            for(int i = 0; i < matches.size(); i++){
                items[i] = matches.get(i);
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Resutado Seleccionado");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    txtSearch.setText(items[item].toString());
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
        super.onActivityResult(requestCode, resultCode, data);

    } 
}
