package io.jenkins.plugins.solarizedtheme;

import io.jenkins.plugins.thememanager.Theme;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;
import jenkins.model.Jenkins;

import java.util.Arrays;

public abstract class AbstractSolarizedTheme extends ThemeManagerFactory {

    public static final String BASE_CSS = "solarized-base.css";
    public static final String DEFINITIONS_CSS = "solarized-definitions.css";

    @Override
    public Theme getTheme() {
        return Theme.builder().withCssUrls(Arrays.asList(toPluginUrl(BASE_CSS), toPluginUrl(getCssUrl()), toPluginUrl(DEFINITIONS_CSS))).build();
    }

    private static String toPluginUrl(String file) {
        return Jenkins.get().getRootUrl() + "solarized-theme/" + file;
    }
}
