package ru.ugrasu.lab3;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Carriage {

    private final int height;
    private final int width;
    private final int length;
    private int currentHeight;
    private int currentWidth;
    private int currentLength;
    private final int interlayer = 5;


    public boolean stack(Parcel parcel) {
        final boolean SUCCESSFUL = true;
        final boolean NOT_SUCCESSFUL = false;

        if (!isValid(parcel)) {
            return NOT_SUCCESSFUL;
        }

        while (sum(currentLength, parcel.length()) > length + interlayer) {
            if (sum(currentWidth, parcel.width()) > width + interlayer) {

                if (sum(currentHeight, parcel.height()) > height + interlayer) {
                    return NOT_SUCCESSFUL;
                }
                currentHeight = sum(currentHeight, parcel.height());
                currentWidth = 0;
            } else {
                currentWidth = sum(currentWidth, parcel.width());
            }
            currentLength = 0;
        }

        if (isFirstLevelStart()) {
            currentWidth = sum(currentWidth, parcel.width());
            currentHeight = sum(currentHeight, parcel.height());
        }
        if (isMoreThanFirstLevelStart()) {
            currentWidth = sum(currentWidth, parcel.width());
        }
        currentLength = sum(currentLength, parcel.length());
        return SUCCESSFUL;
    }

    private boolean isValid(Parcel parcel) {
        return height >= parcel.height() &&
               width >= parcel.width() &&
               length >= parcel.length();
    }

    private boolean isMoreThanFirstLevelStart() {
        return currentLength == 0 && currentWidth == 0;
    }

    private boolean isFirstLevelStart() {
        return currentLength == 0 && currentWidth == 0 && currentHeight == 0;
    }

    private int sum(int currentHeight, int parcelField) {
        return currentHeight + parcelField + interlayer;
    }
}
