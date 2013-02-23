package fr.pcreations.labs.RESTDroid.samples.test;

import fr.pcreations.labs.RESTDroid.core.Module;
import fr.pcreations.labs.RESTDroid.core.ParserFactory;
import fr.pcreations.labs.RESTDroid.core.PersistableFactory;
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
	public PersistableFactory setPersistableFactory() {
		return null;
	}

}
