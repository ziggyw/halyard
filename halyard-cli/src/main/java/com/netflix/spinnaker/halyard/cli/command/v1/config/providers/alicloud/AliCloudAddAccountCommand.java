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
import com.netflix.spinnaker.halyard.cli.command.v1.config.providers.account.AbstractAddAccountCommand;
import com.netflix.spinnaker.halyard.config.model.v1.node.Account;
import com.netflix.spinnaker.halyard.config.model.v1.providers.alicloud.AliCloudAccount;
import java.util.ArrayList;
import java.util.List;

@Parameters(separators = "=")
public class AliCloudAddAccountCommand extends AbstractAddAccountCommand {

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

  @Parameter(
      names = "--assume-role",
      description = AliCloudCommandProperties.ASSUME_ROLE_DESCRIPTION)
  private String assumeRole;

  @Parameter(names = "--account-id", description = AliCloudCommandProperties.ACCOUNT_ID_DESCRIPTION)
  private String accountId;

  @Override
  protected String getProviderName() {
    return PROVIDER_NAME;
  }

  @Override
  protected Account buildAccount(String accountName) {
    AliCloudAccount account = new AliCloudAccount();
    account.setName(accountName);
    account
        .setAccessKeyId(accessKeyId)
        .setAccessSecretKey(accessKeySecret)
        .setRegions(regions)
        .setAccountId(accountId)
        .setAssumeRole(assumeRole);
    return account;
  }

  @Override
  protected Account emptyAccount() {
    return new AliCloudAccount();
  }
}
