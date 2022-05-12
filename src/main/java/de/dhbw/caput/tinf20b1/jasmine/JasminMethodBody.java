package de.dhbw.caput.tinf20b1.jasmine;

import java.util.LinkedList;
import java.util.List;

public class JasminMethodBody {

	private final List<String> INSTRUCTIONS;
	
	JasminMethodBody( ){
		super( );
		INSTRUCTIONS = new LinkedList<>( );
	}
	
	public void appendLine( String line ){
		INSTRUCTIONS.add( line );
	}
	
	@Override
	public String toString( ){
		StringBuilder builder = new StringBuilder( );
		for( String instruction : INSTRUCTIONS ){
			builder.append( "  " );
			builder.append( instruction );
			builder.append( System.lineSeparator() );
		}
		return builder.toString();
	}
	
}
