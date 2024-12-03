package ru.ugrasu;

import org.junit.jupiter.api.Test;
import ru.ugrasu.lab3.CarriageStackerService;

import static org.assertj.core.api.Assertions.assertThat;

class CarriageStackerServiceTest {

    CarriageStackerService service = new CarriageStackerService();

    @Test
    void test1() {
        int boxCount = 0;
        int carriageHeight = 1;
        int carriageWidth = 1;
        int carriageLength = 1;

        int result = service.stackCarriage(boxCount, carriageHeight, carriageWidth, carriageLength);

        assertThat(result)
                .isEqualTo(0);
    }

    @Test
    void test2() {
        int boxCount = 1;
        int carriageHeight = 1;
        int carriageWidth = 1;
        int carriageLength = 1;

        int result = service.stackCarriage(boxCount, carriageHeight, carriageWidth, carriageLength);

        assertThat(result)
                .isEqualTo(1);
    }
    @Test
    void test3() {
        int boxCount = 1;
        int carriageHeight = 0;
        int carriageWidth = 1;
        int carriageLength = 1;

        int result = service.stackCarriage(boxCount, carriageHeight, carriageWidth, carriageLength);

        assertThat(result)
                .isEqualTo(-1);
    }

    @Test
    void test4() {
        int boxCount = 2;
        int carriageHeight = 3;
        int carriageWidth = 2;
        int carriageLength = 2;

        int result = service.stackCarriage(boxCount, carriageHeight, carriageWidth, carriageLength);

        assertThat(result)
                .isEqualTo(1);
    }

    @Test
    void test5() {
        int boxCount = 2;
        int carriageHeight = 3;
        int carriageWidth = 2;
        int carriageLength = 2;

        int result = service.stackCarriage(boxCount, carriageHeight, carriageWidth, carriageLength);

        assertThat(result)
                .isEqualTo(1);
    }

    @Test
    void test6() {
        int boxCount = 5;
        int carriageHeight = 8;
        int carriageWidth = 1;
        int carriageLength = 1;

        int result = service.stackCarriage(boxCount, carriageHeight, carriageWidth, carriageLength);

        assertThat(result)
                .isEqualTo(2);
    }

    @Test
    void test7() {
        int boxCount = 2;
        int carriageHeight = 1;
        int carriageWidth = 2;
        int carriageLength = 2;

        int result = service.stackCarriage(boxCount, carriageHeight, carriageWidth, carriageLength);

        assertThat(result)
                .isEqualTo(2);
    }

    @Test
    void test8() {
        int boxCount = -2;
        int carriageHeight = -1;
        int carriageWidth = -1;
        int carriageLength = -1;

        int result = service.stackCarriage(boxCount, carriageHeight, carriageWidth, carriageLength);

        assertThat(result)
                .isEqualTo(-1);
    }

    @Test
    void test9() {
        int boxCount = 2;
        int carriageHeight = 1;
        int carriageWidth = 2;
        int carriageLength = 3;

        int result = service.stackCarriage(boxCount, carriageHeight, carriageWidth, carriageLength);

        assertThat(result)
                .isEqualTo(1);
    }
    @Test
    void test10() {
        int boxCount = 8;
        int carriageHeight = 1;
        int carriageWidth = 1;
        int carriageLength = 1;

        int result = service.stackCarriage(boxCount, carriageHeight, carriageWidth, carriageLength);

        assertThat(result)
                .isEqualTo(8);
    }
}
