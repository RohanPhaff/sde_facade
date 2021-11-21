package app;

public class Facade {
    private Amplifier amplifier;
    private CdPlayer cdplayer;
    private DvdPlayer dvdplayer;
    private PopcornPopper popcornpopper;
    private Projector projector;
    private Screen screen;
    private TheaterLights theaterlights;
    private Tuner tuner;

    public Facade() {
        amplifier = new Amplifier("Top-O-Line Amplifier");
        tuner = new Tuner("Top-O-Line AM/FM Tuner", amplifier);
        dvdplayer = new DvdPlayer("Top-O-Line DVD Player", amplifier);
        popcornpopper = new PopcornPopper("Popcorn Popper");
        cdplayer = new CdPlayer("Top-O-Line CD Player", amplifier);
        projector = new Projector("Top-O-Line Projector", dvdplayer);
        theaterlights = new TheaterLights("Theater Ceiling Lights");
        screen = new Screen("Theater Screen");
    }

    public void watchAMovie() {
        popcornpopper.on();
        popcornpopper.pop();
        theaterlights.dim(1);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amplifier.on();
        amplifier.setDvd(dvdplayer);
        amplifier.dvd.insert();
        dvdplayer.setSurroundAudio();
        dvdplayer.amplifier.setVolume(5);
        dvdplayer.on();
        dvdplayer.play("shrek");
    }

    public void finishAMovie() {
        popcornpopper.off();
        theaterlights.on();
        screen.up();
        projector.off();
        amplifier.off();
        dvdplayer.stop();
        dvdplayer.eject();
        dvdplayer.off();
    }

    public void listenToMusic() {
        theaterlights.on();
        amplifier.on();
        amplifier.setVolume(5);
        amplifier.setCd(cdplayer);
        amplifier.cd.insert();
        amplifier.setStereoSound();
        amplifier.cd.on();
        amplifier.cd.play("1x1");
    }

    public void finishMusic() {
        amplifier.off();
        amplifier.setCd(cdplayer);
        amplifier.cd.eject();
        amplifier.cd.off();
    }

    public void listenToRadio() {
        tuner.on();
        tuner.setFrequency(2);
        amplifier.on();
        amplifier.setVolume(5);
        amplifier.setTuner(tuner);
    }

    public void finishRadio() {
        tuner.off();
        amplifier.off();
    }
}
