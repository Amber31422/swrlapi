package org.swrlapi.core.arguments.impl;

import org.semanticweb.owlapi.model.IRI;
import org.swrlapi.core.arguments.SWRLBuiltInArgument;
import org.swrlapi.core.arguments.SWRLMultiValueVariableBuiltInArgument;
import org.swrlapi.core.arguments.SWRLVariableBuiltInArgument;

import uk.ac.manchester.cs.owl.owlapi.SWRLVariableImpl;

class SWRLVariableBuiltInArgumentImpl extends SWRLVariableImpl implements SWRLVariableBuiltInArgument
{
	private static final long serialVersionUID = 1L;

	private final String variableShortName;

	// There is an equals methods defined for this class.
	private SWRLBuiltInArgument builtInResult; // Used to store result of binding for unbound arguments
	boolean isBound;

	public SWRLVariableBuiltInArgumentImpl(IRI iri, String variableShortName)
	{
		super(iri);
		this.builtInResult = null;
		this.isBound = true;
		this.variableShortName = variableShortName;
	}

	@Override
	public boolean isVariable()
	{
		return true;
	}

	@Override
	public boolean isMultiValueVariable()
	{
		return false;
	}

	@Override
	public SWRLVariableBuiltInArgument asVariable()
	{
		return this;
	}

	@Override
	public SWRLMultiValueVariableBuiltInArgument asMultiValueVariable()
	{
		throw new RuntimeException("not a SWRLMultiVariableBuiltInArgument");
	}

	@Override
	public String getVariableShortName()
	{
		return variableShortName;
	}

	@Override
	public void setBuiltInResult(SWRLBuiltInArgument builtInResult)
	{
		if (!isUnbound())
			throw new RuntimeException("attempt to bind value to bound argument " + this.toString());

		setBound();

		this.builtInResult = builtInResult;
	}

	@Override
	public SWRLBuiltInArgument getBuiltInResult()
	{
		// TODO this should probably throw TargetRuleEngineExceptiion
		// if (!isUnbound()) throw new BuiltInException("attempt to retrieve binding from a non bound argument " +
		// this.toString());

		return this.builtInResult;
	}

	@Override
	public boolean hasBuiltInResult()
	{
		return this.builtInResult != null;
	}

	@Override
	public boolean isUnbound()
	{
		return !this.isBound;
	}

	@Override
	public boolean isBound()
	{
		return this.isBound;
	}

	@Override
	public void setUnbound()
	{
		this.isBound = false;
	}

	@Override
	public void setBound()
	{
		this.isBound = true;
	}

	@Override
	public String toDisplayText()
	{
		if (this.builtInResult != null)
			return this.builtInResult.toString();
		else
			return "?" + getVariableShortName();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if ((obj == null) || (obj.getClass() != this.getClass()))
			return false;
		SWRLVariableBuiltInArgumentImpl impl = (SWRLVariableBuiltInArgumentImpl)obj;
		return super.equals(impl)
				&& ((this.builtInResult == impl.builtInResult) || (this.builtInResult != null && this.builtInResult
						.equals(impl.builtInResult)) && this.isBound == impl.isBound);
	}

	@Override
	public int hashCode()
	{
		int hash = 78;
		hash = hash + (null == this.builtInResult ? 0 : this.builtInResult.hashCode());
		hash = hash + (this.isBound ? 1 : 0);
		return hash;
	}
}
