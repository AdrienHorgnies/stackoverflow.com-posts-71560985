package org.example.plugins;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.BuildPluginManager;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Mojo;

import static org.twdata.maven.mojoexecutor.MojoExecutor.*;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;

@Mojo(name = "my-goal", aggregator = true, requiresDependencyResolution = ResolutionScope.TEST)
public class MyMojo extends AbstractMojo {

    @Component
    private MavenProject mavenProject;

    @Component
    private MavenSession mavenSession;

    @Component
    private BuildPluginManager pluginManager;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("==========================================");
        executeMojo(
                plugin(
                        groupId("org.codehaus.mojo"),
                        artifactId("license-maven-plugin"),
                        version("2.0.0")
                ),
                goal("aggregate-add-third-party"),
                configuration(
                        element(name("includeTransitiveDependencies"), "false")
                ),
                executionEnvironment(
                        mavenProject,
                        mavenSession,
                        pluginManager
                )
        );
        System.out.println("==========================================");
    }
}
