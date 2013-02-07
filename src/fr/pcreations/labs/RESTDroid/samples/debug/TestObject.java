package fr.pcreations.labs.RESTDroid.samples.debug;

import java.util.Date;

import fr.pcreations.labs.RESTDroid.core.ResourceRepresentation;

public class TestObject implements ResourceRepresentation<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2958835534649642979L;
	
	private String mId;
	private String mContent;
	private String mTitle;
	private Date mCreatedAt;
	private Date mUpdatedAt;
	
	public TestObject(String mId, String mContent, String mTitle,
			Date mCreatedAt, Date mUpdatedAt) {
		super();
		this.mId = mId;
		this.mContent = mContent;
		this.mTitle = mTitle;
		this.mCreatedAt = mCreatedAt;
		this.mUpdatedAt = mUpdatedAt;
	}

	public String getId() {
		return mId;
	}

	public int getState() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getResultCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean getTransactingFlag() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setId(String id) {
		mId = id;
	}

	public void setState(int stateRetrieving) {
		// TODO Auto-generated method stub
		
	}

	public void setTransactingFlag(boolean transacting) {
		// TODO Auto-generated method stub
		
	}

	public void setResultCode(int resultCode) {
		// TODO Auto-generated method stub
		
	}

	public String getmContent() {
		return mContent;
	}

	public String getmTitle() {
		return mTitle;
	}

	public Date getmCreatedAt() {
		return mCreatedAt;
	}

	public Date getmUpdatedAt() {
		return mUpdatedAt;
	}

	public void setmContent(String mContent) {
		this.mContent = mContent;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public void setmCreatedAt(Date mCreatedAt) {
		this.mCreatedAt = mCreatedAt;
	}

	public void setmUpdatedAt(Date mUpdatedAt) {
		this.mUpdatedAt = mUpdatedAt;
	}

	
	
}
