package org.example.plugins;

import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.codehaus.mojo.license.AggregatorAddThirdPartyMojo;

@Mojo(name = "my-goal", aggregator = true, requiresDependencyResolution = ResolutionScope.TEST)
public class MyMojo extends AggregatorAddThirdPartyMojo {
}
