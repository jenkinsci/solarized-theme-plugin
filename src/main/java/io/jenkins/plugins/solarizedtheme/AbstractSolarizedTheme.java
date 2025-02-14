package io.jenkins.plugins.solarizedtheme;

import io.jenkins.plugins.thememanager.Theme;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;

import java.util.Arrays;

public abstract class AbstractSolarizedTheme extends ThemeManagerFactory {

    public static final String BASE_CSS = "solarized-base.css";
    public static final String DEFINITIONS_CSS = "solarized-definitions.css";

    @Override
    public Theme getTheme() {
        return Theme.builder().withCssUrls(Arrays.asList(toAssetUrl(BASE_CSS), getCssUrl(), toAssetUrl(DEFINITIONS_CSS))).build();
    }
}
