package de.dhbw.caput.tinf20b1.jasmine;

import java.util.LinkedList;
import java.util.List;

public class JasminClass {
	
	private final JvmModifier MODIFIER;
	private final String CLASS_NAME;
	private final String SUPERCLASS_NAME;
	private final List<JasminMethod> METHODS;
	
	public JasminClass( String className ){
		this( JvmModifier.DEFAULT, className );
	}
	
	public JasminClass( JvmModifier modifier, String className ){
		this( modifier, className, "java/lang/Object" );
	}
	
	public JasminClass( JvmModifier modifier, String className, String superclassName ){
		super( );
		MODIFIER = modifier;
		CLASS_NAME = className;
		SUPERCLASS_NAME = superclassName;
		METHODS = new LinkedList<>();
		createStandardInitializer( );
	}
	
	private void createStandardInitializer( ){
		JasminMethodSignature signature = new JasminMethodSignature( "<init>" );
		JasminMethodDeclaration declaration = new JasminMethodDeclaration(
				signature,
				"V",
				JvmModifier.PUBLIC );
		JasminMethodBody body = new JasminMethodBody( );
		body.appendLine( "aload_0" );
		body.appendLine( "invokenonvirtual java/lang/Object/<init>()V" );
		body.appendLine( "return" );
		addMethod( declaration, body );
	}
	
	JasminMethod addMethod( JasminMethodDeclaration declaration, JasminMethodBody body ){
		JasminMethod method = new JasminMethod( declaration, body );
		METHODS.add( method );
		return method;
	}
	
	private String classDeclaration( ){
		return String.format( ".class %s %s%n", MODIFIER, CLASS_NAME );
	}
	
	private String superclassDeclaration( ){
		return String.format( ".super %s%n", SUPERCLASS_NAME );
	}
	
	@Override
	public String toString( ){
		StringBuilder result = new StringBuilder( );
		result.append( classDeclaration() );
		result.append( superclassDeclaration() );
		for( JasminMethod jasminMethod : METHODS ){
			result.append( System.lineSeparator() );
			result.append( jasminMethod );
		}
		return result.toString();
	}

}
