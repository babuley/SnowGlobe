package com.nirima.jenkins.plugins.snowglobe;

import com.nirima.jenkins.plugins.snowglobe.registry.SnowGlobeRegistry;

import net.sf.json.JSONObject;

import org.kohsuke.stapler.StaplerRequest;

import hudson.Extension;
import hudson.Functions;
import hudson.Util;
import jenkins.model.GlobalConfiguration;

/**
 * Created by magnayn on 06/09/2016.
 */
@Extension
public class SnowGlobePluginConfiguration extends GlobalConfiguration {

  private String dotExe;

  private SnowGlobeRegistry registry;

  public SnowGlobePluginConfiguration() {
      load();
  }

  @Override
  public boolean configure(StaplerRequest req, JSONObject json) throws FormException {
    req.bindJSON(this,json);
    return true;
  }

  /**
   * Returns this singleton instance.
   *
   * @return the singleton.
   */
  public static SnowGlobePluginConfiguration get() {
    return GlobalConfiguration.all().get(SnowGlobePluginConfiguration.class);
  }

  public String getDotExeOrDefault() {
    if (Util.fixEmptyAndTrim(dotExe) == null) {
      return Functions.isWindows() ? "dot.exe" : "dot";
    } else {
      return dotExe;
    }
  }

  public String getDotExe() {
    return dotExe;
  }

  public void setDotExe(String dotExe) {
    this.dotExe = dotExe;
    save();
  }


}
