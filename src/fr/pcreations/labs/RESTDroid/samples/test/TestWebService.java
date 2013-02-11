package fr.pcreations.labs.RESTDroid.samples.test;

import android.content.Context;
import fr.pcreations.labs.RESTDroid.core.RESTRequest;
import fr.pcreations.labs.RESTDroid.core.WebService;

public class TestWebService extends WebService {

	public static final String APPLICATION_ID = "wHE988z9K8XjMfWc3ZutaAmJu3UnLCUNpuDJPwge";
	public static final String REST_API_KEY = "Fz5u00Ppw8uX3nJcSBOxqzWUE0qsWwjJTZyc2VYA";
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
