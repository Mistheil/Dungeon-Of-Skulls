import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
public class game {
	JFrame mainwindow;
	Container cont;
	JPanel title, startPanel, mainPanel, choicePanel, statsPanel, progressPanel;
	JLabel titleName, titleName2, health, healthNum, weapon, weaponType, completion;
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea textArea;
	JProgressBar gameProgress;
	Color tosca, maroon, crimson, blood, black_red, gold, boneWhite, mossGreen, darkGreen, darkGray, navy, dongker, brown, dark_brown, coal_black,pink, yellow;
	Boolean b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29,b30,b31;
	Stack<String> playerHPBar = new Stack<String>();
	int playerHP, visited, deal, progress;
	double strength, monsterHP, bossHP, damage;
	String playerWeapon, position, healthBar, filepath;
	Font titleFont = new Font("Courier New", Font.ITALIC, 60);
	Font titleFont2 = new Font("Courier New", Font.PLAIN, 30);
	Font startFont = new Font("Courier New", Font.PLAIN, 35);
	Font normalFont = new Font("Courier New", Font.PLAIN, 24);
	musicStuff audio = new musicStuff();
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	public static void main(String[] args) {
		
		new game();

	}
	
	public game() {
		tosca     = new Color(9, 215, 164)  ;    //Tosca green
		maroon    = new Color(179, 0, 0)    ;    //maroon
		crimson   = new Color(128, 0, 0)    ;    //Crimson
		blood	  = new Color(77, 0, 0)     ;    //Blood
		black_red = new Color(26, 0, 0) 	;    //Red Tinted Black
		gold      = new Color(225, 171, 81) ;    //gold
		boneWhite = new Color(247, 245, 238);    //Bone White
		mossGreen = new Color(38, 77, 0)    ;    //Moss Green
		darkGray  = new Color(50, 50, 50)   ;    //Dark Gray
		navy      = new Color(44, 44, 101)  ;    //Navy
		brown     = new Color(179, 92, 0)   ;    //Brown
		dark_brown= new Color(77, 40, 0)    ;    //Dark Brown
		coal_black= new Color(26, 26, 26)   ;    //Coal Black
		dongker   = new Color(0, 23, 77)	;    //Dongker blue
		darkGreen = new Color(18, 57, 0)	;    //Dark Green
		pink	  = new Color(250, 184, 234);	 //pink
		yellow   = new Color(255, 255, 77) ; 	 //yellow
		
		b1 = false;b2 = false;b3 = false;b4 = false;b5 = false;b6 = false;b7 = false;b8 = false;b9 = false;b10 = false;
		b11 = false;b12 = false;b13 = false;b14 = false;b15 = false;b16 = false;b17 = false;b18 = false;b19 = false;b20 = false;
		b1 = false;b21 = false;b22 = false;b23 = false;b24 = false;b25 = false;b26 = false;b27 = false;b28 = false;b29 = false;b30 = false;
		b31 = false;  //bool buat completion bar
		
		mainwindow = new JFrame();		//Main Window
		mainwindow.setSize(800, 600);
		mainwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainwindow.getContentPane().setBackground(Color.lightGray);
		mainwindow.setLayout(null);
		mainwindow.setVisible(true);
		cont = mainwindow.getContentPane();
		
		
		title = new JPanel();		//Title
		title.setBounds(50, 100, 665, 130);
		title.setBackground(Color.black);
		titleName = new JLabel("Dungeon of Skulls");
		titleName2 = new JLabel("Adventure CYOA Game");
		titleName.setForeground(Color.white);
		titleName2.setForeground(tosca);
		titleName.setFont(titleFont);
		titleName2.setFont(titleFont2);
		title.add(titleName);
		title.add(titleName2);
		
		startPanel = new JPanel();		//Start Button
		startPanel.setBounds(180, 400, 400, 100);
		startPanel.setBackground(Color.lightGray);
		startButton = new JButton(" Begin Your Journey ");
		startButton.setBackground(Color.black);
		startButton.setForeground(tosca);
		startButton.setFont(startFont);
		startButton.setFocusPainted(false);
		startButton.addActionListener(tsHandler);
		startPanel.add(startButton);
		

		cont.add(title);		//Container
		cont.add(startPanel);
	}
	
	public void gameScreen() {
		title.setVisible(false);		//menghilangkan panel sebelumnya
		startPanel.setVisible(false);
		
		mainPanel = new JPanel();  //Text area
		mainPanel.setBounds(65, 100, 650, 270);
		mainPanel.setBackground(Color.blue);
		cont.add(mainPanel);
		
		textArea = new JTextArea("Your Adventure Awaits!"); //text area
		textArea.setBounds(65, 100, 650, 250);
		textArea.setBackground(Color.black);
		textArea.setForeground(Color.white);
		textArea.setFont(normalFont);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		mainPanel.add(textArea);
		
		progressPanel = new JPanel(); //Completion Bar
		progressPanel.setBounds(180,521,600,30);
		progressPanel.setBackground(Color.black);
		progressPanel.setLayout(new GridLayout(1,2));
		cont.add(progressPanel);
		
		completion = new JLabel("Completion Progress: ");
		completion.setFont(normalFont);
		completion.setForeground(Color.white);
		progressPanel.add(completion);
		progress = 0;
		gameProgress = new JProgressBar(0,31);
		gameProgress.setValue(progress);
		gameProgress.setStringPainted(true);
		gameProgress.setBackground(boneWhite);
		gameProgress.setFont(normalFont);
		gameProgress.setForeground(coal_black);
		
		progressPanel.add(gameProgress);
		
		choicePanel = new JPanel();  //Choices Button
		choicePanel.setBounds(150, 370, 500, 130);
		choicePanel.setBackground(Color.red);
		choicePanel.setLayout(new GridLayout(4, 1));
		cont.add(choicePanel);
		
		choice1 = new JButton("Pilihan 1");
		choice1.setBackground(coal_black);
		choice1.setForeground(boneWhite);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choicePanel.add(choice1);
		choice2 = new JButton("Pilihan 2");
		choice2.setBackground(coal_black);
		choice2.setForeground(boneWhite);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choicePanel.add(choice2);
		choice3 = new JButton("Pilihan 3");
		choice3.setBackground(coal_black);
		choice3.setForeground(boneWhite);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choicePanel.add(choice3);
		choice4 = new JButton("Pilihan 4");
		choice4.setBackground(coal_black);
		choice4.setForeground(boneWhite);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choicePanel.add(choice4);
		
		statsPanel = new JPanel();  //Health and weapon bar
		statsPanel.setBounds(40, 15, 700, 50);
		statsPanel.setBackground(Color.red);
		statsPanel.setLayout(new GridLayout(1, 4));
		cont.add(statsPanel);
		health = new JLabel(" Health:");
		health.setFont(normalFont);
		health.setForeground(Color.white);
		statsPanel.add(health);
		healthNum = new JLabel("");
		healthNum.setFont(normalFont);
		healthNum.setForeground(Color.white);
		statsPanel.add(healthNum);
		weapon = new JLabel("Senjata:");
		weapon.setFont(normalFont);
		weapon.setForeground(Color.white);
		statsPanel.add(weapon);
		weaponType = new JLabel();
		weaponType.setFont(normalFont);
		weaponType.setForeground(Color.white);
		statsPanel.add(weaponType);
		
		playerSetup();	
	}
	
