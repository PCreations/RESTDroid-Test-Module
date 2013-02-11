package fr.pcreations.labs.RESTDroid.samples.test;

import android.content.Context;
import fr.pcreations.labs.RESTDroid.core.RESTRequest;
import fr.pcreations.labs.RESTDroid.core.WebService;

public class TestWebService extends WebService {

	public static final String APPLICATION_ID = "your_application_id";
	public static final String REST_API_KEY = "your_rest_api_key";
	public static final String TAG = "fr.pcreations.labs.RESTDROID.sample.DebugWebService.TAG";
	
	private static final String BASE_URI = "https://api.parse.com/1/classes/";
	private static final String TEST_OBJECT = "Test/";
	
	/* Must override this constructor for dynamic instanciation */
	public TestWebService(Context context) {
		super(context);
	}
	
	public void getTest(RESTRequest<TestObject> r, String id) {
		get(r, BASE_URI + TEST_OBJECT + id);
	}

}
