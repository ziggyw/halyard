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

public class AliCloudCommandProperties {
  public static String PROVIDER_NAME = "alicloud";

  public static final String REGIONS_DESCRIPTION =
      "The Alibaba Cloud regions this Spinnaker account will manage.";

  public static final String ACCESS_KEY_ID_DESCRIPTION =
      "The secret id used to access Alibaba Cloud.";
  public static final String ACCESS_KEY_SECRET_DESCRIPTION =
      "The secret key used to access  Alibaba Cloud.";
  public static final String ADD_REGION_DESCRIPTION =
      "Add this region to the list of managed regions.";
  public static final String REMOVE_REGION_DESCRIPTION =
      "Remove this region from the list of managed regions.";
  public static final String VSWITCH_ID_DESCRIPTION =
      "The vswitch id for the baking configuration.";
  public static final String VPC_ID_DESCRIPTION = "The vpc id for the baking configuration.";
  public static final String REGION_DESCRIPTION = "The region for the baking configuration.";
  public static final String INSTANCE_TYPE_DESCRIPTION =
      "The instance type for the baking configuration.";
  public static final String SOURCE_IMAGE_ID_DESCRIPTION =
      "The source image ID for the baking configuration.";
  public static final String SSH_USER_NAME_DESCRIPTION =
      "The ssh username for the baking configuration.";
  public static final String ASSUME_ROLE_DESCRIPTION =
      "If set, Halyard will configure a credentials provider that uses Alibaba Cloud "
          + "Security Token Service to assume the specified role.\n\n"
          + "Example: \"user/spinnaker\" or \"role/spinnakerManaged\"";

  public static final String ACCOUNT_ID_DESCRIPTION = "Your Alibaba Cloud account ID to manage. ";
}
