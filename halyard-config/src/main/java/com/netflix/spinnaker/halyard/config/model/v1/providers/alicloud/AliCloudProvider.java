/*
 * Copyright 2022 Alibaba Group, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.halyard.config.model.v1.providers.alicloud;

import static com.netflix.spinnaker.halyard.config.model.v1.node.Provider.ProviderType.ALICLOUD;

import com.netflix.spinnaker.halyard.config.model.v1.node.HasImageProvider;
import com.netflix.spinnaker.halyard.config.model.v1.node.Secret;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AliCloudProvider extends HasImageProvider<AliCloudAccount, AliCloudBakeryDefaults>
    implements Cloneable {
  private String accessKeyId;
  @Secret private String accessSecretKey;
  private String defaultRegion;

  @Override
  public AliCloudBakeryDefaults emptyBakeryDefaults() {
    return new AliCloudBakeryDefaults();
  }

  @Override
  public ProviderType providerType() {
    return ALICLOUD;
  }
}
