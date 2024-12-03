function executeStackCarriage() {
    const boxCount = parseInt(document.getElementById('boxCount').value);
    const carriageHeight = parseInt(document.getElementById('carriageHeight').value);
    const carriageWidth = parseInt(document.getElementById('carriageWidth').value);
    const carriageLength = parseInt(document.getElementById('carriageLength').value);

    const service = new CarriageStackerService();
    const result = service.stackCarriage(boxCount, carriageHeight, carriageWidth, carriageLength);
    document.getElementById('result').innerText = `Result: ${result}`;
}

class CarriageStackerService {
    stackCarriage(boxCount, carriageHeight, carriageWidth, carriageLength) {
        const parcels = this.getParcels(30, 50, 40);
        let resultCount = Number.MAX_VALUE;

        for (let parcel of parcels) {
            let carriage = this.getCarriage(carriageHeight, carriageWidth, carriageLength);
            let count = boxCount > 0 ? 1 : 0;

            for (let i = 0; i < boxCount; i++) {
                if (!carriage.stack(parcel)) {
                    carriage = this.getCarriage(carriageHeight, carriageWidth, carriageLength);
                    count++;
                }
            }
            resultCount = Math.min(resultCount, count);
        }
        return resultCount <= boxCount ? resultCount : -1;
    }

    getCarriage(carriageHeight, carriageWidth, carriageLength) {
        return new Carriage(carriageHeight, carriageWidth, carriageLength);
    }

    getParcels(x, y, z) {
        return [
            new Parcel(x, y, z),
            new Parcel(x, z, y),
            new Parcel(y, x, z),
            new Parcel(y, z, x),
            new Parcel(z, x, y),
            new Parcel(z, y, x)
        ];
    }
}

class Carriage {
    constructor(height, width, length) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.currentHeight = 0;
        this.currentWidth = 0;
        this.currentLength = 0;
        this.interlayer = 1;
    }

    stack(parcel) {
        const SUCCESSFUL = true;
        const NOT_SUCCESSFUL = false;

        if (!this.isValid(parcel)) {
            return NOT_SUCCESSFUL;
        }

        while (this.sum(this.currentLength, parcel.length) > this.length + this.interlayer) {
            if (this.sum(this.currentWidth, parcel.width) > this.width + this.interlayer) {
                if (this.sum(this.currentHeight, parcel.height) > this.height + this.interlayer) {
                    return NOT_SUCCESSFUL;
                }
                this.currentHeight += parcel.height + this.interlayer;
                this.currentWidth = 0;
            } else {
                this.currentWidth += parcel.width + this.interlayer;
            }
            this.currentLength = 0;
        }

        if (this.isFirstLevelStart()) {
            this.currentWidth += parcel.width + this.interlayer;
            this.currentHeight += parcel.height;
        }
        if (this.isMoreThanFirstLevelStart()) {
            this.currentWidth += parcel.width + this.interlayer;
        }
        this.currentLength += parcel.length;
        return SUCCESSFUL;
    }

    isValid(parcel) {
        return this.height >= parcel.height && this.width >= parcel.width && this.length >= parcel.length;
    }

    isMoreThanFirstLevelStart() {
        return this.currentLength === 0 && this.currentWidth === 0;
    }

    isFirstLevelStart() {
        return this.currentLength === 0 && this.currentWidth === 0 && this.currentHeight === 0;
    }

    sum(currentSize, parcelField) {
        return currentSize + parcelField + this.interlayer;
    }
}

class Parcel {
    constructor(height, width, length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }
}