package org.swrlapi.core;

import checkers.nullness.quals.NonNull;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.SWRLVariable;
import org.swrlapi.builtins.arguments.SWRLClassBuiltInArgument;
import org.swrlapi.builtins.arguments.SWRLDataPropertyBuiltInArgument;
import org.swrlapi.builtins.arguments.SWRLNamedIndividualBuiltInArgument;
import org.swrlapi.builtins.arguments.SWRLObjectPropertyBuiltInArgument;

/**
 * For simplicity, SWRL rule engine implementations will typically use the prefixed names of OWL named objects to name
 * their representation of those objects. A {@link org.swrlapi.core.SWRLAPIOntologyProcessor} will recordOWLClassExpression all the OWL
 * named objects in an ontology together with their types. Rule engines can then use this class to determine the type of
 * OWL properties using their prefixed name and to map those prefixed names to and from IRIs if necessary.
 *
 * @see org.swrlapi.core.SWRLAPIOntologyProcessor
 */
public interface IRIResolver
{
  void reset();

  /**
   * @param iri An IRI
   * @return The prefixed form of the IRI
   * @throws IllegalArgumentException If the IRI cannot be resolved to a prefixed name
   */
  @NonNull String iri2PrefixedName(@NonNull IRI iri);

  /**
   * @param prefixedName A prefixed name
   * @return The IRI resolved from the prefixed name
   * @throws IllegalArgumentException If the prefixed name cannot be resolved
   */
  @NonNull IRI prefixedName2IRI(@NonNull String prefixedName);

  void recordSWRLVariable(@NonNull SWRLVariable variable);

  void recordOWLClass(@NonNull OWLEntity cls);

  void recordOWLNamedIndividual(@NonNull OWLEntity individual);

  void recordOWLObjectProperty(@NonNull OWLEntity property);

  void recordOWLDataProperty(@NonNull OWLEntity property);

  void recordOWLAnnotationProperty(@NonNull OWLEntity property);

  void recordOWLDatatype(@NonNull OWLEntity datatype);

  void recordOWLClass(@NonNull SWRLClassBuiltInArgument classArgument);

  void recordOWLIndividual(@NonNull SWRLNamedIndividualBuiltInArgument individualArgument);

  void recordOWLObjectProperty(@NonNull SWRLObjectPropertyBuiltInArgument propertyArgument);

  void recordOWLDataProperty(@NonNull SWRLDataPropertyBuiltInArgument propertyArgument);

  boolean isOWLClass(@NonNull String prefixedName);

  boolean isOWLNamedIndividual(@NonNull String prefixedName);

  boolean isOWLObjectProperty(@NonNull String prefixedName);

  boolean isOWLDataProperty(@NonNull String prefixedName);

  boolean isOWLAnnotationProperty(@NonNull String prefixedName);

  boolean isOWLDatatype(@NonNull String prefixedName);
}