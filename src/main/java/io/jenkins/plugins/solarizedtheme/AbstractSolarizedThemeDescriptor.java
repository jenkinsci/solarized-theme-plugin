package io.jenkins.plugins.solarizedtheme;

import io.jenkins.plugins.thememanager.ThemeManagerFactoryDescriptor;

public abstract class AbstractSolarizedThemeDescriptor extends ThemeManagerFactoryDescriptor {

    @Override
    public String getThemeId() {
        return "solarized"; // this is basically unused because we override #getCssUrl
    }
}
