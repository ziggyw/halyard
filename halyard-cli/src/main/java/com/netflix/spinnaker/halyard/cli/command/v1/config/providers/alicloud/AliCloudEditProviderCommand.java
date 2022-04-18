package com.netflix.spinnaker.halyard.cli.command.v1.config.providers.alicloud;

import static com.netflix.spinnaker.halyard.cli.command.v1.config.providers.alicloud.AliCloudCommandProperties.PROVIDER_NAME;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.netflix.spinnaker.halyard.cli.command.v1.config.providers.AbstractEditProviderCommand;
import com.netflix.spinnaker.halyard.config.model.v1.node.Provider;
import com.netflix.spinnaker.halyard.config.model.v1.providers.alicloud.AliCloudAccount;
import com.netflix.spinnaker.halyard.config.model.v1.providers.alicloud.AliCloudProvider;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Parameters(separators = "=")
@Data
public class AliCloudEditProviderCommand
    extends AbstractEditProviderCommand<AliCloudAccount, AliCloudProvider> {

  @Parameter(
      names = "--access-key-id",
      description = AliCloudCommandProperties.ACCESS_KEY_ID_DESCRIPTION)
  private String accessKeyId;

  @Parameter(
      names = "--access-key-secret",
      password = true,
      description = AliCloudCommandProperties.ACCESS_KEY_SECRET_DESCRIPTION)
  private String accessKeySecret;

  @Parameter(names = "--default-region", description = "The region for the sts configuration.")
  private String defaultRegion;

  @Override
  protected String getProviderName() {
    return PROVIDER_NAME;
  }

  @Override
  protected String getShortDescription() {
    return "Set provider-wide properties for the Alibaba Cloud provider";
  }

  @Override
  protected Provider editProvider(AliCloudProvider provider) {
    provider.setAccessKeyId(isSet(accessKeyId) ? accessKeyId : provider.getAccessKeyId());
    provider.setAccessSecretKey(
        isSet(accessKeySecret) ? accessKeySecret : provider.getAccessSecretKey());
    provider.setDefaultRegion(isSet(defaultRegion) ? defaultRegion : provider.getDefaultRegion());

    return provider;
  }
}
