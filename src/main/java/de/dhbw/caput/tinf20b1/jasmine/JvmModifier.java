package de.dhbw.caput.tinf20b1.jasmine;

public enum JvmModifier {

	DEFAULT(""), PRIVATE("private"), PROTECTED("protected"), PUBLIC("public"), STATIC("static");
	
	private final String LABEL;
	
	private JvmModifier( String label ){
		LABEL = label;
	}
	
	@Override
	public String toString( ){
		return LABEL;
	}
	
}
