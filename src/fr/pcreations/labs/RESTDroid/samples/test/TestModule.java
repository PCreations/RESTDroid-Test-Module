package fr.pcreations.labs.RESTDroid.samples.test;

import fr.pcreations.labs.RESTDroid.core.DaoFactory;
import fr.pcreations.labs.RESTDroid.core.Module;
import fr.pcreations.labs.RESTDroid.core.ParserFactory;
import fr.pcreations.labs.RESTDroid.core.Processor;

public class TestModule extends Module {

	@Override
	public Processor setProcessor() {
		return new TestProcessor();
	}

	@Override
	public ParserFactory setParserFactory() {
		return null;
	}

	@Override
	public DaoFactory setDaoFactory() {
		return null;
	}

}
