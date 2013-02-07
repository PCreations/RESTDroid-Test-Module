package fr.pcreations.labs.RESTDroid.samples.debug;

import fr.pcreations.labs.RESTDroid.core.DaoFactory;
import fr.pcreations.labs.RESTDroid.core.Module;
import fr.pcreations.labs.RESTDroid.core.ParserFactory;
import fr.pcreations.labs.RESTDroid.core.Processor;

public class DebugModule extends Module {

	@Override
	public Processor setProcessor() {
		return new DebugProcessor();
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
