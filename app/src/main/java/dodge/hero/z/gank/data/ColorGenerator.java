package dodge.hero.z.gank.data;

import java.util.Random;

/**
 * 描述这个类
 * Created by z on 2017/10/11.
 */

public class ColorGenerator {

    public static final int COLOR_1 = 0xFF90D1B8;
    public static final int COLOR_2 = 0xFFC5BDED;
    public static final int COLOR_3 = 0xFFF8CCCD;
    public static final int COLOR_4 = 0xFFFEC59A;
    public static final int COLOR_5 = 0xFFC8E5EB;

    private static int[] colors = new int[]{COLOR_1,
            COLOR_2, COLOR_3, COLOR_4, COLOR_5};


    public static int generator() {
        int size = colors.length;
        Random random = new Random();
        return colors[random.nextInt(size)];
    }


}
