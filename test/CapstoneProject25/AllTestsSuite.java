package CapstoneProject25;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * Runs all unit tests together.
 */
@Suite
@SelectClasses({
    MultipleExceptionHandlerTest.class,
    RethrowExceptionHandlerTest.class,
    ResourceManagerTest.class,
    ExceptionHandlerTest.class
})
public class AllTestsSuite {
}
