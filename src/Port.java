import javax.swing.*;
import java.awt.event.*;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.String;
public class Port extends JFrame implements ItemListener {
    public Hub[] H=new Hub[3];
    public void initializeHubs(){
    for(int i=0; i<3; i++){
    H[i]=new Hub();}
    }
    public void initializeContainers(){
        int i=0, j=0, k=0;
        for(i=0; i<3; i++){
            for(j=0; j<10; j++) {
                for (k = 0; k < 12; k++) {
                    H[i].c[j][k] = new container(0, 1, "", false, 0, "", "", "");
                }
            }
        }
    }
    private JTextField tfIDNumber;
    private JTextField tfWeight;
    private JTextArea tfDescription;
    private JTextField tfRemitentCompany;
    private JTextField tfReceiverCompany;
    private JButton tfPile;
    private JComboBox comboBox2;
    private JRadioButton a1RadioButton;
    private JTextField tfStateHubPlan;
    public String getStateHubPlan(){
        String prevText="";
        int i=0, j=0, k=0;
        for(i=0; i<3; i++){
            prevText=prevText +"Hub "+(i+1)+"\n";
        for (j=0; j<10; j++){
                for(k=0; k<12; k++){
                    if(H[i].c[j][k].IDNumber==0) prevText=prevText+" 0";
                    else prevText=prevText+" 1";
                }
                prevText=prevText + "\n";
            }
        }
            prevText=prevText + "\n";
        return prevText;
    }
    private JCheckBox tfCheckBox;
    private JRadioButton a2RadioButton;
    private JRadioButton a3RadioButton;
    private JPanel mainPanel;
    private JButton tfNumberOfContainers;
    private JComboBox comboBox1;
    private JTextField tfCountryNumber;
    private JButton tfshowContainerDescription;
    private JTextArea tfContainerDescription;
    private JLabel LCountry;
    private JButton TFPile;
    private JTextField tfColumn;
    private JButton tfUnpile;
    private JTextArea tfStateHubPlanArea;
    private JLabel tfDescription_;
    private JTextField tfErrors;
    private JTextField tfNumberHub;
    int column;
    int IDNumber;
    int weight;
    String country;
    boolean inspected;
    int priority;
    String description;
    String sender;
    String receiver;

