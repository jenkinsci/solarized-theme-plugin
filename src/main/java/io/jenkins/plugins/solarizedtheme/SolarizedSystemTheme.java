package io.jenkins.plugins.solarizedtheme;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;

public class SolarizedSystemTheme extends AbstractSolarizedTheme {

    public static final String CSS = "solarized-system.css";

    @DataBoundConstructor
    public SolarizedSystemTheme() {
        // Stapler
    }

    @Override
    public String getCssUrl() {
        return CSS;
    }

    @Extension
    @Symbol("solarizedSystem")
    public static class DescriptorImpl extends AbstractSolarizedThemeDescriptor {
        @Override
        public ThemeManagerFactory getInstance() {
            return new SolarizedSystemTheme();
        }

        @NonNull
        @Override
        public String getDisplayName() {
            return "Solarized (System)"; // TODO i18n?
        }
    }
}
