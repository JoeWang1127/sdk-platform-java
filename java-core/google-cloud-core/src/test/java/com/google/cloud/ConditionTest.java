/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

final class ConditionTest {

  @Test
  void title_nullable() {
    Condition condition =
        Condition.newBuilder().setTitle(null).setDescription("desc").setExpression("expr").build();

    assertThat(condition.getTitle()).isNull();
  }

  @Test
  void description_nullable() {
    Condition condition =
        Condition.newBuilder().setTitle("title").setDescription(null).setExpression("expr").build();

    assertThat(condition.getDescription()).isNull();
  }
}
