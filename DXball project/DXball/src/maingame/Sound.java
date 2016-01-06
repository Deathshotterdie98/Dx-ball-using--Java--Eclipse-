package maingame;

import java.io.*;

import javax.sound.sampled.*;


public class Sound  {

	
	public static void gameover_sound(){
		new Thread(new Runnable(){
			public void run(){
				System.out.println("game over sound class called");
				
				Sound gun=new Sound("sound/Gameover_sound.wav");
				InputStream stream = new ByteArrayInputStream(gun.getSamples());

				gun.play(stream);
			}
		}).start();
		
	}
	
	public static void song_sound(){
		new Thread(new Runnable(){
			public void run(){
				System.out.println("game over sound class called");
				
				Sound gun=new Sound("sound/Ifu-love.wav");
				InputStream stream = new ByteArrayInputStream(gun.getSamples());

				gun.play(stream);
			}
		}).start();
		
	}
	
	public static void bar_left_intersect_sound(){
		new Thread(new Runnable(){
			public void run(){
				System.out.println("bar left inersect sound class called");
				
				Sound gun=new Sound("sound/bar_left_intersect.wav");
				InputStream stream = new ByteArrayInputStream(gun.getSamples());

				gun.play(stream);
			}
		}).start();
		
	}
	public static void brick_break_sound(){
		new Thread(new Runnable(){
			public void run(){
				System.out.println("brick break sound class called");
				
				Sound gun=new Sound("sound/tank.wav");
				InputStream stream = new ByteArrayInputStream(gun.getSamples());

				gun.play(stream);
			}
		}).start();
		
	}

	public static void wall_touch_sound(){
		new Thread(new Runnable(){
			public void run(){
				System.out.println("wall touch sound class called");
				
				Sound gun=new Sound("sound/wallbrick.wav");
				InputStream stream = new ByteArrayInputStream(gun.getSamples());

				gun.play(stream);
			}
		}).start();
		
	}
	public static void bar_upper_intersect_sound(){
		new Thread(new Runnable(){
			public void run(){
				System.out.println("bar upper intersect sound class called");
				
				Sound gun=new Sound("sound/bar_upper_intersect.wav");
				InputStream stream = new ByteArrayInputStream(gun.getSamples());

				gun.play(stream);
			}
		}).start();
		
	}
	public static void ball_speed_increase_sound(){
		new Thread(new Runnable(){
			public void run(){
				System.out.println("bar upper intersect sound class called");
				
				Sound gun=new Sound("sound/ball_speed_increase.wav");
				InputStream stream = new ByteArrayInputStream(gun.getSamples());

				gun.play(stream);
			}
		}).start();
		
	}
	public static void bar_size_increase_sound(){
		new Thread(new Runnable(){
			public void run(){
				System.out.println("bar SIZE  sound called");
				
				Sound gun=new Sound("sound/bar_size_increase1.wav");
				InputStream stream = new ByteArrayInputStream(gun.getSamples());

				gun.play(stream);
			}
		}).start();
		
	}
	public static void bar_on_hurry_sound(){
		new Thread(new Runnable(){
			public void run(){
				System.out.println("game over sound class called");
				
				Sound gun=new Sound("sound/bar_on_hurry.wav");
				InputStream stream = new ByteArrayInputStream(gun.getSamples());

				gun.play(stream);
			}
		}).start();
		
	}
	public static void one_life_plus_sound(){
		new Thread(new Runnable(){
			public void run(){
				System.out.println("game over sound class called");
				
				Sound gun=new Sound("sound/one_life_plus.wav");
				InputStream stream = new ByteArrayInputStream(gun.getSamples());

				gun.play(stream);
			}
		}).start();
		
	}
	public static void bar_size_decrease(){
		new Thread(new Runnable(){
			public void run(){
				System.out.println("game over sound class called");
				
				Sound gun=new Sound("sound/bar_size_decrease.wav");
				InputStream stream = new ByteArrayInputStream(gun.getSamples());

				gun.play(stream);
			}
		}).start();
		
	}
	public static void Level_up(){
		new Thread(new Runnable(){
			public void run(){
				System.out.println("game over sound class called");
				
				Sound gun=new Sound("sound/Level_up.wav");
				InputStream stream = new ByteArrayInputStream(gun.getSamples());

				gun.play(stream);
			}
		}).start();
		
	}


   // public static void main(String[] args) {

 /*       Sound sound =
            new Sound("");


        InputStream stream =
            new ByteArrayInputStream(sound.getSamples());


        sound.play(stream);


        System.exit(0);
 */

   // }



    private AudioFormat format;
    private byte[] samples;


    public Sound(String f) {
        try {

            AudioInputStream stream =
                AudioSystem.getAudioInputStream(
                new File(f));

            format = stream.getFormat();


            samples = getSamples(stream);
        }
        catch (UnsupportedAudioFileException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    public byte[] getSamples() {
        return samples;
    }



    private byte[] getSamples(AudioInputStream audioStream) {

        int length = (int)(audioStream.getFrameLength() *
            format.getFrameSize());


        byte[] samples = new byte[length];
        DataInputStream is = new DataInputStream(audioStream);
        try {
            is.readFully(samples);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }


        return samples;
    }



    public void play(InputStream source) {


        int bufferSize = format.getFrameSize() *
            Math.round(format.getSampleRate() / 10);
        byte[] buffer = new byte[bufferSize];


        SourceDataLine line;
        try {
            DataLine.Info info =
                new DataLine.Info(SourceDataLine.class, format);
            line = (SourceDataLine)AudioSystem.getLine(info);
            line.open(format, bufferSize);
        }
        catch (LineUnavailableException ex) {
            ex.printStackTrace();
            return;
        }


        line.start();


        try {
            int numBytesRead = 0;
            while (numBytesRead != -1) {
                numBytesRead =
                    source.read(buffer, 0, buffer.length);
                if (numBytesRead != -1) {
                   line.write(buffer, 0, numBytesRead);
                }
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }


        line.drain();


        line.close();

    }

}

