package io.jenkins.plugins.solarizedtheme;

import io.jenkins.plugins.thememanager.Theme;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;
import jenkins.model.Jenkins;

import java.util.Arrays;

public abstract class AbstractSolarizedTheme extends ThemeManagerFactory {
    @Override
    public Theme getTheme() {
        return Theme.builder().withCssUrls(Arrays.asList(toPluginUrl("solarized-base.css"), toPluginUrl(getCssUrl()), toPluginUrl("solarized-definitions.css"))).build();
    }

    private static String toPluginUrl(String file) {
        return Jenkins.get().getRootUrl() + "plugin/solarized-theme/" + file;
    }
}
