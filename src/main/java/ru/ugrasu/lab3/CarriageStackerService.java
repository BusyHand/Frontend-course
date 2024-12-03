package ru.ugrasu.lab3;

import java.util.List;

import static java.lang.Math.min;

public class CarriageStackerService {
    public static void main(String[] args) {
        int result = new CarriageStackerService().stackCarriage(100, 50, 65, 49);
        System.out.println(result);
    }


    public int stackCarriage(int boxCount, int carriageHeight, int carriageWidth, int carriageLength) {
        List<Parcel> parcels = getParcels(30, 50, 40);
        int resultCount = Integer.MAX_VALUE;
        for (Parcel parcel : parcels) {
            Carriage carriage = getCarriage(carriageHeight, carriageWidth, carriageLength);
            int count = boxCount > 0 ? 1 : 0;
            boolean notFilled = false;
            for (int i = 0; i < boxCount; i++) {
                if (!carriage.stack(parcel)) {
                    if (notFilled) {
                        break;
                    }
                    notFilled = true;
                    i--;
                    carriage = getCarriage(carriageHeight, carriageWidth, carriageLength);
                    count++;
                } else {
                    notFilled = false;
                }

            }
            if (!notFilled)
                resultCount = min(resultCount, count);
        }
        return resultCount <= boxCount ? resultCount : -1;
    }

    public Carriage getCarriage(int carriageHeight, int carriageWidth, int carriageLength) {
        return new Carriage(carriageHeight, carriageWidth, carriageLength);
    }

    public List<Parcel> getParcels(int x, int y, int z) {
        return List.of(
                new Parcel(x, y, z),
                new Parcel(x, z, y),
                new Parcel(y, x, z),
                new Parcel(y, z, x),
                new Parcel(z, x, y),
                new Parcel(z, y, x));
    }
}