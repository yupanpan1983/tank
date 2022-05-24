package test;




import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @Auther: Yu Panpan
 * @Date: 2022/5/24 - 05 - 24 - 16:52
 * @Description: test
 * @version: 1.0
 */
public class ImageTest {

    @Test
    public void test(){
        try {
//            BufferedImage image = ImageIO.read(new File("F:/腾讯互联/教学部&就业部/授课资料/java课件/课件/2、JavaSE/tank/images/tankL.gif"));
            BufferedImage image2 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
//            BufferedImage image2 = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/tankL.gif"));
//            Assertions.assertNotNull(image);
            Assertions.assertNotNull(image2);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Assertions.fail("这是一个测试未通过的小案例！");
//        Assertions.assertNotNull(new String());
    }

}
