package org.swrlapi.owl2rl;

import checkers.nullness.quals.NonNull;

import java.util.List;
import java.util.Set;

/**
 * The SWRLAPI expects that each implementation of a SWRL rule engine will provide an OWL 2 RL-based reasoner.
 *
 * @see org.swrlapi.bridge.TargetSWRLRuleEngine
 */
public interface OWL2RLEngine extends OWL2RLNames
{
  enum OWL2RLRuleStatus {
    Unsupported, PermanentlyOn, Switchable
  }

  /**
   * @return True if the rule selection has changed since last call to {@link OWL2RLEngine#resetRuleSelectionChanged()}.
   */
  boolean hasRuleSelectionChanged();

  /**
   * Reset rule selection changed status
   */
  void resetRuleSelectionChanged();

  /**
   * Set rule selection changed status
   */
  void setRuleSelectionChanged();

  /**
   * @return A list of OWL 2 RL rule tables
   */
  @NonNull List<@NonNull OWL2RLRuleTable> getRuleTables();

  /**
   * @return The number of OWL 2 RL rules
   */
  int getNumberOfRules();

  /**
   * @return The number of OWL 2 RL tables
   */
  int getNumberOfTables();

  /**
   * @return A list of OWL 2 RL rules
   */
  @NonNull List<@NonNull OWL2RLRule> getRules();

  /**
   * @param table An OWL 2 RL rule table
   * @return A list of OWL 2 RL rules
   */
  List<@NonNull OWL2RLRule> getRules(OWL2RLRuleTable table);

  /**
   * @return A list of OWL 2 RL rules
   */
  Set<@NonNull OWL2RLRule> getEnabledRules();

  /**
   * @return A list of OWL 2 RL rules
   */
  Set<@NonNull OWL2RLRule> getUnsupportedRules();

  /**
   * @return A list of OWL 2 RL rules
   */
  Set<@NonNull OWL2RLRule> getPermanentlyOnRules();

  /**
   * @return A list of OWL 2 RL rules
   */
  @NonNull Set<@NonNull OWL2RLRule> getSwitchableRules();

  /**
   * Enable all OWL 2 RL rules
   */
  void enableAll();

  /**
   * Disable all OWL 2 RL rules
   */
  void disableAll();

  /**
   * Enable selected OWL 2 RL rule tables
   * 
   * @param tables A list of OWL 2 RL tables
   */
  void enableTables(@NonNull OWL2RLRuleTable... tables);

  /**
   * Disable selected OWL 2 RL rule tables
   * 
   * @param table An OWL 2 RL table
   */
  void disableTables(@NonNull OWL2RLRuleTable... table);

  /**
   * Enable selected OWL 2 RL rules
   * 
   * @param rules A collection of OWL 2 RL rules
   */
  void enableRules(@NonNull OWL2RLRule... rules);

  /**
   * Disable selected OWL 2 RL rules
   * 
   * @param rules A collection of OWL 2 RL rules
   */
  void disableRules(@NonNull OWL2RLRule... rules);

  /**
   * @param table A collection of OWL 2 RL rule tables
   * @return True if the specified table has enabled rules
   */
  boolean hasEnabledRules(@NonNull OWL2RLRuleTable table);

  /**
   * @param table A collection of OWL 2 RL rule tables
   * @return True if the specified table has switchable rules
   */
  boolean hasSwitchableRules(@NonNull OWL2RLRuleTable table);

  /**
   * @param rule An OWL 2 RL rule
   * @return True if the rule is enables
   */
  boolean isRuleEnabled(@NonNull OWL2RLRule rule);

  /**
   * @param rule An OWL 2 RL rule
   * @return The status of the rule
   */
  @NonNull OWL2RLRuleStatus getRuleStatus(@NonNull OWL2RLRule rule);

  /**
   * @return An OWL 2 RL persistence layer
   */
  @NonNull OWL2RLPersistenceLayer getOWL2RLPersistenceLayer();
}
