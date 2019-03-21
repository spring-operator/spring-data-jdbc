/*
 * Copyright 2018-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.relational.core.mapping;

import static org.assertj.core.api.Assertions.*;

import java.util.UUID;

import org.junit.Test;
import org.springframework.data.annotation.Id;

/**
 * Unit tests for {@link RelationalMappingContext}.
 *
 * @author Toshiaki Maki
 */
public class RelationalMappingContextUnitTests {

	@Test // DATAJDBC-229
	public void uuidPropertyIsNotEntity() {

		RelationalMappingContext mappingContext = new RelationalMappingContext();
		RelationalPersistentEntity<?> entity = mappingContext.getPersistentEntity(EntityWithUuid.class);
		RelationalPersistentProperty uuidProperty = entity.getRequiredPersistentProperty("uuid");

		assertThat(uuidProperty.isEntity()).isFalse();
	}

	static class EntityWithUuid {
		@Id UUID uuid;
	}
}
