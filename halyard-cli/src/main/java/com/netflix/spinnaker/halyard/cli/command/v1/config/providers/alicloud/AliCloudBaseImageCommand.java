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

import com.beust.jcommander.Parameters;
import com.netflix.spinnaker.halyard.cli.command.v1.config.providers.bakery.AbstractBaseImageCommand;

@Parameters(separators = "=")
public class AliCloudBaseImageCommand extends AbstractBaseImageCommand {
  @Override
  protected String getProviderName() {
    return PROVIDER_NAME;
  }

  public AliCloudBaseImageCommand() {
    registerSubcommand(new AliCloudAddBaseImageCommand());
    registerSubcommand(new AliCloudEditBaseImageCommand());
  }
}
