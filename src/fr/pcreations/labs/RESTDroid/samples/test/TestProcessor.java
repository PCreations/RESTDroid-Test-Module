package fr.pcreations.labs.RESTDroid.samples.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import android.util.Log;
import fr.pcreations.labs.RESTDroid.core.Processor;
import fr.pcreations.labs.RESTDroid.core.RESTRequest;
import fr.pcreations.labs.RESTDroid.core.ResourceRepresentation;
import fr.pcreations.labs.RESTDroid.exceptions.DaoFactoryNotInitializedException;

public class TestProcessor extends Processor {

	@Override
	protected void preRequestProcess(
			RESTRequest<ResourceRepresentation<?>> r)
			throws Exception {
		/* Parse.com Authentication headers */
		r.addHeader("Accept", "application/json");
		r.addHeader("Content-Type", "application/json");
		r.addHeader("X-Parse-Application-Id", TestWebService.APPLICATION_ID);
		r.addHeader("X-Parse-REST-API-Key", TestWebService.REST_API_KEY);
	}

	@Override
	protected void preGetRequest(
			RESTRequest<ResourceRepresentation<?>> r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void preDeleteRequest(
			RESTRequest<ResourceRepresentation<?>> r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected InputStream prePostRequest(
			RESTRequest<ResourceRepresentation<?>> r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected InputStream prePutRequest(
			RESTRequest<ResourceRepresentation<?>> r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int postRequestProcess(
			int statusCode, RESTRequest<ResourceRepresentation<?>> r, InputStream resultStream) {
		if(statusCode >= 200 && statusCode <= 210)
			Log.i(TestWebService.TAG, inputStreamToString(resultStream));
		else
			Log.i(TestWebService.TAG, "Error : status code = " + String.valueOf(statusCode));
		return statusCode;
	}
	
	private String inputStreamToString(InputStream is) {
        BufferedReader bufferedReader;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			StringBuilder inputStringBuilder = new StringBuilder();
	        String line;
			try {
				line = bufferedReader.readLine();
				while(line != null){
		            inputStringBuilder.append(line);inputStringBuilder.append('\n');
		            try {
						line = bufferedReader.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
				return inputStringBuilder.toString();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return null;
	}

}
