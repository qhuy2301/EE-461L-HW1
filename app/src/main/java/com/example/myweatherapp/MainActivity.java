package com.example.myweatherapp;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String geoKey="AizaSyCNjow_bPK8VWqXv2_eFVccJPXtZT_2qPI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getLocation(View view){
        String placeName;
        EditText inputBox = (EditText)
                findViewById(R.id.inputText);
       String input=inputBox.getText().toString();
       String urlInput=input.replace(" ","+");
       String url="https://maps.googleapis.com/maps/api/geocode/json?address="+urlInput+"&key="+geoKey;
        System.out.println(url);
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readValue(new URL(url), JsonNode.class);
            System.out.println(node);
           // JsonNode object=node.get(1);
            String longitude=node.get("geometry").get("location").get("longitude").textValue();
            String latitude=node.get("geometry").get("location").get("latitude").textValue();
            System.out.println(longitude+" "+latitude);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
