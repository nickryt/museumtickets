/**
 * This class redirects users to the website of the museum page that was open prior to clicking the museums image button.
 * @author Christopher Clemente, Nick Rytelewski
 */

package com.example.pa5;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class Website extends AppCompatActivity {

    //XML Elements
    private WebView web_viewer;

    //Class Variables
    private String selection;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set Viewer's XML To 'website.xml' and assign items on screen to items defined in class
        setContentView(R.layout.website);
        web_viewer = findViewById(R.id.web_viewer);

        //Create a new intent in order to get the string passed in upon the creation of this class
        //String passed in defines the selection of the museum the user requested to be loaded
        Intent intent = getIntent();
        selection = intent.getStringExtra("SELECTED");

        //New Jersey State Museum
        if (selection.equals("NJSM")){
            web_viewer.loadUrl("https://www.state.nj.us/state/museum/");
        }
        //Neward Museum Of Art
        else if (selection.equals("NMOA")){
            web_viewer.loadUrl("https://www.newarkmuseumart.org/");
        }
        //Montclair Art Museum
        else if (selection.equals("MAM")){
            web_viewer.loadUrl("https://www.montclairartmuseum.org/");
        }
        //Liberty Science Center
        else if (selection.equals("LSC")){
            web_viewer.loadUrl("https://lsc.org/");
        }
        //Display a 404 page upon error. This state will not be able to reached unless a fatal error occurs.
        else{
            web_viewer.loadUrl("https://sitechecker.pro/wp-content/uploads/2017/12/404.png");
        }
    }

    @Override
    public void onBackPressed(){
        finish();
    }
}
