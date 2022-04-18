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
import com.netflix.spinnaker.halyard.cli.command.v1.config.providers.account.AbstractEditAccountCommand;
import com.netflix.spinnaker.halyard.config.model.v1.node.Account;
import com.netflix.spinnaker.halyard.config.model.v1.providers.alicloud.AliCloudAccount;
import java.util.ArrayList;
import java.util.List;

@Parameters(separators = "=")
public class AliCloudEditAccountCommand extends AbstractEditAccountCommand<AliCloudAccount> {
  @Parameter(
      names = "--access-key-id",
      description = AliCloudCommandProperties.ACCESS_KEY_ID_DESCRIPTION)
  private String accessKeyId;

  @Parameter(
      names = "--access-key-secret",
      password = true,
      description = AliCloudCommandProperties.ACCESS_KEY_SECRET_DESCRIPTION)
  private String accessKeySecret;

  @Parameter(
      names = "--regions",
      variableArity = true,
      description = AliCloudCommandProperties.REGIONS_DESCRIPTION)
  private List<String> regions = new ArrayList<>();

  @Parameter(names = "--add-region", description = AliCloudCommandProperties.ADD_REGION_DESCRIPTION)
  private String addRegion;

  @Parameter(
      names = "--remove-region",
      description = AliCloudCommandProperties.REMOVE_REGION_DESCRIPTION)
  private String removeRegion;

  @Parameter(names = "--account-id", description = AliCloudCommandProperties.ACCOUNT_ID_DESCRIPTION)
  private String accountId;

  @Parameter(
      names = "--assume-role",
      description = AliCloudCommandProperties.ASSUME_ROLE_DESCRIPTION)
  private String assumeRole;

  @Override
  protected String getProviderName() {
    return PROVIDER_NAME;
  }

  @Override
  protected Account editAccount(AliCloudAccount account) {
    account.setAccessKeyId(isSet(accessKeyId) ? accessKeyId : account.getAccessKeyId());
    account.setAccessSecretKey(
        isSet(accessKeySecret) ? accessKeySecret : account.getAccessSecretKey());
    account.setAccessSecretKey(isSet(assumeRole) ? assumeRole : account.getAssumeRole());
    account.setAccessSecretKey(isSet(accountId) ? accountId : account.getAccountId());

    try {
      List<String> existingRegions = account.getRegions();
      List<String> newRegions = updateStringList(existingRegions, regions, addRegion, removeRegion);
      account.setRegions(newRegions);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Set either --regions or --[add/remove]-region");
    }

    return account;
  }
}
