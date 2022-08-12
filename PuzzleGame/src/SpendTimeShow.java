
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 *
 * @author umsang-uk
 */
public class SpendTimeShow extends javax.swing.JPanel {

    public int count = 0;
    boolean isRunning = false;
    boolean notRunningStopWatch = true;
    int hh, mm, ss;

    public SpendTimeShow() {
        initComponents();
        new Thread() {
            @Override
            public void run() {
                System.out.println("타이머 실행");
                while (1 == 1) {
                    try {
                        if (isRunning && notRunningStopWatch) {
                            try {
                                notRunningStopWatch = false;
                                stopWatch();
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());

                    }
                }
            }
        }.start();
    }

    public void stopWatch() {
        Timer m_timer = new Timer();
        TimerTask m_task = new TimerTask() {
            @Override
            public void run() {
                if (isRunning) {
                    ss = count % 60;
                    mm = count / 60 % 60;
                    hh = count / 3600;
                    jTimeLabel.setText(String.format("%02d : %02d : %02d", hh, mm, ss));
                    count++;
                } else {
                    m_timer.cancel();
                    count = 0;
                    notRunningStopWatch = true;
                    resetTimer();
                }
            }
        };
        m_timer.schedule(m_task, 0, 1000);
    }

//    int h, m, s, time = 0;
//    boolean isRunning = false, reset=false;
//
//    /**
//     * Creates new form SpendTimeShow
//     */
//    public SpendTimeShow() {
//        initComponents();
//        runTimer();
//    }
//
    public void resetTimer() {
        this.jTimeLabel.setText("00 : 00 : 00");
//        this.jHLabel.setText("00");
//        this.jMLabel.setText("00");
//        this.jSLabel.setText("00");
    }
//
//    public void runTimer() {
//        new Thread() {
//            @Override
//            public void run() {
//                System.out.println("타이머 실행");
//                while (1 == 1) {
//                    if (reset){
//                        resetTimer();
//                        reset = false;
//                    }
//                    while (isRunning) {
//                        h = time / (1000 * 60 * 60 * 60) % 24;
//                        m = time / (1000 * 60) / 100 /60;
//                        s = time / (1000 * 60) / 100 % 60;
//                        try {                            
//                            jHLabel.setText(String.format("%02d", h));
//                            jMLabel.setText(String.format("%02d", m));
//                            jSLabel.setText(String.format("%02d", s));
//
//                            time++;
//                        } catch (Exception ex) {
//                            System.out.println(ex.getMessage());
//                        }
//                    }
//                }
//            }
//        }.start();
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMLabel = new javax.swing.JLabel();
        jHLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTimeLabel = new javax.swing.JLabel();

        jMLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jMLabel.setText("00");

        jHLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jHLabel.setText("00");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel3.setText(":");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel2.setText(":");

        jSLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jSLabel.setText("00");

        setPreferredSize(new java.awt.Dimension(400, 80));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("소요 시간");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 6, -1, -1));

        jTimeLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jTimeLabel.setText("00 : 00 : 00");
        add(jTimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jHLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jMLabel;
    private javax.swing.JLabel jSLabel;
    private javax.swing.JLabel jTimeLabel;
    // End of variables declaration//GEN-END:variables
}
