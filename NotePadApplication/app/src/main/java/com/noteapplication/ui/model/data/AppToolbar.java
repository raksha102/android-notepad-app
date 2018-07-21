
package com.noteapplication.ui.model.data;


public class AppToolbar {

    private String title;
    private boolean actionBarEnabled;
    private boolean backButtonEnabled;
    private boolean navigationButtonEnabled;
    private boolean closeButtonEnabled;
    private int background = -1;
    private int logo = -1;
    private boolean addEnabled;
    private boolean saveEnabled;

    public AppToolbar(AppToolBarBuilder builder) {
        this.title = builder.title;
        this.actionBarEnabled = builder.actionBarEnabled;
        this.backButtonEnabled = builder.backButtonEnabled;
        this.navigationButtonEnabled = builder.navigationButtonEnabled;
        this.closeButtonEnabled = builder.closeButtonEnabled;
        this.background = builder.background;
        this.logo = builder.logo;
        this.addEnabled = builder.addEnabled;
        this.saveEnabled = builder.saveEnabled;
    }

    public String getTitle() {
        return title;
    }

    public boolean isActionBarEnabled() {
        return actionBarEnabled;
    }

    public boolean isBackButtonEnabled() {
        return backButtonEnabled;
    }

    public boolean isNavigationButtonEnabled() {
        return navigationButtonEnabled;
    }

    public boolean isCloseButtonEnabled() {
        return closeButtonEnabled;
    }

    public int getBackground() {
        return background;
    }

    public int getLogo() {
        return logo;
    }

    public boolean isAddEnabled() {
        return addEnabled;
    }

    public boolean isSaveEnabled() {
        return saveEnabled;
    }

    public static class AppToolBarBuilder {

        private String title;
        private boolean actionBarEnabled;
        private boolean backButtonEnabled;
        private boolean navigationButtonEnabled;
        private boolean closeButtonEnabled;
        private int background = -1;
        private int logo = -1;
        private boolean addEnabled;
        private boolean saveEnabled;

        public AppToolBarBuilder(boolean isActionBarEnabled) {
            this.actionBarEnabled = isActionBarEnabled;
        }

        public AppToolBarBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public AppToolBarBuilder setBackButtonEnabled(boolean backButtonEnabled) {
            this.backButtonEnabled = backButtonEnabled;
            return this;
        }

        public AppToolBarBuilder setNavigationButtonEnabled(boolean navigationButtonEnabled) {
            this.navigationButtonEnabled = navigationButtonEnabled;
            return this;
        }

        public AppToolBarBuilder setCloseButtonEnabled(boolean closeButtonEnabled) {
            this.closeButtonEnabled = closeButtonEnabled;
            return this;
        }

        public AppToolBarBuilder setBackground(int background) {
            this.background = background;
            return this;
        }

        public AppToolBarBuilder setLogo(int logo) {
            this.logo = logo;
            return this;
        }

        public AppToolBarBuilder setAddEnabled(boolean addEnabled) {
            this.addEnabled = addEnabled;
            return this;
        }

        public AppToolBarBuilder setSaveEnabled(boolean saveEnabled) {
            this.saveEnabled = saveEnabled;
            return this;
        }

        public AppToolbar build() {
            return new AppToolbar(this);
        }
    }

}
