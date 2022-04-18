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
import com.netflix.spinnaker.halyard.cli.command.v1.config.providers.bakery.AbstractEditBakeryDefaultsCommand;
import com.netflix.spinnaker.halyard.cli.command.v1.config.providers.bakery.BakeryCommandProperties;
import com.netflix.spinnaker.halyard.config.model.v1.providers.alicloud.AliCloudBakeryDefaults;

@Parameters(separators = "=")
public class AliCloudEditBakeryDefaultsCommand
    extends AbstractEditBakeryDefaultsCommand<AliCloudBakeryDefaults> {

  @Parameter(
      names = "--alicloud-access-key",
      required = true,
      description = AliCloudCommandProperties.ACCESS_KEY_ID_DESCRIPTION)
  private String accessKeyId;

  @Parameter(
      names = "--alicloud-secret-key",
      required = true,
      password = true,
      description = AliCloudCommandProperties.ACCESS_KEY_SECRET_DESCRIPTION)
  private String accessKeySecret;

  @Parameter(
      names = "--alicloud-vpc-id",
      required = true,
      description = AliCloudCommandProperties.VPC_ID_DESCRIPTION)
  private String alicloudVpcId;

  @Parameter(
      names = "--alicloud-vswitch-id",
      required = true,
      description = AliCloudCommandProperties.VSWITCH_ID_DESCRIPTION)
  private String alicloudVSwitchId;

  @Parameter(
      names = "--template-file",
      description = BakeryCommandProperties.TEMPLATE_FILE_DESCRIPTION)
  private String templateFile;

  @Override
  protected String getProviderName() {
    return PROVIDER_NAME;
  }

  @Override
  protected AliCloudBakeryDefaults editBakeryDefaults(AliCloudBakeryDefaults bakeryDefaults) {
    bakeryDefaults.setAlicloudAccessKey(
        isSet(accessKeyId) ? accessKeyId : bakeryDefaults.getAlicloudAccessKey());
    bakeryDefaults.setAlicloudSecretKey(
        isSet(accessKeySecret) ? accessKeySecret : bakeryDefaults.getAlicloudSecretKey());
    bakeryDefaults.setAlicloudVpcId(
        isSet(alicloudVpcId) ? alicloudVpcId : bakeryDefaults.getAlicloudVpcId());
    bakeryDefaults.setAlicloudVSwitchId(
        isSet(alicloudVSwitchId) ? alicloudVSwitchId : bakeryDefaults.getAlicloudVSwitchId());
    bakeryDefaults.setTemplateFile(
        isSet(templateFile) ? templateFile : bakeryDefaults.getTemplateFile());
    return bakeryDefaults;
  }
}
