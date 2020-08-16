package io.jenkins.plugins.solarizedtheme;

import hudson.Extension;
import hudson.model.UnprotectedRootAction;
import jenkins.model.Jenkins;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

@Extension
public class SolarizedRootAction implements UnprotectedRootAction {
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
        return "solarized-theme";
    }

    public void doDynamic(StaplerRequest req, StaplerResponse rsp) throws IOException, ServletException {
        String cssFile = req.getRestOfPath();
        if (cssFile.startsWith("/")) {
            cssFile = cssFile.substring(1);
        }
        if (!Arrays.asList(AbstractSolarizedTheme.BASE_CSS, AbstractSolarizedTheme.DEFINITIONS_CSS, SolarizedSystemTheme.CSS, SolarizedLightTheme.CSS, SolarizedDarkTheme.CSS).contains(cssFile)) {
            rsp.sendError(404);
            return;
        }
        Objects.requireNonNull(Jenkins.get().getPlugin("solarized-theme")).doDynamic(req, rsp);
    }
}