    public Port(){
        initializeHubs();
        initializeContainers();
        setContentPane(mainPanel);
        setTitle("Port management");
        setSize(2000, 1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        TFPile.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                IDNumber=Integer.parseInt(tfIDNumber.getText());
                weight=Integer.parseInt(tfWeight.getText());
                country=(String)comboBox2.getSelectedItem();
                inspected=tfCheckBox.isSelected();
                if((!a1RadioButton.isSelected())&(!a2RadioButton.isSelected())&&(!a3RadioButton.isSelected())) tfErrors.setText("Error. No priority chosen");
                else{
                    if(priorityRepeated()) tfErrors.setText("Error. More than one number of priority chosen");
                    else{
                if(a1RadioButton.isSelected()) priority=1;
                else if(a2RadioButton.isSelected()) priority=2;
                else if(a3RadioButton.isSelected()) priority=3;
                description=String.valueOf(tfDescription.getText());
                sender=String.valueOf(tfRemitentCompany.getText());
                receiver=String.valueOf(tfReceiverCompany.getText());
                if(!repeated(IDNumber)){
                    if(priority==1){
                        int i=0, j=9, t=0;
                        for(i=0; i<3; i++){
                            for(j=9; j>=0; j--){
                                if(H[i].c[j][0].getIDNumber()==0){
                                H[i].c[j][0].setIDNumber(IDNumber);
                                H[i].c[j][0].setWeight(weight);
                                H[i].c[j][0].setCountry(country);
                                H[i].c[j][0].setInspected(inspected);
                                H[i].c[j][0].setDescription(description);
                                H[i].c[j][0].setSender(sender);
                                H[i].c[j][0].setReceiver(receiver);
                                H[i].c[j][0].setPriority(priority);
                                t++;
                                j=-1;
                                i=4;
                                }
                            }
                        }
                        if(t==0) tfErrors.setText("Error. The column/s of the priority of the container is/are full");
                    }
                    if(priority==2){
                        int i=0, j=9, t=0;
                        for(i=0; i<3; i++){
                            for(j=9; j>=0; j--){
                                if(H[i].c[j][1].getIDNumber()==0){
                                    H[i].c[j][1].setIDNumber(IDNumber);
                                    H[i].c[j][1].setWeight(weight);
                                    H[i].c[j][1].setCountry(country);
                                    H[i].c[j][1].setInspected(inspected);
                                    H[i].c[j][1].setDescription(description);
                                    H[i].c[j][1].setSender(sender);
                                    H[i].c[j][1].setReceiver(receiver);
                                    H[i].c[j][1].setPriority(priority);
                                    t++;
                                    j=-1;
                                    i=4;
                                }
                            }
                        }
                        if(t==0) tfErrors.setText("Error. The column/s of the priority of the container is/are full");
                    }
                    if(priority==3){
                        int i=0, j=9, k=2, t=0;
                        for(i=0; i<3; i++){
                            for(j=9; j>=0; j--){
                                for(k=2; k<12; k++){
                                if(H[i].c[j][k].getIDNumber()==0){
                                    H[i].c[j][k].setIDNumber(IDNumber);
                                    H[i].c[j][k].setWeight(weight);
                                    H[i].c[j][k].setCountry(country);
                                    H[i].c[j][k].setInspected(inspected);
                                    H[i].c[j][k].setDescription(description);
                                    H[i].c[j][k].setSender(sender);
                                    H[i].c[j][k].setReceiver(receiver);
                                    H[i].c[j][k].setPriority(priority);
                                    t++;
                                    k=13;
                                    j=-1;
                                    i=4;
                                }
                                }
                            }
                        }
                        if(t==0) tfErrors.setText("Error. The column/s of the priority of the container is/are full");
                    }
                tfStateHubPlanArea.setText(getStateHubPlan());
                    }
                else tfErrors.setText("Error. ID Number repeated");
                }}}
                catch(NumberFormatException e){
                    tfErrors.setText("Number format exception "+e);
                }
            }
        });
        tfshowContainerDescription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                IDNumber=Integer.parseInt(tfIDNumber.getText());
                if(IDNumber<1) {tfErrors.setText("Error. Wrong number of ID");
                    tfContainerDescription.setText("");
                }
                else{
                int i=0, j=0, k=0, t=0;
                for(i=0; i<3; i++){
                    for (j=0; j<10; j++){
                        for(k=0; k<12; k++){
                            if(H[i].c[j][k].IDNumber==IDNumber) {
                                IDNumber=H[i].c[j][k].getIDNumber();
                                weight=H[i].c[j][k].getWeight();
                                country=H[i].c[j][k].getCountry();
                                inspected=H[i].c[j][k].isInspected();
                                priority=H[i].c[j][k].getPriority();
                                description=H[i].c[j][k].getDescription();
                                sender=H[i].c[j][k].getSender();
                                receiver=H[i].c[j][k].getReceiver();
                                tfContainerDescription.setText("IDNumber: "+IDNumber+". Weight: "+weight+". Country: "+country+". Inspected: "
                                        +inspected+". Priority: "+priority+". Description: "+description+". Sender: "
                                        +sender+". Receiver: "+receiver);
                                tfErrors.setText("");
                                t++;
                                i=4;
                                j=11;
                                k=13;
                            }
                        }
                    }
                }
                if(t==0) {tfErrors.setText("Error. None of the containers in the port have that ID Number");
                    tfContainerDescription.setText("");
                }
            }}
                catch (NumberFormatException e){
                    tfErrors.setText("Number format exception "+e);
                }
            }
        });
        tfUnpile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                int t=0;
                column=Integer.parseInt(tfColumn.getText());
                int hub=Integer.parseInt(tfNumberHub.getText());
                if((column<0)||(column>11)||(hub<0)||(hub>2)) tfErrors.setText("Error. Wrong number of column or hub");
                else{
                for(int i=0; i<10; i++){
                    if(H[hub].c[i][column].IDNumber!=0) {
                        H[hub].c[i][column].setIDNumber(0);
                        H[hub].c[i][column].setWeight(0);
                        H[hub].c[i][column].setCountry("");
                        H[hub].c[i][column].setInspected(false);
                        H[hub].c[i][column].setPriority(0);
                        H[hub].c[i][column].setDescription("");
                        H[hub].c[i][column].setSender("");
                        H[hub].c[i][column].setReceiver("");
                    t++;
                    i=11;
                    }
                }
                if(t==0) tfErrors.setText("Error. No containers in that column of that hub");
                else tfErrors.setText("");
                tfStateHubPlanArea.setText(getStateHubPlan());
                }}
                catch(NumberFormatException e){
                    tfErrors.setText("number format exception "+e);
                }
            }
        });
        tfNumberOfContainers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int counter=0;
                country=(String)comboBox1.getSelectedItem();
                for (int a=0; a<3; a++){
                    for (int i=0; i<10; i++){
                        for (int j=0; j<12; j++){
                            if(H[a].c[i][j].country.equals(country)) counter++;
                        }
                    }
                }
                tfCountryNumber.setText(String.valueOf(counter));
            }
        });
    }
    boolean repeated (int IDNumber){
        int t=0;
        for (int a=0; a<3; a++){
            for (int i=0; i<10; i++){
                for (int j=0; j<12; j++){
                    if(H[a].c[i][j].IDNumber==IDNumber) t++;
                }
            }
        }
        if (t>0) return true;
        else return false;
    }
    boolean priorityRepeated(){
        int t=0;
        if(a1RadioButton.isSelected()) t++;
        if(a2RadioButton.isSelected()) t++;
        if(a3RadioButton.isSelected()) t++;
        if(t>1) return true;
        else return false;
    }
    public void itemStateChanged(ItemEvent itemEvent) {
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
