package io.jenkins.plugins.solarizedtheme;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;

public class SolarizedDarkTheme extends AbstractSolarizedTheme {

    public static final String CSS = "solarized-dark.css";

    @DataBoundConstructor
    public SolarizedDarkTheme() {
        // Stapler
    }

    @Override
    public String getCssUrl() {
        return CSS;
    }

    @Extension
    @Symbol("solarizedDark")
    public static class DescriptorImpl extends AbstractSolarizedThemeDescriptor {
        @Override
        public ThemeManagerFactory getInstance() {
            return new SolarizedLightTheme();
        }

        @NonNull
        @Override
        public String getDisplayName() {
            return "Solarized Dark"; // TODO i18n?
        }
    }
}
