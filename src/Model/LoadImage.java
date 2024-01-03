package Model;

import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class LoadImage {
	public HashMap<String, Image> mapImg;

	public LoadImage() {
		mapImg = new HashMap<>();
		ClassLoader classLoader = LoadImage.class.getClassLoader();
		Image i1 = new ImageIcon(classLoader.getResource("img/chotden.png")).getImage();
		Image i2 = new ImageIcon(classLoader.getResource("img/chotdo.png")).getImage();
		Image i3 = new ImageIcon(classLoader.getResource("img/maden.png")).getImage();
		Image i4 = new ImageIcon(classLoader.getResource("img/mado.png")).getImage();
		Image i5 = new ImageIcon(classLoader.getResource("img/phaoden.png")).getImage();
		Image i6 = new ImageIcon(classLoader.getResource("img/phaodo.png")).getImage();
		Image i7 = new ImageIcon(classLoader.getResource("img/siden.png")).getImage();
		Image i8 = new ImageIcon(classLoader.getResource("img/sido.png")).getImage();
		Image i9 = new ImageIcon(classLoader.getResource("img/tuongden.png")).getImage();
		Image i10 = new ImageIcon(classLoader.getResource("img/tuongdo.png")).getImage();
		Image i11 = new ImageIcon(classLoader.getResource("img/voiden.png")).getImage();
		Image i12 = new ImageIcon(classLoader.getResource("img/voido.png")).getImage();
		Image i13 = new ImageIcon(classLoader.getResource("img/xeden.png")).getImage();
		Image i14 = new ImageIcon(classLoader.getResource("img/xedo.png")).getImage();
		Image i15 = new ImageIcon(classLoader.getResource("img/canmove.png")).getImage();
		Image i16 = new ImageIcon(classLoader.getResource("img/select.png")).getImage();
		Image i17 = new ImageIcon(classLoader.getResource("img/background.png")).getImage();
		mapImg.put("p", i1);
		mapImg.put("P", i2);
		mapImg.put("k", i3);
		mapImg.put("K", i4);
		mapImg.put("c", i5);
		mapImg.put("C", i6);
		mapImg.put("g", i7);
		mapImg.put("G", i8);
		mapImg.put("a", i9);
		mapImg.put("A", i10);
		mapImg.put("b", i11);
		mapImg.put("B", i12);
		mapImg.put("r", i13);
		mapImg.put("R", i14);
		mapImg.put("canmove", i15);
		mapImg.put("select", i16);
		mapImg.put("background", i17);
	}

}
