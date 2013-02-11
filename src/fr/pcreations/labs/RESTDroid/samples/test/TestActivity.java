package fr.pcreations.labs.RESTDroid.samples.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import fr.pcreations.labs.RESTDroid.core.RESTDroid;
import fr.pcreations.labs.RESTDroid.core.RESTRequest;
import fr.pcreations.labs.RESTDroid.core.RESTRequest.OnFailedRequestListener;
import fr.pcreations.labs.RESTDroid.core.RESTRequest.OnFinishedRequestListener;
import fr.pcreations.labs.RESTDroid.core.RESTRequest.OnStartedRequestListener;
import fr.pcreations.labs.RESTDroid.exceptions.RESTDroidNotInitializedException;
import fr.pcreations.labs.RESTDroid.samples.debug.R;

public class TestActivity extends Activity {

	private TestWebService ws;
	private RESTRequest<TestObject> getTestRequest;
	
	private OnStartedRequestListener onGetTestStart = new OnStartedRequestListener() {

		public void onStartedRequest() {
			Log.i(TestWebService.TAG, "getTestRequest has started");
		}
		
	};
	
	private OnFinishedRequestListener onGetTestFinish = new OnFinishedRequestListener() {

		public void onFinishedRequest(int resultCode) {
			Log.i(TestWebService.TAG, "getTestRequest has finished with code " + resultCode);
		}
		
	};
	
	private OnFailedRequestListener onGetTestFail = new OnFailedRequestListener() {
		
		public void onFailedRequest(int resultCode) {
			Log.i(TestWebService.TAG, "getTestRequest has failed with code " + resultCode);
		}
		
	};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RESTDroid.init(getApplicationContext());
        try {
			ws = (TestWebService) RESTDroid.getInstance().getWebService(TestWebService.class);
			ws.registerModule(new TestModule());
			getTestRequest = ws.newRequest(TestObject.class);
			getTestRequest.addOnStartedRequestListener(onGetTestStart);
			getTestRequest.addOnFinishedRequestListener(onGetTestFinish);
			getTestRequest.addOnFailedRequestListener(onGetTestFail);
			ws.getTest(getTestRequest, "mG2hB0Xvco");
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

}