	public void playerSetup() {  //Startup Stat
		playerHP = 10;
		for (int n = 0 ; n < playerHP ; n++) {
			playerHPBar.push("|");
		}
		healthBar = String.join("", playerHPBar);
		strength = 2;
		monsterHP = 250;
		bossHP = 700;
		healthNum.setText(healthBar);
		playerWeapon = "Pedang Tua";
		weaponType.setText(playerWeapon);
		visited = 0;
		deal = 0;
		start1();
	}
	
	public static double dmg() {  //Random Damage
		double x = Math.random();
		return x;
	}
	
	public void class1() {
		position = "class1";
		textArea.setText("Menurut kamu,\nkamu lebih cocok menjadi?");
	}
	
	public void start1() {
		position = "start1"; //Start
		mainwindow.getContentPane().setBackground(brown);
		choicePanel.setBackground(brown);
		mainPanel.setBackground(Color.LIGHT_GRAY);
		textArea.setBackground(Color.LIGHT_GRAY);
		statsPanel.setBackground(Color.LIGHT_GRAY);
		textArea.setForeground(coal_black);
		health.setForeground(coal_black);
		healthNum.setForeground(coal_black);
		weapon.setForeground(coal_black);
		weaponType.setForeground(coal_black);
		textArea.setText("Kamu berdiri tangguh. Didepan sebuah gua\ndengan hawa yang mencekam . . . \nKamu adalah seorang penjelajah yang sangat\ntergiur dengan hidup penuh kekayaan.\nDan akhirnya kamu sampai didepan goa\nmenyeramkan ini.\nRumor mengatakan goa ini menyimpan banyak\nrahasia.");
		choice1.setText("Next");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}

