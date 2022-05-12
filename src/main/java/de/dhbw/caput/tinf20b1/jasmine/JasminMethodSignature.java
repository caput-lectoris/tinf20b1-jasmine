package de.dhbw.caput.tinf20b1.jasmine;

public class JasminMethodSignature {
	
	private final String METHOD_NAME;
	private final String[] PARAMETER_TYPES;
	
	public JasminMethodSignature( String methodName, String... parameterTypes ){
		super( );
		METHOD_NAME = methodName;
		PARAMETER_TYPES = parameterTypes;
	}
	
	@Override
	public String toString( ){
		StringBuilder builder = new StringBuilder( );
		builder.append( METHOD_NAME );
		builder.append( "(" );
		for( String parameter : PARAMETER_TYPES ){
			builder.append( parameter );
		}
		builder.append( ")" );
		return builder.toString();
	}

}
