package fr.pcreations.labs.RESTDroid.samples.debug;

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

public class DebugProcessor extends Processor {

	@Override
	protected void preRequestProcess(
			RESTRequest<? extends ResourceRepresentation<?>> r)
			throws Exception {
		/* Parse.com Authentication headers */
		r.addHeader("X-Parse-Application-Id", DebugWebService.APPLICATION_ID);
		r.addHeader("X-Parse-REST-API-Key", DebugWebService.REST_API_KEY);
	}

	@Override
	protected void preGetRequest(
			RESTRequest<? extends ResourceRepresentation<?>> r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void preDeleteRequest(
			RESTRequest<? extends ResourceRepresentation<?>> r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected InputStream prePostRequest(
			RESTRequest<? extends ResourceRepresentation<?>> r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected InputStream prePutRequest(
			RESTRequest<? extends ResourceRepresentation<?>> r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected <T extends ResourceRepresentation<?>> int postRequestProcess(
			int statusCode, RESTRequest<T> r, InputStream resultStream) {
		Log.i(DebugWebService.TAG, inputStreamToString(resultStream));
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
