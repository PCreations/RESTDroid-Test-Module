package fr.pcreations.labs.RESTDroid.samples.debug;

import android.app.Activity;
import android.os.Bundle;
import fr.pcreations.labs.RESTDroid.core.RESTDroid;
import fr.pcreations.labs.RESTDroid.core.RESTRequest;
import fr.pcreations.labs.RESTDroid.exceptions.RESTDroidNotInitializedException;

public class MainActivity extends Activity {

	private DebugWebService ws;
	private RESTRequest<TestObject> getTestRequest;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RESTDroid.init(getApplicationContext());
        try {
			ws = (DebugWebService) RESTDroid.getInstance().getWebService(DebugWebService.class);
			//ws.registerModule(new DebugModule());
			getTestRequest = ws.newRequest(TestObject.class);
			ws.getTest(getTestRequest, "mG2hB0Xvco");
		} catch (RESTDroidNotInitializedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        setContentView(R.layout.activity_main);
       
    }

}
