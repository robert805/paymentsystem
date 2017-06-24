package com.other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class RESTfull {

	

	public static void main(String[] args) throws Exception {


	

		

	}


	// HTTP POST request
	public boolean sendPost(String url, String status, String transaction_id) throws Exception {

	
		
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);

	
	
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("status", status));
		urlParameters.add(new BasicNameValuePair("transaction_id", transaction_id));
		HttpResponse response;
		post.setEntity(new UrlEncodedFormEntity(urlParameters));
		int statusCode = 1;
       try{
	  response=   client.execute(post);
	      
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + post.getEntity());
			System.out.println("Response Code : " +
	                                    response.getStatusLine().getStatusCode());

			BufferedReader rd = new BufferedReader(
	                        new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
statusCode = response.getStatusLine().getStatusCode();
			System.out.println(result.toString());
			 if(response.getStatusLine().getStatusCode() == 200){
		        	System.out.println("Udalo sie hahahaha");
		        }
	 
        }
        catch(ConnectException e){
        	System.out.println("Dupa z tego panie masz 404 not found i spadaj");
      }	
       
       if(statusCode == 200) return true;
       else  return false;
	}

}