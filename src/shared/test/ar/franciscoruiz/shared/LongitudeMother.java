package ar.franciscoruiz.shared;

import ar.franciscoruiz.shared.domain.MotherCreator;

public final class LongitudeMother {
    public static String random() {
        return MotherCreator.random().address().longitude();
    }
}
