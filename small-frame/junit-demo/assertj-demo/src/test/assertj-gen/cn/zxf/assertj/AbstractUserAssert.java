package cn.zxf.assertj;

import org.assertj.core.api.AbstractObjectAssert;
import org.assertj.core.util.Objects;

/**
 * Abstract base class for {@link User} specific assertions - Generated by CustomAssertionGenerator.
 */
@javax.annotation.Generated(value="assertj-assertions-generator")
public abstract class AbstractUserAssert<S extends AbstractUserAssert<S, A>, A extends User> extends AbstractObjectAssert<S, A> {

  /**
   * Creates a new <code>{@link AbstractUserAssert}</code> to make assertions on actual User.
   * @param actual the User we want to make assertions on.
   */
  protected AbstractUserAssert(A actual, Class<S> selfType) {
    super(actual, selfType);
  }

  /**
   * Verifies that the actual User's age is equal to the given one.
   * @param age the given age to compare the actual User's age to.
   * @return this assertion object.
   * @throws AssertionError - if the actual User's age is not equal to the given one.
   */
  public S hasAge(int age) {
    // check that actual User we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting age of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

    // check
    int actualAge = actual.getAge();
    if (actualAge != age) {
      failWithMessage(assertjErrorMessage, actual, age, actualAge);
    }

    // return the current assertion for method chaining
    return myself;
  }

  /**
   * Verifies that the actual User's name is equal to the given one.
   * @param name the given name to compare the actual User's name to.
   * @return this assertion object.
   * @throws AssertionError - if the actual User's name is not equal to the given one.
   */
  public S hasName(String name) {
    // check that actual User we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting name of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

    // null safe check
    String actualName = actual.getName();
    if (!Objects.areEqual(actualName, name)) {
      failWithMessage(assertjErrorMessage, actual, name, actualName);
    }

    // return the current assertion for method chaining
    return myself;
  }

}