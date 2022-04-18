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

import com.netflix.spinnaker.halyard.config.model.v1.node.BaseImage;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
public class AliCloudBaseImage
    extends BaseImage<
        AliCloudBaseImage.AliCloudImageSettings,
        List<AliCloudBaseImage.AliCloudVirtualizationSettings>> {

  private List<AliCloudVirtualizationSettings> virtualizationSettings;
  private AliCloudImageSettings baseImage;

  @EqualsAndHashCode(callSuper = true)
  @Data
  @ToString(callSuper = true)
  public static class AliCloudImageSettings extends BaseImage.ImageSettings {}

  @Data
  public static class AliCloudVirtualizationSettings {
    private String region;
    private String instanceType;
    private String sourceImage;
    private String sshUserName;
  }
}
