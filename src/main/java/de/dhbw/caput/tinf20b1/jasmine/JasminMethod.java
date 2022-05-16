package de.dhbw.caput.tinf20b1.jasmine;

import java.util.Optional;

public class JasminMethod {
	
	private final JasminMethodDeclaration DECLARATION;
	public final JasminMethodBody BODY;
	private Optional<Integer> stackLimit, localsLimit;
	
	public JasminMethod( JasminMethodDeclaration declaration, JasminMethodBody body ){
		super( );
		DECLARATION = declaration;
		BODY = body;
		stackLimit = localsLimit = Optional.empty();
	}
	
	public void setStackLimit( int limit ){
		stackLimit = Optional.of( limit );
	}
	
	public void setLocalsLimit( int limit ){
		localsLimit = Optional.of( limit );
	}
	
	private String methodDeclaration( ){
		return String.format( ".method %s%n", DECLARATION );
	}
	
	private String limits( ){
		StringBuilder builder = new StringBuilder( );
		if( stackLimit.isPresent() ){
			builder.append( String.format("  .limit stack %d%n", stackLimit.get()) );
		}
		if( localsLimit.isPresent() ){
			builder.append( String.format("  .limit locals %d%n", localsLimit.get()) );
		}
		return builder.toString();
	}
	
	@Override
	public String toString( ){
		StringBuilder builder = new StringBuilder( );
		builder.append( methodDeclaration() );
		builder.append( limits() );
		builder.append( BODY );
		builder.append( ".end method" );
		builder.append( System.lineSeparator() );
		return builder.toString();
	}

}
