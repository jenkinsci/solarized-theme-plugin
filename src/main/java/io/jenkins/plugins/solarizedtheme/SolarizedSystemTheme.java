package io.jenkins.plugins.solarizedtheme;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import io.jenkins.plugins.thememanager.Theme;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;

public class SolarizedSystemTheme extends AbstractSolarizedTheme {

    @DataBoundConstructor
    public SolarizedSystemTheme() {
        // Stapler
    }

    @Override
    public Theme getTheme() {
        return Theme.builder().build();
    }

    @Extension
    @Symbol("solarizedSystem")
    public static class DescriptorImpl extends AbstractSolarizedThemeDescriptor {

        @Override
        public String getThemeKey() {
            return "solarized-system";
        }

        @Override
        public ThemeManagerFactory getInstance() {
            return new SolarizedSystemTheme();
        }

        @NonNull
        @Override
        public String getDisplayName() {
            return "Solarized (System)"; // TODO i18n?
        }

        @Override
        public String getIconClassName() {
            return "symbol-moon-outline plugin-ionicons-api";
        }
    }
}
