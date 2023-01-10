package gui;

import bussines.AccountsManager;
import gui.modelo.OperationsAccountsModel;
import gui.modelo.UpdateAccountsModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;

/**
 * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
 */
public class MainWindow extends JFrame implements ActionListener {

    private AccountsManager manager;
    private JPanel jPanelHeader;
    private JPanel jPanelContent;
    private JPanel jPanelUpdateAccounts;
    private JPanel jPanelOperationsAccounts;

    private Box.Filler fillerHeader;

    private JButton jButtonStart;
    private JButton jButtonStop;

    private JLabel jLabelTag;
    private JLabel jLabelCounter;

    private JScrollPane jScrollPanelUpdateAccounts;
    private JScrollPane jScrollPanelOperationsAccounts;

    private JTable jTableUpdateAccounts;
    private JTable jTableOperationsAccounts;

    private UpdateAccountsModel modelUpdateAccounts;
    private OperationsAccountsModel modelOperationsAccounts;

    private boolean startSimulation;

    private Timer timer;
    private Clock timerTask;

    private int countOperations;

    /**
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    public MainWindow() {
        startSimulation=false;
        manager = new AccountsManager();
        timer =new Timer();
        timerTask = new Clock();
        timer.schedule(timerTask,1000, 1000);
        countOperations = 0;

        createUIComponents();
        createConnects();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resource/iconos/cartman.png"));
        setIconImage(icon);

    }

    /**
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    private void createConnects() {
        this.jButtonStart.addActionListener(this);
        this.jButtonStop.addActionListener(this);
        this.manager.attach(this.modelOperationsAccounts);
    }

    /**
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    private void createUIComponents() {

        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        jPanelHeader = new JPanel();
        jPanelHeader.setMaximumSize(new Dimension(32767, 75));
        jPanelHeader.setMinimumSize(new Dimension(0, 75));
        jPanelHeader.setPreferredSize(new Dimension(644, 75));
        jPanelHeader.setPreferredSize(new Dimension(644, 75));
        jPanelHeader.setLayout(new BoxLayout(jPanelHeader, BoxLayout.X_AXIS));
        jPanelHeader.setBorder(BorderFactory.createTitledBorder(null, "Área de Control",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));

        fillerHeader = new Box.Filler(new Dimension(32767, 100),
                                      new Dimension(45, 100),
                                      new Dimension(32767, 32767));
        jButtonStart = new JButton();
        jButtonStart.setIcon(new ImageIcon(getClass().getResource("/resource/iconos/play.png")));
        jButtonStart.setToolTipText("Iniciar simulación");
        jButtonStart.setBorderPainted(false);
        jButtonStart.setContentAreaFilled(false);
        jButtonStart.setMargin(new Insets(2, 2, 2, 2));
        jButtonStart.setMaximumSize(new Dimension(50, 50));
        jButtonStart.setMinimumSize(new Dimension(50, 50));
        jButtonStart.setPreferredSize(new Dimension(50, 50));

        jButtonStop = new JButton();
        jButtonStop.setIcon(new ImageIcon(getClass().getResource("/resource/iconos/stop.png")));
        jButtonStop.setToolTipText("Iniciar simulación");
        jButtonStop.setBorderPainted(false);
        jButtonStop.setContentAreaFilled(false);
        jButtonStop.setMargin(new Insets(2, 2, 2, 2));
        jButtonStop.setMaximumSize(new Dimension(50, 50));
        jButtonStop.setMinimumSize(new Dimension(50, 50));
        jButtonStop.setPreferredSize(new Dimension(50, 50));
        jButtonStop.setEnabled(false);

        jLabelTag = new JLabel();
        jLabelTag.setText("Contador de operaciones:");
        jLabelTag.setFont(new Font("Dialog", Font.BOLD, 12));

        jLabelCounter = new JLabel();
        jLabelCounter.setText("0");
        jLabelCounter.setFont(new Font("Dialog", Font.PLAIN, 12));

        jPanelHeader.add(jLabelTag);
        jPanelHeader.add(jLabelCounter);
        jPanelHeader.add(fillerHeader);
        jPanelHeader.add(jButtonStart);
        jPanelHeader.add(jButtonStop);

        jPanelContent = new JPanel();
        jPanelContent.setLayout(new BoxLayout(jPanelContent, BoxLayout.X_AXIS));

        jPanelUpdateAccounts = new JPanel();
        jPanelUpdateAccounts.setBorder(BorderFactory.createTitledBorder(null, "Actualización de cuentas",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
        jPanelUpdateAccounts.setLayout(new BoxLayout(jPanelUpdateAccounts, BoxLayout.X_AXIS));

        jScrollPanelUpdateAccounts = new JScrollPane();

        modelUpdateAccounts = new UpdateAccountsModel();

        jTableUpdateAccounts = new JTable();
        jTableUpdateAccounts.setModel(modelUpdateAccounts);


        jScrollPanelUpdateAccounts.setViewportView(jTableUpdateAccounts);
        jPanelUpdateAccounts.add(jScrollPanelUpdateAccounts);

        jPanelOperationsAccounts = new JPanel();
        jPanelOperationsAccounts.setBorder(BorderFactory.createTitledBorder(null, "Operaciones de las cuentas",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
        jPanelOperationsAccounts.setLayout(new BoxLayout(jPanelOperationsAccounts, BoxLayout.X_AXIS));

        jScrollPanelOperationsAccounts = new JScrollPane();

        modelOperationsAccounts = new OperationsAccountsModel();

        jTableOperationsAccounts = new JTable();
        jTableOperationsAccounts.setModel(modelOperationsAccounts);
        jTableOperationsAccounts.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        jScrollPanelOperationsAccounts.setViewportView(jTableOperationsAccounts);
        jPanelOperationsAccounts.add(jScrollPanelOperationsAccounts);

        jPanelContent.add(jPanelUpdateAccounts);
        jPanelContent.add(jPanelOperationsAccounts);

        getContentPane().add(jPanelHeader);
        getContentPane().add(jPanelContent);

        setTitle("Laboratorio de Patrones de Diseño");

        pack();

    }

    /**
     *
     * @param actionEvent
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object obj = actionEvent.getSource();

        if (this.jButtonStart == obj){
            startSimulations();
        }else if(this.jButtonStop == obj){
            stopSimulations();
        }
    }

    /**
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    private void stopSimulations() {
        startSimulation = false;
        jButtonStop.setEnabled(startSimulation);
        jButtonStart.setEnabled(!startSimulation);
    }

    /**
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    private void startSimulations() {
        startSimulation = true;
        jButtonStop.setEnabled(startSimulation);
        jButtonStart.setEnabled(!startSimulation);
    }

    /**
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    private class Clock extends TimerTask {

        /**
         * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
         */
        @Override
        public void run() {
            if(startSimulation == true){
                countOperations++;
                jLabelCounter.setText(String.valueOf(countOperations));
                manager.SimulateOperation();
            }
        }
    }
}
