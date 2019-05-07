package cn.simple.test.jdkapi.awt.watermarks;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WatermarkGUI {
    JFrame     mainFrame    = new JFrame( "自动化生成水印" );
    Container  mainPane     = mainFrame.getContentPane();
    JTextField srcPathText  = new JTextField();
    JTextField imgPathText  = new JTextField();
    JTextArea  msgArea      = new JTextArea();
    JButton    okButton     = new JButton( "确定" );
    JButton    cancelButton = new JButton( "取消" );

    public WatermarkGUI() {
        mainFrame.setSize( 800, 800 );
        mainPane.setLayout( new BorderLayout() );
        this.initFrame();
        this.setupAttribute();
        this.setupEventListener();
        mainFrame.setVisible( true );
    }

    void initFrame() {
        // 顶部
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout( new FlowLayout() );
        titlePanel.add( new JLabel( "生成水印-曾献峰-制作" ) );
        mainPane.add( titlePanel, BorderLayout.NORTH );

        // 中部表单
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout( null );
        JLabel a1 = new JLabel( "原图文件夹：" );
        a1.setBounds( 50, 20, 150, 20 );
        JLabel a2 = new JLabel( "水印图片路径：" );
        a2.setBounds( 50, 60, 150, 20 );
        fieldPanel.add( a1 );
        fieldPanel.add( a2 );

        srcPathText.setBounds( 180, 20, 550, 20 );
        imgPathText.setBounds( 180, 60, 550, 20 );
        msgArea.setBounds( 50, 100, 680, 580 );
        fieldPanel.add( srcPathText );
        fieldPanel.add( imgPathText );
        fieldPanel.add( msgArea );
        mainPane.add( fieldPanel, BorderLayout.CENTER );

        // 底部按钮
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout( new FlowLayout() );
        buttonPanel.add( okButton );
        buttonPanel.add( cancelButton );
        mainPane.add( buttonPanel, BorderLayout.SOUTH );
    }

    void setupAttribute() {
        msgArea.setEditable( false );
    }

    void setupEventListener() {
        mainFrame.addWindowListener( new WindowAdapter() {
            public void windowClosing( WindowEvent e ) {
                WatermarkGUI.this.logMessage( "窗口-关闭" );
                System.exit( 0 );
            }
        } );
        okButton.addActionListener( e -> {
            String srcPath = srcPathText.getText();
            if ( srcPath.isBlank() ) {
                this.logMessage( "请输入-原图文件夹" );
                return;
            }
            String imgPath = imgPathText.getText();
            if ( imgPath.isBlank() ) {
                this.logMessage( "请输入-水印图片路径" );
                return;
            }
            if ( !Files.exists( Paths.get( srcPath ) ) ) {
                this.logMessage( "原图文件夹：[%s] 不存在", srcPath );
                return;
            }
            if ( !Files.isDirectory( Paths.get( srcPath ) ) ) {
                this.logMessage( "原图文件夹：[%s] 不是文件夹", srcPath );
                return;
            }
            if ( !Files.exists( Paths.get( imgPath ) ) ) {
                this.logMessage( "水印图片：[%s] 不存在", imgPath );
                return;
            }
            this.logMessage( "原图文件夹：[%s]", srcPath );
            this.logMessage( "水印图片路径：[%s]", imgPath );
            this.logMessage( "确定-开始操作" );
        } );
        cancelButton.addActionListener( e -> {
            this.logMessage( "取消-关闭" );
            System.exit( 0 );
        } );
    }

    void logMessage( String fmt, Object... args ) {
        Object[] param = new Object[args.length + 1];
        param[0] = System.currentTimeMillis();
        System.arraycopy( args, 0, param, 1, args.length );
        String msg = String.format( "[%tT] " + fmt, param );

        System.out.println( msg );
        msgArea.append( msg );
        msgArea.append( "\n" );
    }

    public static void main( String[] args ) {
        new WatermarkGUI();
    }

}
