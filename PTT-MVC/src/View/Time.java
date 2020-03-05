package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Time {
	public Time(JLabel timeLabel) {
		timeLabel.setFont(new Font("TimesRoman", Font.BOLD, 23));
		timeLabel.setForeground(new Color(30, 144, 255));
		Timer tmr = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long timeMillis = System.currentTimeMillis();
				SimpleDateFormat df = new SimpleDateFormat(" dd/MM/yyyy  HH:mm:ss");
				timeLabel.setText(df.format(new Date(timeMillis)));	
			}
		});
		tmr.start();
	}
}

