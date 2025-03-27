package io.jenkins.plugins.solarizedtheme;

import hudson.Extension;
import hudson.Plugin;
import hudson.model.UnprotectedRootAction;
import jenkins.model.Jenkins;
import org.kohsuke.stapler.StaplerRequest2;
import org.kohsuke.stapler.StaplerResponse2;

import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.Arrays;

@Extension
public class SolarizedRootAction implements UnprotectedRootAction {

    public static final String URL_NAME = "theme-" + AbstractSolarizedThemeDescriptor.ID;

    @Override
    public String getIconFileName() {
        return null; /* no UI */
    }

    @Override
    public String getDisplayName() {
        return null; /* no UI */
    }

    @Override
    public String getUrlName() {
        return URL_NAME;
    }

    public void doDynamic(StaplerRequest2 req, StaplerResponse2 rsp) throws IOException, ServletException {
        String cssFile = req.getRestOfPath();
        if (cssFile.startsWith("/")) {
            cssFile = cssFile.substring(1);
        }
        if (!Arrays.asList(AbstractSolarizedTheme.BASE_CSS, AbstractSolarizedTheme.DEFINITIONS_CSS, SolarizedLightTheme.CSS, SolarizedDarkTheme.CSS).contains(cssFile)) {
            rsp.sendError(404);
            return;
        }
        final Plugin plugin = Jenkins.get().getPlugin("solarized-theme");
        if (plugin == null) {
            rsp.sendError(404);
            return;
        }
        plugin.doDynamic(req, rsp);
    }
}
