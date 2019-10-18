import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Mixer;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;


public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {

        Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
        for (Mixer.Info info : mixerInfo) {
            String deviceName = info.getName();

            byte[] bytes = deviceName.getBytes(StandardCharsets.ISO_8859_1); // <- from
            String value = new String(bytes, "Windows-1251"); // <- to

            System.out.println(value);

        }

    }

}