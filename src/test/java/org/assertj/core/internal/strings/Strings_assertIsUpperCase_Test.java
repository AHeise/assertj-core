/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2018 the original author or authors.
 */
package org.assertj.core.internal.strings;

import static org.assertj.core.error.ShouldBeUpperCase.shouldBeUpperCase;
import static org.assertj.core.test.TestData.someInfo;
import static org.assertj.core.util.FailureMessages.actualIsNull;

import org.assertj.core.internal.StringsBaseTest;
import org.junit.Test;

/**
 * Tests for <code>{@link org.assertj.core.internal.Strings#assertUpperCase(org.assertj.core.api.AssertionInfo, CharSequence)} </code>.
 *
 * @author Marcel Overdijk
 */
public class Strings_assertIsUpperCase_Test extends StringsBaseTest {

  @Test
  public void should_pass_if_actual_is_uppercase() {
    strings.assertUpperCase(someInfo(), "LEGO");
  }

  @Test
  public void should_pass_if_actual_is_empty() {
    strings.assertUpperCase(someInfo(), "");
  }

  @Test
  public void should_fail_if_actual_is_not_only_uppercase() {
    thrown.expectAssertionError(shouldBeUpperCase("Lego").create());
    strings.assertUpperCase(someInfo(), "Lego");
  }

  @Test
  public void should_fail_if_actual_is_lowercase() {
    thrown.expectAssertionError(shouldBeUpperCase("lego").create());
    strings.assertUpperCase(someInfo(), "lego");
  }

  @Test
  public void should_fail_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull());
    strings.assertUpperCase(someInfo(), null);
  }

}
