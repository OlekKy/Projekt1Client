package com.example.aleksander.projekt1;




import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by Aleksander on 21.11.2017.
 */

public class ApiCaller {
    //private static final String webserviceURI = "http://localhost:8080";

    public List<Field> getFields() throws ApiException {
        List<Field> fieldList = new ArrayList<Field>();

        InputStream is = null;
        String result = null;
        String line = null;
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://192.168.4.174:8080/field");
        HttpResponse response;
        try {
            response = client.execute(request);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();

          //  InputStream inputStream = response.getEntityInputStream();
           // String string = inputStream.toString();
            String s = response.toString();
            System.out.println(s);
            Log.d("Response of GET request", response.toString());
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            Log.e("log_tag", "Error in http connection "+e.toString());
            e.printStackTrace();
        }

  /*      Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://localhost:8080");

        Invocation.Builder invocationBuilder = employeeWebTarget.request(MediaType.APPLICATION.JSON);


        ClientResponse response = webResource.get(ClientResponse.class);
        if (response.getStatus() != 200) {
            throw new ApiException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        InputStream inputStream = response.getEntityInputStream();
        String string = inputStream.toString();
        System.out.println(string);
*/
    return fieldList;
    }
}
