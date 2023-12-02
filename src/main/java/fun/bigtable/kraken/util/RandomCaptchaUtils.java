package fun.bigtable.kraken.util;

import org.apache.commons.lang3.ArrayUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Random;

/**
 * 验证码工具类,用于生成多种类型验证码
 * 字符集中去掉了O o I i l等容易混淆的字符
 *
 */
public class RandomCaptchaUtils {
    private static int imageWidth;
    private static int imageHeight;
    private static Random random = new Random();
    private static final char[] NUMBERS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final char[] LETTERS = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'P', 'A', 'S', 'D', 'F', 'G', 'H',
            'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'p', 'a', 's',
            'd', 'f', 'g', 'h', 'j', 'k', 'z', 'x', 'c', 'v', 'b', 'n', 'm'};

    /**
     * 生成指定长度的数字验证码
     *
     * @param length the length of verification code
     * @return verification code
     */
    public static String generateNumberCode(int length) {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int position = random.nextInt(100);
            code.append(NUMBERS[position % 10]);
        }
        return code.toString();
    }

    /**
     * 生成指定长度的混合验证码
     *
     * @param length the length of verification code
     * @return verification code
     */
    public static String generateMixCode(int length) {
        char[] base = ArrayUtils.addAll(NUMBERS, LETTERS);
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int position = random.nextInt(base.length);
            code.append(base[position]);
        }
        return code.toString();
    }

    /**
     * 生成PNG格式的验证码图片
     *
     * @param width   picture width
     * @param height  picture height
     * @param captcha captcha
     * @return base64
     */
    public static String generateCaptchaImage(int width, int height, String captcha) throws IOException {
        imageWidth = width;
        imageHeight = height;

        // 初始化
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = (Graphics2D) image.getGraphics();

        // 填充画布
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, width, height);

        // 抗锯齿
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setStroke(new BasicStroke(1.3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));

        // 设置干扰
        drawLine(graphics2D, 8);
        drawCircle(graphics2D, 6);

        // 设置透明度
        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f);
        graphics2D.setComposite(alphaComposite);

        // 填充字符串
        drawString(graphics2D, captcha);

        // 输出
        return encodeBase64(image);
    }

    /**
     * 绘制随机干扰线
     *
     * @param graphics Graphics2D
     * @param number   the number of lines
     */
    private static void drawLine(Graphics2D graphics, int number) {
        for (int i = 0; i < number; i++) {
            graphics.setColor(randomColor(150, 250));
            int x1 = random.nextInt(imageWidth + 10);
            int y1 = random.nextInt(imageHeight + 10);
            int x2 = random.nextInt(imageWidth + 10);
            int y2 = random.nextInt(imageHeight + 10);
            graphics.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * 绘制随机干扰圆
     *
     * @param graphics Graphics2D
     * @param number   the number of circles
     */
    private static void drawCircle(Graphics2D graphics, int number) {
        for (int i = 0; i < number; i++) {
            graphics.setColor(randomColor(100, 240));
            graphics.drawOval(random.nextInt(imageWidth), random.nextInt(imageHeight),
                    random.nextInt(imageHeight), random.nextInt(imageHeight));
        }
    }

    /**
     * 给定范围生成随机颜色
     *
     * @param start 0-255
     * @param end   0-255
     * @return Color
     */
    private static Color randomColor(int start, int end) {
        if (start > 255) {
            start = 255;
        }
        if (end > 255) {
            end = 255;
        }
        int r = start + random.nextInt(end - start);
        int g = start + random.nextInt(end - start);
        int b = start + random.nextInt(end - start);
        return new Color(r, g, b);
    }

    /**
     * 绘制字符
     *
     * @param graphics Graphics2D
     * @param captcha  captcha
     */
    private static void drawString(Graphics2D graphics, String captcha) {
        char[] str = captcha.toCharArray();
        Font font = new Font("Arial", Font.BOLD, 32);

        int hp = (imageHeight - font.getSize()) >> 1;
        int h = imageHeight - hp;
        int w = imageWidth / str.length;
        int sp = (w - font.getSize()) / 2;

        for (int i = 0; i < str.length; i++) {
            graphics.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            // 计算坐标
            int x = i * w + sp + random.nextInt(3);
            int y = h - (3 + random.nextInt(3));
            if (x < 8) {
                x = 8;
            }
            if (x + font.getSize() > imageWidth) {
                x = imageWidth - font.getSize();
            }
            if (y > imageHeight) {
                y = imageHeight;
            }
            if (y - font.getSize() < 0) {
                y = font.getSize();
            }
            graphics.setFont(font.deriveFont(random.nextInt(2) == 0 ? Font.PLAIN : Font.ITALIC));
            graphics.drawString(String.valueOf(str[i]), x, y);
        }
    }

    /**
     * 将BufferedImage转换为Base64字符串
     *
     * @param image BufferedImage
     * @return base64
     * @throws IOException IOException
     */
    private static String encodeBase64(BufferedImage image) throws IOException {
        Base64.Encoder encoder = Base64.getEncoder();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);

        byte[] imageBytes = outputStream.toByteArray();
        outputStream.close();

        String base64 = encoder.encodeToString(imageBytes).replaceAll("\n", "").replaceAll("\r", "");
        return "data:image/png;base64," + base64;
    }
}