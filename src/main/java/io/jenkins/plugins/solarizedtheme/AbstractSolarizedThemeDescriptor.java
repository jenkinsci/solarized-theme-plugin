package io.jenkins.plugins.solarizedtheme;

import io.jenkins.plugins.thememanager.ThemeManagerFactoryDescriptor;

public abstract class AbstractSolarizedThemeDescriptor extends ThemeManagerFactoryDescriptor {

    public static final String ID = "solarized";

    @Override
    public String getThemeId() {
        return ID;
    }

    @Override
    public boolean isNamespaced() {
        return true;
    }

    @Override
    public String getIconClassName() {
        return "symbol-solarized plugin-solarized-theme";
    }
}
