package de.mhoffrogge.maven.plugins.base;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.BuildPluginManager;
import org.apache.maven.plugin.version.PluginVersionResolver;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

/**
 * This abstract base Mojo is providing common Maven core objects and common behavior for other specific Mojo
 * implementations.
 *
 * @author mhoffrog
 */
public abstract class AbstractBaseMojo extends AbstractMojo {

  /**
   * The current Maven session running.
   */
  @Parameter(defaultValue = "${session}", readonly = true)
  private MavenSession mavenSession;

  /**
   * The current Maven project running for.
   */
  @Parameter(defaultValue = "${project}", readonly = true)
  private MavenProject project;

  @Component
  private BuildPluginManager pluginManager;

  @Component
  private PluginVersionResolver pluginVersionResolver;

  /**
   * @return the current {@link MavenSession}
   */
  protected MavenSession getMavenSession() {
    return this.mavenSession;
  }

  /**
   * @return the current {@link MavenProject}
   */
  protected MavenProject getProject() {
    return this.project;
  }

  /**
   * @return the current {@link BuildPluginManager}
   */
  protected BuildPluginManager getPluginManager() {
    return this.pluginManager;
  }

  /**
   * @return the current {@link PluginVersionResolver}
   */
  protected PluginVersionResolver getPluginVersionResolver() {
    return this.pluginVersionResolver;
  }

  protected boolean isProjectSnapshotVersion() {
    return getProject().getVersion().endsWith("-SNAPSHOT");
  }

}
