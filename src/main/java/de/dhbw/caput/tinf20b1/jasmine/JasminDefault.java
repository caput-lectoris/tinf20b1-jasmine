package de.dhbw.caput.tinf20b1.jasmine;

public class JasminDefault {
	
	private final JasminClass CLASS;
	public final JasminMethodBody BODY;
	
	public JasminDefault( ){
		this( "GeneratedBytecode" );
	}
	
	public JasminDefault( String className ){
		JasminMethodSignature signature = new JasminMethodSignature(
				"main",
				"[Ljava/lang/String;" );
		JasminMethodDeclaration declaration = new JasminMethodDeclaration(
				signature,
				"V",
				JvmModifier.PUBLIC,
				JvmModifier.STATIC );
		BODY = new JasminMethodBody( );
		
		CLASS = new JasminClass( JvmModifier.PUBLIC, className );
		CLASS.addMethod( declaration, BODY );
	}
	
	@Override
	public String toString( ){
		return CLASS.toString( );
	}

}
