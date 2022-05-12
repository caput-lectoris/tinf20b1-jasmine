package de.dhbw.caput.tinf20b1.jasmine;

public class JasminMethodDeclaration {

	private final JvmModifier[] MODIFIERS;
	private final JasminMethodSignature SIGNATURE;
	private final String RETURN_TYPE;
	
	public JasminMethodDeclaration( JasminMethodSignature signature, String returnType, JvmModifier... modifiers ){
		super( );
		MODIFIERS = modifiers;
		RETURN_TYPE = returnType;
		SIGNATURE = signature;
	}
	
	@Override
	public String toString( ){
		StringBuilder builder = new StringBuilder( );
		for( JvmModifier modifier : MODIFIERS ){
			builder.append( modifier + " " );
		}
		builder.append( SIGNATURE );
		builder.append( RETURN_TYPE );
		return builder.toString();
	}
	
}
