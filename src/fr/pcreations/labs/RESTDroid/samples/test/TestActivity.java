package fr.pcreations.labs.RESTDroid.samples.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import fr.pcreations.labs.RESTDroid.core.RESTDroid;
import fr.pcreations.labs.RESTDroid.core.RESTRequest;
import fr.pcreations.labs.RESTDroid.core.RequestListeners;
import fr.pcreations.labs.RESTDroid.exceptions.RESTDroidNotInitializedException;
import fr.pcreations.labs.RESTDroid.samples.debug.R;

public class TestActivity extends Activity {

	
	private TestWebService ws;
	
	private RESTRequest<TestObject> getTestRequest;
	
	public static final String GET_TEST_REQUEST_ID = "get_test_request_id";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RESTDroid.init(getApplicationContext());
        try {
			ws = (TestWebService) RESTDroid.getInstance().getWebService(TestWebService.class);
			ws.registerModule(new TestModule());
			getTestRequest = ws.getTest(TestObject.class, "mG2hB0Xvco");
			getTestRequest.setRequestListeners(new TestRequestListeners());
			ws.executeRequest(getTestRequest);
		} catch (RESTDroidNotInitializedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        setContentView(R.layout.activity_main);
    }
    
    @Override
    public void onPause() {
    	super.onPause();
    	ws.onPause();
    }
    
    @Override
    public void onResume() {
    	super.onResume();
    	ws.onResume();
    }
    
    public class TestRequestListeners extends RequestListeners {
    	private OnStartedRequestListener onStart = new OnStartedRequestListener() {

    		public void onStartedRequest() {
    			Log.i(TestWebService.TAG, "getTestRequest has started");
    		}
    		
    	};
    	
    	private OnFinishedRequestListener onFinished = new OnFinishedRequestListener() {

    		public void onFinishedRequest(int resultCode) {
    			Log.i(TestWebService.TAG, "getTestRequest has finished with code " + resultCode);
    		}
    		
    	};
    	
    	private OnFailedRequestListener onFailed = new OnFailedRequestListener() {
    		
    		public void onFailedRequest(int resultCode) {
    			Log.i(TestWebService.TAG, "getTestRequest has failed with code " + resultCode);
    		}
    		
    	};
    	
    	public TestRequestListeners() {
    		super();
    		addOnStartedRequestListener(onStart);
    		addOnFinishedRequestListener(onFinished);
    		addOnFailedRequestListener(onFailed);
    	}
    }

}
