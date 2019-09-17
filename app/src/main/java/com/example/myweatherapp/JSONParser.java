package com.example.myweatherapp;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


static InputStream input = null;
    static JSONObject jobj = null;
    static String json = "";
    public JSONParser() {
    }

    public JSONObject getJSONFromUrl(String url) {

        try {
            DefaultHttpClient req = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            HttpResponse res = req.execute(httpPost);
            HttpEntity entity = res.getEntity();
            input = entity.getContent();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(
                    input, "iso-8859-1"), 8);
            StringBuilder builderonj = new StringBuilder();
            String line = null;

            while ((line = read.readLine()) != null) {
                builderonj.append(line + "\n");
            }
            input.close();
            json = builderonj.toString();
        } catch (Exception e) {
            Log.e("Buffer Reader", "Error...... " + e.toString());
        }

        try {
            jobj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("Parser", "Error while parsing... " + e.toString());
        }

        return jobj;
    }

}



}
