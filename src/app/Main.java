package app;

public class Main {

    public static void main(String[] args) {
        Facade facade = new Facade();

        facade.watchAMovie();

        facade.finishAMovie();

        facade.listenToMusic();

        facade.finishMusic();

        facade.listenToRadio();

        facade.finishRadio();
    }
}
