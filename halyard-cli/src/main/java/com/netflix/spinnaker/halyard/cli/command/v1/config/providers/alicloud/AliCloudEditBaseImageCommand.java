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

package com.netflix.spinnaker.halyard.cli.command.v1.config.providers.alicloud;

import static com.netflix.spinnaker.halyard.cli.command.v1.config.providers.alicloud.AliCloudCommandProperties.PROVIDER_NAME;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.netflix.spinnaker.halyard.cli.command.v1.config.providers.bakery.AbstractEditBaseImageCommand;
import com.netflix.spinnaker.halyard.config.model.v1.node.BaseImage;
import com.netflix.spinnaker.halyard.config.model.v1.providers.alicloud.AliCloudBaseImage;
import com.netflix.spinnaker.halyard.config.model.v1.providers.alicloud.AliCloudBaseImage.AliCloudVirtualizationSettings;

@Parameters(separators = "=")
public class AliCloudEditBaseImageCommand extends AbstractEditBaseImageCommand<AliCloudBaseImage> {
  @Parameter(
      names = "--region",
      required = true,
      description = AliCloudCommandProperties.REGION_DESCRIPTION)
  private String region;

  @Parameter(
      names = "--instance-type",
      required = true,
      description = AliCloudCommandProperties.INSTANCE_TYPE_DESCRIPTION)
  private String instanceType;

  @Parameter(
      names = "--source-image-id",
      required = true,
      description = AliCloudCommandProperties.SOURCE_IMAGE_ID_DESCRIPTION)
  private String sourceImageId;

  @Parameter(
      names = "--ssh-user-name",
      required = true,
      description = AliCloudCommandProperties.SSH_USER_NAME_DESCRIPTION)
  private String sshUserName;

  @Override
  protected String getProviderName() {
    return PROVIDER_NAME;
  }

  @Override
  protected BaseImage editBaseImage(AliCloudBaseImage baseImage) {
    AliCloudVirtualizationSettings virtualizationSettings =
        baseImage.getVirtualizationSettings().get(0);

    virtualizationSettings.setRegion(isSet(region) ? region : virtualizationSettings.getRegion());
    virtualizationSettings.setSourceImage(
        isSet(sourceImageId) ? sourceImageId : virtualizationSettings.getSourceImage());
    virtualizationSettings.setInstanceType(
        isSet(instanceType) ? instanceType : virtualizationSettings.getInstanceType());
    virtualizationSettings.setSshUserName(
        isSet(sshUserName) ? sshUserName : virtualizationSettings.getSshUserName());
    return baseImage;
  }
}
