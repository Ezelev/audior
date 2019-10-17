import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Mixer;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;


public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {

            System.out.println(("Audio mixer info: "));
            PrintStream ps = new PrintStream(System.out, true, "UTF-8");
            Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
            for(int i = 0; i < mixerInfo.length; i++)
            {
                ps.println(mixerInfo[i].getName());
            }


    }
}
