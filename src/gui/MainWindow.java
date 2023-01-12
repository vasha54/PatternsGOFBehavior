package gui;

import bussines.AccountsManager;
import bussines.CreatorStateAccountConfig;
import bussines.EnvironmentAccount;
import bussines.StateAccountConfig1;
import bussines.StateAccountConfig2;
import gui.components.OperationAccountsTable;
import gui.components.OperationAccountsTableCellRenderer;
import gui.components.UpdateAccountsTable;
import gui.components.UpdateAccountsTableCellRenderer;
import gui.modelo.OperationsAccountsModel;
import gui.modelo.UpdateAccountsModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

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
    
    private JLabel jLabelTagAccount;
    private JLabel jLabelCounterAccount;
    
    private JLabel jLabelTagConfiguration;
    private JComboBox<String> jComboBoxConfiguration;

    private JScrollPane jScrollPanelUpdateAccounts;
    private JScrollPane jScrollPanelOperationsAccounts;

    private JTable jTableUpdateAccounts;
    private JTable jTableOperationsAccounts;

    private UpdateAccountsModel modelUpdateAccounts;
    private OperationsAccountsModel modelOperationsAccounts;

    private boolean startSimulation;

    private Timer timer;
    private Clock timerTask;



    private OperationAccountsTableCellRenderer renderTableOperationAccount;

    private UpdateAccountsTableCellRenderer renderTableUpdateAccounts;


    /**
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    public MainWindow() {
        startSimulation=false;
        manager = new AccountsManager();
        timer =new Timer();
        timerTask = new Clock();
        timer.schedule(timerTask,500, 500);

        createUIComponents();
        createConnects();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resource/iconos/cartman.png"));
        setIconImage(icon);
        
        this.changeItemComboBoxConfiguration();
    }

    /**
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    private void createConnects() {
        this.jButtonStart.addActionListener(this);
        this.jButtonStop.addActionListener(this);
        this.manager.attach(this.modelOperationsAccounts);
        this.manager.attach(this.modelUpdateAccounts);
        
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
        
        Border margin = new EmptyBorder(5,5,5,5);

        jLabelTag = new JLabel();
        jLabelTag.setText("Cantidad de operaciones:");
        jLabelTag.setFont(new Font("Dialog", Font.BOLD, 12));
        jLabelTag.setBorder(new CompoundBorder(jLabelTag.getBorder(), margin));

        jLabelCounter = new JLabel();
        jLabelCounter.setText("  0");
        jLabelCounter.setFont(new Font("Dialog", Font.PLAIN, 12));
        jLabelCounter.setBorder(new CompoundBorder(jLabelCounter.getBorder(), margin));

        jLabelTagAccount = new JLabel();
        jLabelTagAccount.setText("Cantidad de cuentas:");
        jLabelTagAccount.setFont(new Font("Dialog", Font.BOLD, 12));
        jLabelTagAccount.setBorder(new CompoundBorder(jLabelTagAccount.getBorder(), margin));


        jLabelCounterAccount = new JLabel();
        jLabelCounterAccount.setText("  0");
        jLabelCounterAccount.setFont(new Font("Dialog", Font.PLAIN, 12));
        jLabelCounterAccount.setBorder(new CompoundBorder(jLabelCounterAccount.getBorder(), margin));
        
        jLabelTagConfiguration = new JLabel();
        jLabelTagConfiguration.setText("Configuración:");
        jLabelTagConfiguration.setFont(new Font("Dialog", Font.BOLD, 12));
        jLabelTagConfiguration.setBorder(new CompoundBorder(jLabelTagAccount.getBorder(), margin));
        
        jComboBoxConfiguration = new JComboBox<>(new String[]{"Primera variante de configuración","Segunda variante de configuración"});
        jComboBoxConfiguration.setBorder(new CompoundBorder(jComboBoxConfiguration.getBorder(), margin));
        jComboBoxConfiguration.setMaximumSize(new Dimension(300, 32));
        jComboBoxConfiguration.setMinimumSize(new Dimension(300, 32));
        jComboBoxConfiguration.setPreferredSize(new Dimension(300, 32));
        jComboBoxConfiguration.addActionListener(this);

        jPanelHeader.add(jLabelTag);
        jPanelHeader.add(jLabelCounter);
        jPanelHeader.add(jLabelTagAccount);
        jPanelHeader.add(jLabelCounterAccount);
        jPanelHeader.add(jLabelTagConfiguration);
        jPanelHeader.add(jComboBoxConfiguration);
        jPanelHeader.add(fillerHeader);
        jPanelHeader.add(jButtonStart);
        jPanelHeader.add(jButtonStop);

        jPanelContent = new JPanel();
        jPanelContent.setLayout(new BoxLayout(jPanelContent, BoxLayout.X_AXIS));

        jPanelUpdateAccounts = new JPanel();
        jPanelUpdateAccounts.setBorder(BorderFactory.createTitledBorder(null, "Actualización de estados de cuentas",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
        jPanelUpdateAccounts.setLayout(new BoxLayout(jPanelUpdateAccounts, BoxLayout.X_AXIS));

        jScrollPanelUpdateAccounts = new JScrollPane();

        modelUpdateAccounts = new UpdateAccountsModel();
        renderTableUpdateAccounts = new UpdateAccountsTableCellRenderer();

        jTableUpdateAccounts = new UpdateAccountsTable();
        jTableUpdateAccounts.setModel(modelUpdateAccounts);
        jTableUpdateAccounts.setDefaultRenderer(Object.class,renderTableUpdateAccounts);
        
        TableColumn column = jTableUpdateAccounts.getColumnModel().getColumn(0);
        column.setPreferredWidth(100);
        column.setMaxWidth(100);
        column.setMinWidth(100);
        
        column = jTableUpdateAccounts.getColumnModel().getColumn(2);
        column.setPreferredWidth(130);
        column.setMaxWidth(130);
        column.setMinWidth(130);
        
        column = jTableUpdateAccounts.getColumnModel().getColumn(3);
        column.setPreferredWidth(140);
        column.setMaxWidth(140);
        column.setMinWidth(140);
        
        jTableUpdateAccounts.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        jScrollPanelUpdateAccounts.setViewportView(jTableUpdateAccounts);
        jPanelUpdateAccounts.add(jScrollPanelUpdateAccounts);

        jPanelOperationsAccounts = new JPanel();
        jPanelOperationsAccounts.setBorder(BorderFactory.createTitledBorder(null, "Operaciones de cuentas",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
        jPanelOperationsAccounts.setLayout(new BoxLayout(jPanelOperationsAccounts, BoxLayout.X_AXIS));

        jScrollPanelOperationsAccounts = new JScrollPane();

        modelOperationsAccounts = new OperationsAccountsModel();
        renderTableOperationAccount = new OperationAccountsTableCellRenderer();

        jTableOperationsAccounts = new OperationAccountsTable();
        jTableOperationsAccounts.setModel(modelOperationsAccounts);
        jTableOperationsAccounts.setDefaultRenderer(Object.class,renderTableOperationAccount);
        
        column = jTableOperationsAccounts.getColumnModel().getColumn(0);
        column.setPreferredWidth(70);
        column.setMaxWidth(70);
        column.setMinWidth(70);
        
        column = jTableOperationsAccounts.getColumnModel().getColumn(1);
        column.setPreferredWidth(100);
        column.setMaxWidth(100);
        column.setMinWidth(100);
        
        column = jTableOperationsAccounts.getColumnModel().getColumn(3);
        column.setPreferredWidth(130);
        column.setMaxWidth(130);
        column.setMinWidth(130);
        
        column = jTableOperationsAccounts.getColumnModel().getColumn(4);
        column.setPreferredWidth(130);
        column.setMaxWidth(130);
        column.setMinWidth(130);
        
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
        } else if (this.jComboBoxConfiguration == obj) {
            changeItemComboBoxConfiguration();
        }
    }

    /**
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    private void changeItemComboBoxConfiguration() {       
        EnvironmentAccount.getInstance().setCreatorStateAccountConfig(
            new CreatorStateAccountConfig[]{new StateAccountConfig1(),new StateAccountConfig2()}[this.jComboBoxConfiguration.getSelectedIndex()]
        );
        
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
                manager.SimulateOperation();
                jLabelCounterAccount.setText(String.valueOf(jTableUpdateAccounts.getRowCount()));
                jLabelCounter.setText(String.valueOf(modelOperationsAccounts.getRowCount()));
            }
        }
    }
}
