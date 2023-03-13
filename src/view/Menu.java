package view;

public abstract class Menu {
    private String title;

    public Menu(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract void execute();
}