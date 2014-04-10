package org.swrlapi.core.arguments;

import org.semanticweb.owlapi.model.SWRLVariable;

/**
 * Represents a variable argument to a SWRL built-in atom.
 */
public interface SWRLVariableBuiltInArgument extends SWRLBuiltInArgument, SWRLVariable
{
	String getVariableShortName();

	@Override
	boolean isVariable();

	boolean hasBuiltInResult();

	SWRLBuiltInArgument getBuiltInResult();

	void setBuiltInResult(SWRLBuiltInArgument builtInResult);

	boolean isUnbound();

	boolean isBound();

	void setUnbound();

	void setBound();
}