	public void start2() {
		position = "start2";
		textArea.setText("Apakah kamu akan menemukan harta yang megah?\nAtau apakah kamu akan menemukan akhir dari\npetualanganmu?\n\nMari kita jelajahi!");
		choice1.setText("Semangat!");
	}
	
	
	public void start3() {
		position = "start3";
		mainwindow.getContentPane().setBackground(dark_brown);
		choicePanel.setBackground(dark_brown);
		mainPanel.setBackground(darkGray);
		textArea.setBackground(darkGray);
		statsPanel.setBackground(darkGray);
		textArea.setForeground(boneWhite);
		health.setForeground(boneWhite);
		healthNum.setForeground(boneWhite);
		weapon.setForeground(boneWhite);
		weaponType.setForeground(boneWhite);
		textArea.setText("Kamu menginjakkan langkahmu kedalam\ndan kamu menemukan gua tersebut bercabang\nmenjadi 2 lorong\n\nKamu memilih untuk kearah?");
		choice1.setText("Rute 1");
		choice2.setText("Rute 2");
		choice3.setText("Rute 3");
		choice4.setText("Rute 4");
		choice2.setVisible(true);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	
	public void lorong1_1() {
		position = "lorong1_1";  //first branch
		mainwindow.getContentPane().setBackground(navy); //mengubah warna window
		choicePanel.setBackground(navy); //mengubah warna JPanel tombol
		mainPanel.setBackground(coal_black); //mengubah warna JPanel text
		textArea.setBackground(coal_black); //mengubah warna belakang text area
		statsPanel.setBackground(coal_black); // mengubah warna belakang panel stats
		textArea.setForeground(boneWhite);  //mengubah warna text pada text area
		health.setForeground(boneWhite);  //mengubah warna text pada  nyawa
		healthNum.setForeground(boneWhite);  //mengubah warna text pada jumlah nyawa
		weapon.setForeground(boneWhite);  //mengubah warna text pada senjata
		weaponType.setForeground(boneWhite);  //mengubah warna text pada jenis senjata
		if (b1 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b1 = true;
		}
		textArea.setText("Kamu memilih untuk menjelajahi lorong paling kiri. .\nMelewati lorong yang gelap gulita, akhirnya\nkamu menemukan sumber cahaya di ujung\nlorong. Kamu mengejar cahaya tersebut.");
		choice1.setText("Uwau");  //menentukan text pada tombol
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice2.setVisible(false);  //menghilangkan atau memunculkan tombol pada GUI
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	
	public void lorong1_2() {
		position = "lorong1_2";
		textArea.setText("Di ruangan tersebut, berdiri makhluk hitam\ntertutupi penuh dengan bulu.\nSuara pijakan kakimu\nmembuat dia menyadari keberadaanmu.");
		choice1.setText("Ew. . .");
	}
	
	public void lorong1_2_2() {
		filepath = "Stare.wav";
		audio.playMusic(filepath);
		position = "lorong1_2_2";
		textArea.setText("Mata makhluk tersebut menyala merah\ndan sepertinya kamu harus melawannya untuk\nbertahan hidup. . .");
		choice1.setText("[Battle Start!]");
	}
	
	public void lorong1_2_battle() {
		position = "lorong1_2_battle";
		if (b2 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b2 = true;
		}
		textArea.setText("Kamu meyiapkan senjatamu, siap menebas makhluk\ntersebut.");
		choice1.setText("Serang!");
	}
	
	public void lorong1_2_battle_attack() {
		filepath = "Slash3.wav";
		audio.playMusic(filepath);
		position = "lorong1_2_battle_attack";
		damage = dmg() * strength * 100;
		monsterHP = monsterHP - damage;
		textArea.setText("Kamu menyerang makhluk tersebut\nmenggunakan " + playerWeapon + "-mu.\n\nKamu menyerang sebesar " + Math.round(damage) + "\nNyawa makhluk tersebut : " + Math.round(monsterHP));
		choice1.setText("Next");
	}
	
	public void lorong1_2_battle_attacked() {
		filepath = "Damage3.wav";
		audio.playMusic(filepath);
		position = "lorong1_2_battle_attacked";
		playerHP = playerHP - 1;
		playerHPBar.pop();
		healthBar = String.join("", playerHPBar);
		healthNum.setText(healthBar);
		textArea.setText("Kamu terserang oleh makhluk tersebut!");
		choice1.setText("Next");
	}
	
	public void lorong1_2_event() {
		filepath = "Monster5.wav";
		audio.playMusic(filepath);
		if (b3 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b3 = true;
		}
		position = "lorong1_2_event";
		mainwindow.getContentPane().setBackground(dongker);
		choicePanel.setBackground(dongker);
		textArea.setText("Tebasan terakhir darimu melontarkan makhluk\ntersebut jauh darimu.\nMakhluk tersebut meraung dan kemudian meluncur\nke dirimu.\n\nApa yang kamu lakukan?");
		choice1.setText("Melawan dia balik secara lansung");
		choice2.setText("Menghindar");
		choice3.setText("Mempertahankan posisimu.");
		choice2.setVisible(true);
		choice3.setVisible(true);
	}
	
	public void lorong1_2_event_2() {
		filepath = "Evasion1.wav";
		audio.playMusic(filepath);
		if (b4 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b4 = true;
		}
		position = "lorong1_2_event_2";
		textArea.setText("Kamu menggeserkan posisimu, menghindar dari\nserangan makhluk tersebut.\nSelagi lengah, kamu menebas makhluk tersebut\ndari belakang.\nMonster tersebut merintih kesakitan, kemudian runtuh menjadi tumpukan bulu yang menjijikan.");
		choice1.setText("Next");
		choice2.setText("");
		choice3.setText("");
		choice2.setVisible(false);
		choice3.setVisible(false);
	}
	
	public void lorong1_2_event_3() {
		filepath = "Item1.wav";
		audio.playMusic(filepath);
		position = "lorong1_2_event_3";
		strength = strength + 1;
		textArea.setText("Dibalik bulu tersebut, kamu menemukan\n sesuatu yang mengkilap. Kamu menggerogoh\ntumpukan bulu tersebut,\ndan menemukan sebuah liontin merah.\nKamu memilih untuk menggunakan liontin\ntersebut.\n\n[Kamu merasa tambah kuat!]");
		choice1.setText("Next");
	}
	
	public void lorong1_2_defeat1() {
		position = "lorong1_2_defeat1";
		textArea.setText("Tidak kuat melawan monster tersebut,\nkamu akhirnya dibanting tanpa ampun oleh monster tersebut.\nKeberadaan tubuhmu sudah tidak bisa ditebak.");
		choice1.setText("Next");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(false);
		choice3.setVisible(false);
	}
	
	public void lorong1_2_defeat2() {	
		position = "lorong1_2_defeat2";
		if (b5 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b5 = true;
		}
		textArea.setText("Kamu mencoba menangkis serangannya,\ntetapi kamu kalah cepat dengannya.\nYang kamu tau lengannya sudah mencapai tubuhmu\ndan mewarnai tubuhmu dan lantai dengan merah\npekat.");
		choice1.setText("Next");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(false);
		choice3.setVisible(false);
	}
	
	public void lorong1_2_defeat3() {
		filepath = "Parry.wav";
		audio.playMusic(filepath);
		if (b6 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b6 = true;
		}
		position = "lorong1_2_defeat3";
		textArea.setText("Kamu berusaha menahan serangannya,\ntetapi monster tersebut menyerang terus\nmenerus tanpa ampun.\nPerlahan pertahananmu pecah dan badanmu\nterlontar, menabrak dinding . . .");
		choice1.setText("Ugh...");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(false);
		choice3.setVisible(false);
	}
	
	public void lorong1_3() {
		position = "lorong1_3";
		if (b7 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b7 = true;
		}
		textArea.setText("Kamu melanjutkan perjalanmu, melewati lorong\nyang gelap.\nKamu menemukan jalan yang bercabang\nke dua arah.\n\nApa yang kamu lakukan?");
		choice1.setText("Lewat lorong kiri");
		choice2.setText("Lewat lorong kanan");
		choice3.setText("");
		choice2.setVisible(true);
	}
	
	public void lorong1_3_kiri() {
		position = "lorong1_3_kiri";
		visited = 1;
		if (b8 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b8 = true;
		}
		textArea.setText("Kamu memilih untuk kearah kiri . . .\n\nMenyusuri dinding, kamu menemukan jalan buntu dengan harta karun.\nApakah kamu ingin membukanya?");
		choice1.setText("Iya");
		choice2.setText("Tidak");
	}
	
	public void lorong1_3_kiri_2() {
		filepath = "Heal5.wav";
		audio.playMusic(filepath);
		position = "lorong1_3_kiri_2";
		playerHP = playerHP + 5;
		for (int n = 0; n < 5 ; n++) {
			playerHPBar.push("|");
		}
		healthBar = String.join("", playerHPBar);
		healthNum.setText(healthBar);
		if (b9 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b9 = true;
		}
		textArea.setText("Kamu membuka kotak terebut,\ndan kamu menemukan beberapa keping emas\ndan botol berisi cairan merah.\nKamu memilih untuk minum cairan tersebut...\n[Kamu merasa tambah sehat!]\nKamu kembali ke lorong sebelumnya . . .");
		choice1.setText("Next");
		choice2.setText("");
		choice2.setVisible(false);
	}
	
	public void lorong1_3_kiri_3() {
		position = "lorong1_3_kiri_3";
		if (b10 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b10 = true;
		}
		textArea.setText("Kamu memilih untuk tidak membuka kotak tersebut.\nKamu takut kotak tersebut berisi perangkap\n\nKamu memilih untuk kembali . . .");
		choice1.setText("Next");
		choice2.setText("");
		choice2.setVisible(false);
	}
	
	public void lorong1_3_kiri2() {
		position = "lorong1_3_kiri2";
		if (b11 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b11 = true;
		}
		textArea.setText("Kamu sudah menemukan jalan tersebut buntu,\ndan mengurungkan niat untuk kembali kesana. . .");
		choice1.setText("Next");
		choice2.setText("");
		choice1.setVisible(true);
		choice2.setVisible(false);
	}
	
	public void lorong1_3_kanan() {
		position = "lorong1_3_kanan";
		if (b12 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b12 = true;
		}
		textArea.setText("Kamu memilih untuk kearah kanan . . .\nBerjalan menyusuri lorong yang gelap, kamu\nmerasa lorong ini tidak ada habisnya.\nTapi akhirnya kamu menemukan sumber cahaya.\nKamu mengejar sumber tersebut . . .");
		choice1.setText("Next");
		choice2.setText("");
		choice1.setVisible(true);
		choice2.setVisible(false);
	}
	
	public void lorong1_3_kanan_2() {
		position = "lorong1_3_kanan_2";
		textArea.setText("Menyusuri lorong tersebut, badanmu\nterasa sangat berat.\nTetapi dengan penuh tekad dan nyali, akhirnya kamu menemukan jalan keluar.");
		choice1.setText("Next");
	}
	
	public void lorong2_1() {  //Second Branch
		filepath = "Darkness.wav";
		audio.playMusic(filepath);
		position = "lorong2_1";
		mainwindow.getContentPane().setBackground(mossGreen);
		choicePanel.setBackground(mossGreen);
		mainPanel.setBackground(coal_black);
		textArea.setBackground(coal_black);
		statsPanel.setBackground(coal_black);
		textArea.setForeground(boneWhite);
		health.setForeground(boneWhite);
		healthNum.setForeground(boneWhite);
		weapon.setForeground(boneWhite);
		weaponType.setForeground(boneWhite);
		visited = 1;
		if (b13 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b13 = true;
		}
		textArea.setText("Kamu memilih untuk melewati rute kedua.\nMelihat lorong yang gelap gulita dengan minim cahaya,\nkamu memberanikan dirimu melewati\njalan tersebut.\nGemetaran sambil memegang senjatamu ditangan,\nkamu tidak merasa sendiri disini. . .");
		choice1.setText("Seram. . .");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	
	public void lorong2_1_2() {
		position = "lorong2_1_2";
		textArea.setText("Kamu sudah melihat apa didalam sana!\nKamu enggan untuk melewati rute itu lagi . . .");
		choice1.setText("Gamau lagi!");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
		
	}
	
	public void lorong2_2() {
		filepath = "Open5.wav";
		audio.playMusic(filepath);
		position = "lorong2_2";
		textArea.setText("Walaupun gelap, akhirnya kamu menemukan akhir lorong itu.\nSebuah pintu berdiri didepan keberadaanmu,\nkamu memilih untuk membuka\npintu didepanmu . . .");
		choice1.setText("Akhirnya");
	}
	
	public void lorong2_2_1() {
		position = "lorong2_2_1";
		textArea.setText("Ruangan tersebut juga tidak kalah gelapnya,\ndengan beberapa obor menyala kecil.\nKamu merasakan ruangan ini sangatlah besar,\ntetapi kamu juga merasakan . . .\nKalau kamu tidak sendiri di ruangan ini. . .");
		choice1.setText(". . .");
	}
	
	public void lorong2_2_2() {
		position = "lorong2_2_2";
		textArea.setText("Kamu merasakan adanya gerakan di\nruangan tersebut.\nTetapi kamu tidak tahu apa itu.\nAtau mereka, lebih tepatnya . . .");
		choice1.setText("Eughh. . .");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	
	public void lorong2_2_3() {
		filepath = "Fire1.wav";
		audio.playMusic(filepath);
		if (b14 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b14 = true;
		}
		position = "lorong2_2_3";
		textArea.setText("Seketika obor di ruangan tersebut\nmenjadi lebih terang,\ndan memperlihatkan isi dari ruangan tersebut.\nBelasan. Tidak, puluhan kadal kuning\nmengerumuni ruangan ini!\nPintu keluar juga terlihat sangat jauh. . .\nApa yang kamu lakukan?");
		choice1.setText("Melarikan diri!");
		choice2.setText("Lari ke ujung ruangan");
		choice3.setText("Mempertahankan diri");
		choice4.setText("Bunuh semua kadal");
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
	}
	
	public void lorong2_2_run() {
		filepath = "Move.wav";
		audio.playMusic(filepath);
		if (b15 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b15 = true;
		}
		position = "lorong2_2_run";
		textArea.setText("'Tidak mungkin aku bisa bertahan hidup\nmelewati ini semua!'\nPikir dirimu. Ketakutan, kamu lansung balik\nbadan, dan melarikan diri sekuat tenagamu.\nTerkadang kamu menabrak dinding karena\nkamu kurang fokus,\ntetapi akhirnya kamu kembali ke awal lagi.\n[Kamu memilih untuk tidak kembali kesini.]");
		choice1.setText("Ogah!");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	
	public void lorong2_2_defeat() {
		filepath = "Bite.wav";
		audio.playMusic(filepath);
		if (b16 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b16 = true;
		}
		position = "lorong2_2_defeat";
		textArea.setText("Kamu berpikir kamu dapat lari lebih cepat\ndibanding kadal ini,\njadi kamu mencoba untuk lari lansung ke ujung ruangan ini.\nSayangnya kamu menyepelekan kadal-kadal ini.\nTidak kamu sadari kakimu tergigit\noleh salah satu kadalnya.\nKamu terjatuh, dan siap menjadi\nsantapan kadal-kadal tersebut . . .");
		choice1.setText(". . .");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	
	public void lorong2_2_decimate() {
		filepath = "Kolleps.wav";
		audio.playMusic(filepath);
		if (b17 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b17 = true;
		}
		position = "lorong2_2_decimate";
		textArea.setText("Tebasan pertama, kadal pertama mati.\nKamu mulai siap untuk menghitung mayat\nyang akan bergelimpangan,\n maupun salah satu dari\nmayat tersebut adalah dirimu.\nKadal kedua, ketiga, dan keempat tumbang.\nKadal-kadal tersebut mulai berhamburan.\nAda yang siap menyerang dirimu, ada yang\nberlari-lari menjauh. Kamu tidak peduli.");
		choice1.setText("Terus. . .");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	
	public void lorong2_2_decimate_2() {
		filepath = "Kolleps.wav";
		audio.playMusic(filepath);
		position = "lorong2_2_decimate_2";
		mainwindow.getContentPane().setBackground(maroon);
		choicePanel.setBackground(maroon);
		mainPanel.setBackground(coal_black);
		textArea.setBackground(coal_black);
		statsPanel.setBackground(coal_black);
		textArea.setForeground(maroon);
		health.setForeground(maroon);
		healthNum.setForeground(maroon);
		weapon.setForeground(maroon);
		weaponType.setForeground(maroon);
		choice1.setBackground(coal_black);
		choice1.setForeground(maroon);
		choice2.setBackground(coal_black);
		choice2.setForeground(maroon);
		choice3.setBackground(coal_black);
		choice3.setForeground(maroon);
		choice4.setBackground(coal_black);
		choice4.setForeground(maroon);
		playerHP = playerHP - 1;
		playerHPBar.pop();
		healthBar = String.join("", playerHPBar);
		healthNum.setText(healthBar);
		textArea.setText("Kamu mulai berhenti menghitung pada\nkorban ke-20. Tidak ada gunanya.\nKadal-kadal terebut juga sedang sibuk\nmengerumuni dirimu, menyerangi dirimu\njika ada kesempatan.\nTubuhmu mulai serasa kaku\ndari racun mereka tapi tak apa.\nSELAMA DIRIMU MASIH BISA BERDIRI TEGAR ! ! !");
		choice1.setText("Lagi. . .");
	}
	
	public void lorong2_2_decimate_3() {
		filepath = "Kolleps.wav";
		audio.playMusic(filepath);
		if (b18 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b18 = true;
		}
		position = "lorong2_2_decimate_3";
		playerHP = playerHP - 1;
		playerHPBar.pop();
		healthBar = String.join("", playerHPBar);
		healthNum.setText(healthBar);
		textArea.setText("Kelima indra mu sudah mulai terasa hambar.\nPikiranmu kosong, kamu hanya berpikir kapan\nsemua makhluk ini akan mati.\n\nTiada habisnya,terus menerus bergelimpangan.");
		choice1.setText("Habiskan. . .");
	}
	
	public void lorong2_2_decimate_4() {
		filepath = "Kolleps.wav";
		audio.playMusic(filepath);
		position = "lorong2_2_decimate_4";
		mainwindow.getContentPane().setBackground(crimson);
		choicePanel.setBackground(crimson);
		mainPanel.setBackground(coal_black);
		textArea.setBackground(coal_black);
		statsPanel.setBackground(coal_black);
		textArea.setForeground(maroon);
		health.setForeground(maroon);
		healthNum.setForeground(maroon);
		weapon.setForeground(maroon);
		weaponType.setForeground(maroon);
		choice1.setForeground(maroon);
		choice2.setForeground(maroon);
		choice3.setForeground(maroon);
		choice4.setForeground(maroon);
		playerHP = playerHP - 1;
		playerHPBar.pop();
		healthBar = String.join("", playerHPBar);
		healthNum.setText(healthBar);
		textArea.setText("  D a n   t e r u s . . .");
		choice1.setText("");
		choice2.setText("B u n u h . . .");
		choice1.setVisible(false);
		choice2.setVisible(true);
	}
	
	public void lorong2_2_decimate_5() {
		filepath = "Kolleps.wav";
		audio.playMusic(filepath);
		position = "lorong2_2_decimate_5";
		mainwindow.getContentPane().setBackground(blood);
		choicePanel.setBackground(blood);
		mainPanel.setBackground(coal_black);
		textArea.setBackground(coal_black);
		statsPanel.setBackground(coal_black);
		textArea.setForeground(crimson);
		health.setForeground(crimson);
		healthNum.setForeground(crimson);
		weapon.setForeground(crimson);
		weaponType.setForeground(crimson);
		choice1.setForeground(crimson);
		choice2.setForeground(crimson);
		choice3.setForeground(crimson);
		choice4.setForeground(crimson);
		playerHP = playerHP - 1;
		playerHPBar.pop();
		healthBar = String.join("", playerHPBar);
		healthNum.setText(healthBar);
		textArea.setText("  M e n e r u s . . .");
		choice2.setText("");
		choice3.setText("B u n u h . . .");
		choice2.setVisible(false);
		choice3.setVisible(true);
	}
	
	public void lorong2_2_decimate_6() {
		filepath = "Kolleps.wav";
		audio.playMusic(filepath);
		position = "lorong2_2_decimate_6";
		if (b19 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b19 = true;
		}
		mainwindow.getContentPane().setBackground(black_red);
		choicePanel.setBackground(black_red);
		mainPanel.setBackground(black_red);
		textArea.setBackground(black_red);
		statsPanel.setBackground(black_red);
		textArea.setForeground(maroon);
		health.setForeground(black_red);
		healthNum.setForeground(black_red);
		weapon.setForeground(black_red);
		weaponType.setForeground(black_red);
		choice1.setForeground(maroon);
		choice2.setForeground(maroon);
		choice3.setForeground(maroon);
		choice4.setForeground(maroon);
		choice4.setBackground(black_red);
		playerHP = playerHP - 1;
		playerHPBar.pop();
		healthBar = String.join("", playerHPBar);
		healthNum.setText(healthBar);
		textArea.setText("  S A M P A I\n  S E M U A N Y A\n  L E N Y A P . . .");
		choice3.setText("");
		choice4.setText("B u n u h . . .");
		choice3.setVisible(false);
		choice4.setVisible(true);
	}
	
	public void lorong2_2_devil() {
		position = "lorong2_2_devil";
		if (b20 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b20 = true;
		}
		mainwindow.getContentPane().setBackground(crimson);
		choicePanel.setBackground(crimson);
		mainPanel.setBackground(coal_black);
		textArea.setBackground(coal_black);
		statsPanel.setBackground(coal_black);
		textArea.setForeground(boneWhite);
		health.setForeground(boneWhite);
		healthNum.setForeground(boneWhite);
		weapon.setForeground(boneWhite);
		weaponType.setForeground(boneWhite);
		choice1.setBackground(coal_black);
		choice1.setForeground(boneWhite);
		choice2.setBackground(coal_black);
		choice2.setForeground(boneWhite);
		choice3.setBackground(coal_black);
		choice3.setForeground(boneWhite);
		choice4.setBackground(coal_black);
		choice4.setForeground(boneWhite);
		textArea.setText("Seketika sebuah tepuk tangan tidak jauh\ndari dirimu terdengar,membuat kamu tersadarkan\ndari semua yang terjadi.\nKamu melihat ke sumber suara, dan menemukan\n 'seseorang' berdiri.");
		choice1.setText("Hah?");
		choice4.setText("");
		choice1.setVisible(true);
		choice4.setVisible(false);
	}
	
	public void lorong2_2_devil_2() {
		position = "lorong2_2_devil_2";
		textArea.setText("'Sebuah pertunjukkan yang sangat bagus kawan!' Teriak 'orang' tersebut.\n'kapan ya terakhir kali aku melihat\nperkelahian seseru itu? ah sudahlah'");
		choice1.setText("Siapa?");
	}
	
	public void lorong2_2_devil_3() {
		position = "lorong2_2_devil_3";
		textArea.setText("'Kamu pasti bertanya aku siapa kan? bilang\nsaja aku penghuni tempat ini . . .'\n'Aku tertarik denganmu kawan! Bagaimana\njika kita bertaruh?'");
		choice1.setText("Taruhan?");
	}
	
	public void lorong2_2_devil_4() {
		position = "lorong2_2_devil_4";
		textArea.setText("'Yep! Aku memiliki sedikit ''masalah'' dengan salah satu monster di tempat ini.'\n'Aku beri kamu kekuatan untuk melawannya, dan kekuatan itu untukmu.'");
		choice1.setText(". . .Tapi?");
	}
	
	public void lorong2_2_devil_5() {
		position = "lorong2_2_devil_5";
		textArea.setText("'Hahahahaha. Bisa saja ya kamu membaca pikiranku'\nDia tertawa terbahak-bahak.\n'Jika kamu gagal, tubuhmu buatku, bagaimana?'");
		choice1.setText("Yang benar saja!");
	}
	
	public void lorong2_2_devil_6() {
		position = "lorong2_2_devil_6";
		textArea.setText("'Ya. . .memang benar. Bagaimana? Deal?'\nkata dia sambil menjulurkan tangannya kepadamu\nSetelah melihat lebih detail dia tidak\nterlihat seperti manusia. Kamu segan\nuntuk berjabat . . .\nApa yang kamu lakukan?");
		choice1.setText("Terima");
		choice2.setText("Tolak");
		choice1.setVisible(true);
		choice2.setVisible(true);
	}
	
	public void lorong2_2_devil_accept() {
		filepath = "Devil1.wav";
		audio.playMusic(filepath);
		position = "lorong2_2_devil_accept";
		if (b21 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b21 = true;
		}
		strength = strength + 14;
		deal = 1;
		playerWeapon = "Janji setan";
		weaponType.setText(playerWeapon);
		textArea.setText("'Pilihan yang bagus kawan! Kamu tidak\nakan menyesali ini!'\nSebut dia, sambil menghentakkan kakinya.\nSeketika dibawah kakimu terbuka sebuah kerak, yang menyemprotkan gas merah ke tubuhmu.\n'Jangan lupa janji kita kawan!' sebut dia\nsambil tertawa licik dan menghilang.\n[Kamu merasa sangat kuat!!!!]");
		choice1.setText("Yes!");
		choice2.setText("");
		choice1.setVisible(true);
		choice2.setVisible(false);
	}
	
	public void lorong2_2_devil_decline() {
		position = "lorong2_2_devil_decline";
		if (b22 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b22 = true;
		}
		textArea.setText("'Yah. . .Sayang sekali kawan' kata dia sedih.\n'Kalau begitu aku tinggalkan tubuh sekaratmu\ndisini saja ya!'\n'Kamu tidak menyadari kamu masih bisa cukup\nsadar untuk berdiri karena aku?'\nKetika dia bilang itu, seketika\ntubuhmu tumbang.\n'Ketika kamu sudah meningggalkan tubuhmu,\nmungkin itu saatnya aku bekerja.'");
		choice1.setText("H..a.h..");
		choice2.setText("");
		choice1.setVisible(true);
		choice2.setVisible(false);
	}
	
	public void lorong2_2_defend() {
		position = "lorong2_2_defend";
		if (b23 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b23 = true;
		}
		mainwindow.getContentPane().setBackground(darkGreen);
		choicePanel.setBackground(darkGreen);
		textArea.setText("Memegang pedangmu dengan erat, kamu siap\nmenangkis setiap kadal yang akan menyerangmu.\nSecara sigap kamu berjalan menuju pintu keluar diujung ruangan secara pelan-pelan.\nSatu persatu kadal meluncur ke dirimu, kamu\ntebas tanpa ampun.");
		choice1.setText("Next");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	
	public void lorong2_2_defend_2() {
		filepath = "Bite.wav";
		audio.playMusic(filepath);
		position = "lorong2_2_defend_2";
		playerHP = playerHP - 2;
		playerHPBar.pop();
		playerHPBar.pop();
		healthBar = String.join("", playerHPBar);
		healthNum.setText(healthBar);
		textArea.setText("Tetapi kamu bukan penjelajah veteran juga,\nbeberapa luka gigit dan cakar terlihat\ndi pergelangan kaki dan lenganmu.\nKamu juga menyadari tubuhmu merasa kaku,\nsepertinya racun dari kadal tersebut . . .");
		choice1.setText("Next");
	}
	
	public void lorong2_2_defend_3() {
		filepath = "Bite.wav";
		audio.playMusic(filepath);
		position = "lorong2_2_defend_3";
		playerHP = playerHP - 3;
		playerHPBar.pop();
		playerHPBar.pop();
		playerHPBar.pop();
		healthBar = String.join("", playerHPBar);
		healthNum.setText(healthBar);
		textArea.setText("Pengelihatanmu sudah kabur, dan kamu\ntidak bisa merasakan tubuhmu lagi.\nTetapi akhirnya kamu berhasil mencapai pintu keluar.\nPanik, kamu terburu-buru untuk segera masuk\ndan menutup pintunya,\naman dari monster monster tersebut . . .");
		choice1.setText("Next");
	}
	
	public void lorong2_2_defend_4() {
		filepath = "Close1.wav";
		audio.playMusic(filepath);
		position = "lorong2_2_defend_4";
		playerHP = playerHP - 4;
		for (int n = 0; n < 4 ; n++) {
			playerHPBar.pop();
		}
		healthBar = String.join("", playerHPBar);
		healthNum.setText(healthBar);
		textArea.setText("Kamu sudah berhasil berada diluar ruangan\ntersebut. Secara instan tubuhmu\nterasa lemas . . .\nKamu beristirahat sejenak,\npelan-pelan rasa sakitnya mulai muncul.");
		choice1.setText("Next");
	}
	
	public void lorong2_2_defend_5() {
		filepath = "Heal5.wav";
		audio.playMusic(filepath);
		position = "lorong2_2_defend_5";
		if (b24 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b24 = true;
		}
		playerHP = playerHP + 4;
		for (int n = 0; n < 4 ; n++) {
			playerHPBar.push("|");
		}
		healthBar = String.join("", playerHPBar);
		healthNum.setText(healthBar);
		strength = strength + 5;
		playerWeapon = "Tombak tajam";
		weaponType.setText(playerWeapon);
		textArea.setText("Menjelang istirahat, kamu melihat sekitaran\ndirimu, dan kamu menemukan\nkotak lusuh di pojokan.\nDidalamnya kamu menemukan beberapa buah potion, yang segera kamu konsumsi semuanya.\nDisamping kotak itu juga ada tengkorak dengan tombak disampingnya,\nkamu memilih untuk mengambil tombak tersebut.\n[Nyawa dan kekuatanmu Bertambah!]");
		choice1.setText("Next");
	}
	
	public void lorong2_2_defend_6() {
		position = "lorong2_2_defend_6";
		textArea.setText("Sudah cukup lama kamu beristirahat.\nKamu melihat kembali kondisi tubuhmu dan\nsenjata barumu. Terakhir kalinya kamu melihat\npintu dibelakangmu,\nkamu melanjutkan perjalananmu kedalam . . .");
		choice1.setText("Next");
	}
	
	public void lorong3_1() {
		position = "lorong3_1";
		textArea.setText("Lorong tersebut terlihat sangat kasar\ndan tidak teratur.\nTetapi kamu memberanikan dirimu untuk melewati lorong tersebut.\nBanyak sekali batuan yang mencuat, membuat dirimu kesulitan\nuntuk melanjutkan perjalananmu.");
		choice1.setText("Duh. . .");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	
	public void lorong3_1_1() {
		position = "lorong3_1_1";
		textArea.setText("Beberapa kali kepala kamu terbentur dengan\natap lorong tersebut yang tidak beraturan.\nKamu hanya bisa berdoa tidak menabrak bongkahan batu besar didepanmu");
		choice1.setText("Agh. . .");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	
	public void lorong3_1_2() {
		position = "lorong3_1_2";
		textArea.setText("Lorong tersebut menyusut dan menyusut\nhingga");
		choice1.setText("Agh. . .");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	
	public void boss() {
		position = "boss";
		if (b25 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b25 = true;
		}
		textArea.setText("Kamu sampai di suatu goa raksasa, dengan obor yang redup menerangi goa tersebut.\nKamu merasa suatu keberadaan yang menyeramkan di goa tersebut. . .\n");
		choice1.setText("Next");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	
	public void boss_2() {
		filepath = "Down3.wav";
		audio.playMusic(filepath);
		position = "boss_2";
		textArea.setText("Seketika tanah bergemuruh, seperti pijakan\nkaki sesuatu yang sangat besar.\nKamu tidak mengantisipasi hal ini sama sekali...");
		choice1.setText("Next");
	}
	
	public void boss_3() {
		filepath = "Earth8.wav";
		audio.playMusic(filepath);
		position = "boss_3";
		textArea.setText("Tidak jauh dari dirimu, datang sebuah monster raksasa.\nSebuah tengkorak raksasa lengkap dengan\nperisai dan tameng.\n\nMungkin ini adalah pertarungan yang tidak bisa dihindarkan...");
		choice1.setText("[Battle Start!]");
	}
	
	public void boss_battle() {
		position = "boss_battle";
		if (b26 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b26 = true;
		}
		textArea.setText("Memegang senjata terpercayamu,\nkamu siap menyerang.");
		choice1.setText("Serang");
	}
	
	public void boss_battle_attack() {
		filepath = "Damage5.wav";
		audio.playMusic(filepath);
		position = "boss_battle_attack";
		damage = dmg() * strength * 100;
		bossHP = bossHP - damage;
		textArea.setText("Kamu menyerang monster tersebut\nmenggunakan " + playerWeapon + "-mu.\nKamu menyerang sebesar " + Math.round(damage) + "\nNyawa makhluk tersebut : " + Math.round(bossHP));
		choice1.setText("Next");
	}
	
	public void boss_battle_attacked() {
		filepath = "Damage3.wav";
		audio.playMusic(filepath);
		position = "boss_battle_attacked";
		playerHP = playerHP - 1;
		playerHPBar.pop();
		healthBar = String.join("", playerHPBar);
		healthNum.setText(healthBar);
		textArea.setText("Kamu terserang oleh makhluk tersebut!");
		choice1.setText("Ouch. . .");
	}
	
	public void boss_defeated() {
		position = "boss_defeated";
		if (b27 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b27 = true;
		}
		textArea.setText("Tubuhmu sudah sangat lemah untuk\n tetap menerima serangan selanjutnya dari monster tersebut.\nKamu mencoba untuk menangkis kembali serangan dari monster itu,\ntetapi dengan tidak ada tenaga, badanmu dengan mudah terlempar jauh.\nTanpa ampun,tubuhmu dihabiskan monster tersebut. . .");
		choice1.setText("Agh. . .");
	}
	
	public void boss_draw() {
		position = "boss_draw";
		textArea.setText("Badanmu lemah, dan tidak memiliki energi lagi.\nKamu melihat kearah monster tersebut,\ndan kamu melihat monster tersebut runtuh berkeping-keping.");
		choice1.setText(". . .");
	}
	
	public void boss_draw_2() {
		position = "boss_draw_2";
		textArea.setText("Badanmu sudah sangat rapuh,\nkamu menjatuhkan tubuhmu ke tanah.\nTerbaring lemas, kamu tersenyum\ndengan genggaman tanganmu melepaskan senjatamu perlahan . . .");
		choice1.setText("Istirahat . . .");
	}
	
	public void boss_win() {
		position = "boss_win";
		if (b28 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b28 = true;
		}
		mainwindow.getContentPane().setBackground(gold);
		choicePanel.setBackground(gold);
		mainPanel.setBackground(Color.lightGray);
		textArea.setBackground(Color.lightGray);
		statsPanel.setBackground(Color.lightGray);
		textArea.setForeground(coal_black);
		health.setForeground(coal_black);
		healthNum.setForeground(coal_black);
		weapon.setForeground(coal_black);
		weaponType.setForeground(coal_black);
		choice1.setBackground(Color.lightGray);
		choice1.setForeground(coal_black);
		choice2.setBackground(Color.lightGray);
		choice2.setForeground(coal_black);
		choice3.setBackground(Color.lightGray);
		choice3.setForeground(coal_black);
		choice4.setBackground(Color.lightGray);
		choice4.setForeground(coal_black);
		textArea.setText("Setelah pertarungan yang sangat sengit,\nkamu akhirnya melihat hasil dari kerja kerasmu.\nMonster tersebut, bergetar.\nSeperti tidak kuat untuk menahan tubuhnya\ntetap utuh...");
		choice1.setText("Demi apa?");
	}
	
	public void boss_win_2() {
		filepath = "Explosion3.wav";
		audio.playMusic(filepath);
		position = "boss_win_2";
		textArea.setText("Pelan pelan kamu melihat tubuhnya runtuh satu-persatu.\nDidepan matamu hanyalah seonggok tulang\nyang tidak bernyawa,\nbukti dari peperanganmu.\nKamu merasa campuran emosi antara senang,\nkagum, kaget, dan tidak percaya.");
		choice1.setText("Ini beneran?");
	}
	
	public void boss_win_3() {
		position = "boss_win_3";
		textArea.setText("Sebagai tanda kemenangan, kamu mengambil\npedang raksasa dari monster tersebut.\nMerangkulnya seperti sebuah piala.\nAkhirnya kamu melanjutkan perjalananmu . . .");
		choice1.setText("Yes! ! !");
	}
	
	public void boss_win_4() {
		position = "boss_win_4";
		textArea.setText("Pada perjalanan keluar, kamu menemukan ruangan penuh emas,\nharta dan mayat tengkorak!!!!\nTidak mempedulikan mayatnya,\nkamu merasa senang atas imbalan dari\nperjuanganmu.");
		choice1.setText("Aku kaya!");
	}
	
	public void boss_win_5() {
		position = "boss_win_5";
		textArea.setText("Kamu mengandai-andai bagaimana kehidupan\nkekayaaanmu sehabis ini...\n\nDirimu sebagai petualang berbakat! dan yang\njelas kaya raya!!\nKamu tertawa kepada dirimu sendiri . . .");
		choice1.setText("Hehehe. . .");
	}
	
	public void win() { 
		filepath = "Victory1.wav";
		audio.playMusic(filepath);
		position = "win";
		if (b29 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b29 = true;
		}
		for (int n = playerHP ; n>0 ; n--) {
			playerHPBar.pop();
		}
		healthBar = "Win!";
		playerWeapon = "Win!";
		weaponType.setText(playerWeapon);
		healthNum.setText(healthBar);
		textArea.setText("[Selamat! Kamu berhasil memenangkan permainan ini!]\n\nSilahkan coba rute dan kombinasi lain pada\npermainan ini!");
		choice1.setText("");
		choice2.setText("");
		choice3.setText("Credits");
		choice4.setText("Restart?");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice4.setVisible(true);
	}
	
	
	public void dead() {
		position = "dead";
		if (b30 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b30 = true;
		}
		mainwindow.getContentPane().setBackground(coal_black);
		choicePanel.setBackground(coal_black);
		mainPanel.setBackground(crimson);
		textArea.setBackground(crimson);
		statsPanel.setBackground(coal_black);
		textArea.setForeground(boneWhite);
		health.setForeground(boneWhite);
		healthNum.setForeground(boneWhite);
		weapon.setForeground(boneWhite);
		weaponType.setForeground(boneWhite);
		choice1.setBackground(coal_black);
		choice1.setForeground(boneWhite);
		choice2.setBackground(coal_black);
		choice2.setForeground(boneWhite);
		choice3.setBackground(coal_black);
		choice3.setForeground(boneWhite);
		choice4.setBackground(coal_black);
		choice4.setForeground(boneWhite);
		for (int n = playerHP ; n>0 ; n--) {
			playerHPBar.pop();
		}
		healthBar = "Dead";
		healthNum.setText(healthBar);
		playerWeapon = "Dead";
		weaponType.setText(playerWeapon);
		textArea.setText("Mayatmu terkulai lemas tidak bergerak...\nKamu mati!\n\nHidupmu sebagai penjelajah berakhir disini . . .");
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("Restart?");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(true);
	}
	
	public void dead_devil() {
		filepath = "Devil2.wav";
		audio.playMusic(filepath);
		position = "dead_devil";
		if (b31 == false) {
			progress = progress +1;
			gameProgress.setValue(progress);
			b31 = true;
		}
		mainwindow.getContentPane().setBackground(coal_black);
		choicePanel.setBackground(coal_black);
		mainPanel.setBackground(crimson);
		textArea.setBackground(crimson);
		statsPanel.setBackground(coal_black);
		textArea.setForeground(boneWhite);
		health.setForeground(boneWhite);
		healthNum.setForeground(boneWhite);
		weapon.setForeground(boneWhite);
		weaponType.setForeground(boneWhite);
		choice1.setBackground(coal_black);
		choice1.setForeground(boneWhite);
		choice2.setBackground(coal_black);
		choice2.setForeground(boneWhite);
		choice3.setBackground(coal_black);
		choice3.setForeground(boneWhite);
		choice4.setBackground(coal_black);
		choice4.setForeground(boneWhite);
		for (int n = playerHP ; n>0 ; n--) {
			playerHPBar.pop();
		}
		healthBar = "Missing";
		healthNum.setText(healthBar);
		playerWeapon = "Missing";
		weaponType.setText(playerWeapon);
		textArea.setText("Mayatmu terkulai lemas . . .Yang kemudian\nbergerak secara kasar!\nSetelah beberapa saat mayat tubuhmu berdiri,\ndan tertawa histeris.\nKemudian . . . Tubuhmu menghilang . . .\n[Kamu mati!]");
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("Restart?");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(true);
	}
	
	public class TitleScreenHandler implements ActionListener{  //Start Button
		
		public void actionPerformed(ActionEvent event) {
			
			gameScreen();
		}
	}
	
	public class ChoiceHandler implements ActionListener{  //Scenario Handler and picker
		public void actionPerformed(ActionEvent event) {
			
			String Choice = event.getActionCommand();
			
			switch(position) {
			case "start1":
				switch(Choice) {
				case "c1": start2(); break;
				}
				break;
			case "start2":
				switch(Choice) {
				case "c1": start3(); break;
				}
				break;
			case "start3":
				switch(Choice) {
				case "c1": lorong1_1(); break;
				case "c2":
					if (visited == 0) {lorong2_1();}
					else {lorong2_1_2();}
					break;
				}
				break;
			case "lorong1_1":
				switch(Choice) {
				case "c1": lorong1_2(); break;
				}
				break;
			case "lorong1_2":
				switch(Choice) {
				case "c1": lorong1_2_2(); break;
				}
				break;
			case "lorong1_2_2":
				switch(Choice) {
				case "c1": lorong1_2_battle(); break;
				}
				break;
			case "lorong1_2_battle":
				switch(Choice) {
				case "c1": lorong1_2_battle_attack(); break;
				}
				break;
			case "lorong1_2_battle_attack":
				switch(Choice) {
				case "c1":
					if(monsterHP<100) {lorong1_2_event();}
					else {lorong1_2_battle_attacked();}
					break;
				}
				break;
			case "lorong1_2_battle_attacked":
				switch(Choice) {
				case "c1":
					if(playerHP == 0) {lorong1_2_defeat1();}
					else {lorong1_2_battle();}
					break;
				}
				break;
			case "lorong1_2_event":
				switch(Choice) {
				case "c1": lorong1_2_defeat2(); break;
				case "c2": lorong1_2_event_2(); break;
				case "c3": lorong1_2_defeat3(); break;
				}
				break;
			case "lorong1_2_event_2":
				switch(Choice) {
				case "c1": lorong1_2_event_3(); break;
				}
				break;
			case "lorong1_2_event_3":
				switch(Choice) {
				case "c1": lorong1_3(); break;
				}
				break;
			case "lorong1_2_defeat1":
				switch(Choice) {
				case "c1": dead(); break;
				}
				break;
			case "lorong1_2_defeat2":
				switch(Choice) {
				case "c1": dead(); break;
				}
				break;
			case "lorong1_2_defeat3":
				switch(Choice) {
				case "c1": dead(); break;
				}
				break;
			case "lorong1_3":
				switch(Choice) {
				case "c1":
					if(visited == 0) {lorong1_3_kiri();}
					else {lorong1_3_kiri2();}
					break;
				case "c2": lorong1_3_kanan(); break;
				}
				break;
			case "lorong1_3_kiri":
				switch(Choice) {
				case "c1": lorong1_3_kiri_2(); break;
				case "c2": lorong1_3_kiri_3(); break;
				}
				break;
			case "lorong1_3_kiri_2":
				switch(Choice) {
				case "c1": lorong1_3(); break;
				}
				break;
			case "lorong1_3_kiri_3":
				switch(Choice) {
				case "c1": lorong1_3(); break;
				}
				break;
			case "lorong1_3_kiri2":
				switch(Choice) {
				case "c1": lorong1_3(); break;
				}
				break;
			case "lorong1_3_kanan":
				switch(Choice) {
				case "c1": lorong1_3_kanan_2(); break;
				}
				break;
			case "lorong1_3_kanan_2":
				switch(Choice) {
				case "c1": boss(); break;
				}
				break;
			case "lorong2_1":
				switch(Choice) {
				case "c1": lorong2_2(); break;
				}
				break;
			case "lorong2_1_2":
				switch(Choice) {
				case "c1": start3(); break;
				}
				break;
			case "lorong2_2":
				switch(Choice) {
				case "c1": lorong2_2_1(); break;
				}
				break;
			case "lorong2_2_1":
				switch(Choice) {
				case "c1": lorong2_2_2(); break;
				}
				break;
			case "lorong2_2_2":
				switch(Choice) {
				case "c1": lorong2_2_3(); break;
				}
				break;
			case "lorong2_2_3":
				switch(Choice) {
				case "c1": lorong2_2_run(); break;
				case "c2": lorong2_2_defeat(); break;
				case "c3": lorong2_2_defend(); break;
				case "c4": lorong2_2_decimate(); break;
				}
				break;
			case "lorong2_2_run":
				switch(Choice) {
				case "c1": start3(); break;
				}
				break;
			case "lorong2_2_defeat":
				switch(Choice) {
				case "c1": dead(); break;
				}
				break;
			case "lorong2_2_decimate":
				switch(Choice) {
				case "c1": lorong2_2_decimate_2(); break;
				}
				break;
			case "lorong2_2_decimate_2":
				switch(Choice) {
				case "c1": lorong2_2_decimate_3(); break;
				}
				break;
			case "lorong2_2_decimate_3":
				switch(Choice) {
				case "c1": lorong2_2_decimate_4(); break;
				}
				break;
			case "lorong2_2_decimate_4":
				switch(Choice) {
				case "c2":
					if (playerHP == 5) {lorong2_2_decimate_5();}
					else {lorong2_2_decimate_4();}
					break;
				}
				break;
			case "lorong2_2_decimate_5":
				switch(Choice) {
				case "c3":
					if (playerHP == 3) {lorong2_2_decimate_6();}
					else {lorong2_2_decimate_5();}
					break;
				}
				break;
			case "lorong2_2_decimate_6":
				switch(Choice) {
				case "c4": lorong2_2_devil(); break;
				}
				break;
			case "lorong2_2_devil":
				switch(Choice) {
				case "c1": lorong2_2_devil_2(); break;
				}
				break;
			case "lorong2_2_devil_2":
				switch(Choice) {
				case "c1": lorong2_2_devil_3(); break;
				}
				break;
			case "lorong2_2_devil_3":
				switch(Choice) {
				case "c1": lorong2_2_devil_4(); break;
				}
				break;
			case "lorong2_2_devil_4":
				switch(Choice) {
				case "c1": lorong2_2_devil_5(); break;
				}
				break;
			case "lorong2_2_devil_5":
				switch(Choice) {
				case "c1": lorong2_2_devil_6(); break;
				}
				break;
			case "lorong2_2_devil_6":
				switch(Choice) {
				case "c1": lorong2_2_devil_accept(); break;
				case "c2": lorong2_2_devil_decline(); break;
				}
				break;
			case "lorong2_2_devil_accept":
				switch(Choice) {
				case "c1": boss(); break;
				}
				break;
			case "lorong2_2_devil_decline":
				switch(Choice) {
				case "c1": dead_devil(); break;
				}
				break;
			case "lorong2_2_defend":
				switch(Choice) {
				case "c1": lorong2_2_defend_2(); break;
				}
				break;
			case "lorong2_2_defend_2":
				switch(Choice) {
				case "c1": lorong2_2_defend_3(); break;
				}
				break;
			case "lorong2_2_defend_3":
				switch(Choice) {
				case "c1": lorong2_2_defend_4(); break;
				}
				break;
			case "lorong2_2_defend_4":
				switch(Choice) {
				case "c1": lorong2_2_defend_5(); break;
				}
				break;
			case "lorong2_2_defend_5":
				switch(Choice) {
				case "c1": lorong2_2_defend_6(); break;
				}
				break;
			case "lorong2_2_defend_6":
				switch(Choice) {
				case "c1": boss(); break;
				}
				break;
			case "boss":
				switch(Choice) {
				case "c1": boss_2(); break;
				}
				break;
			case "boss_2":
				switch(Choice) {
				case "c1": boss_3(); break;
				}
				break;
			case "boss_3":
				switch(Choice) {
				case "c1": boss_battle(); break;
				}
				break;
			case "boss_battle":
				switch(Choice) {
				case "c1": boss_battle_attack(); break;
				}
				break;
			case "boss_battle_attack":
				switch(Choice) {
				case "c1": boss_battle_attacked(); break;
				}
				break;
			case "boss_battle_attacked":
				switch(Choice) {
				case "c1": 
					if(bossHP < 0 && playerHP == 0) {boss_draw();}
					else if (bossHP < 0) {boss_win();}
					else if (playerHP == 0) {boss_defeated();}
					else {boss_battle();}
					break;
				}
				break;
			case "boss_defeated":
				switch(Choice) {
				case "c1":
					if(deal ==1) {dead_devil();}
					else {dead();}
					break;
				}
				break;
			case "boss_draw":
				switch(Choice) {
				case "c1":
					if(deal ==1) {dead_devil();}
					else {dead();}
					break;
				}
				break;
			case "boss_win":
				switch(Choice) {
				case "c1": boss_win_2(); break;
				}
				break;
			case "boss_win_2":
				switch(Choice) {
				case "c1": boss_win_3(); break;
				}
				break;
			case "boss_win_3":
				switch(Choice) {
				case "c1": boss_win_4(); break;
				}
				break;
			case "boss_win_4":
				switch(Choice) {
				case "c1": boss_win_5(); break;
				}
				break;
			case "boss_win_5":
				switch(Choice) {
				case "c1": win(); break;
				}
				break;
			case "win":
				switch(Choice) {
				case "c4": playerSetup(); break;
				}
				break;
			case "dead":
				switch(Choice) {
				case "c4": playerSetup(); break;
				}
				break;
			case "dead_devil":
				switch(Choice) {
				case "c4": playerSetup(); break;
				}
				break;
			}
		}
	}
}














