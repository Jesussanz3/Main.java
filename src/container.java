import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.util.Arrays;
import javax.swing.JComboBox;

public class container extends JFrame{
    int IDNumber;
    int weight;
    String country;
    boolean inspected;
    int priority;
    String [] description=new String[101];
    String [] sender=new String[21];
    String [] receiver=new String[21];

    public container(int IDNumber, int weight, String country, boolean inspected, int priority, String[] description, String[] sender, String[] receiver) {
        this.IDNumber = IDNumber;
        this.weight = weight;
        this.country = country;
        this.inspected = inspected;
        if((priority>=1)&&(priority<=3)) this.priority = priority;
        this.description = description;
        this.sender = sender;
        this.receiver = receiver;
    }
    public container(){
        setContentPane(mainPanel);
        setTitle("Port management");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        tfPile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int IDNumber=tfIDNumber.getY();
                int weight=tfWeight.getY();
                String country=(String)comboBox2.getSelectedItem();
                boolean inspected=tfCheckBox.isSelected();
                if(a1RadioButton.isSelected()){
                    int priority=a1RadioButton.getY();
                }
                else if(a2RadioButton.isSelected()){
                    int priority=a2RadioButton.getY();
                }
                else if(a3RadioButton.isSelected()){
                    int priority=a3RadioButton.getY();
                }
                String description=tfDescription.getText();
                String sender=tfRemitentCompany.getText();
                String receiver=tfReceiverCompany.getText();

            }
        });

        tfUnpile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int IDNumber=tfIDNumber.getY();
                int weight=tfWeight.getY();
                String country=(String)comboBox2.getSelectedItem();
                boolean inspected=tfCheckBox.isSelected();
                if(a1RadioButton.isSelected()){
                    int priority=a1RadioButton.getY();
                }
                else if(a2RadioButton.isSelected()){
                    int priority=a2RadioButton.getY();
                }
                else if(a3RadioButton.isSelected()){
                    int priority=a3RadioButton.getY();
                }
                String description=tfDescription.getText();
                String sender=tfRemitentCompany.getText();
                String receiver=tfReceiverCompany.getText();
                int column=tfColumnNumber.getY();
            }
        });

        tfshowContainerDescription.addContainerListener(new ContainerAdapter() {
        });
        tfshowContainerDescription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int IDNumber=tfIDNumber.getY();
                int weight=tfWeight.getY();
                String country=(String)comboBox2.getSelectedItem();
                boolean inspected=tfCheckBox.isSelected();
                if(a1RadioButton.isSelected()){
                    int priority=a1RadioButton.getY();
                }
                else if(a2RadioButton.isSelected()){
                    int priority=a2RadioButton.getY();
                }
                else if(a3RadioButton.isSelected()){
                    int priority=a3RadioButton.getY();
                }
                String description=tfDescription.getText();
                String sender=tfRemitentCompany.getText();
                String receiver=tfReceiverCompany.getText();
            }
        });

        tfNumberOfContainers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int IDNumber=tfIDNumber.getY();
                int weight=tfWeight.getY();
                String country=(String)comboBox2.getSelectedItem();
                boolean inspected=tfCheckBox.isSelected();
                if(a1RadioButton.isSelected()){
                    int priority=a1RadioButton.getY();
                }
                else if(a2RadioButton.isSelected()){
                    int priority=a2RadioButton.getY();
                }
                else if(a3RadioButton.isSelected()){
                    int priority=a3RadioButton.getY();
                }
                String description=tfDescription.getText();
                String sender=tfRemitentCompany.getText();
                String receiver=tfReceiverCompany.getText();
                String countryNumber=(String)comboBox1.getSelectedItem();
            }
        });
    }

    public int getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(int IDNumber) {
        this.IDNumber = IDNumber;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isInspected() {
        return inspected;
    }

    public void setInspected(boolean inspected) {
        this.inspected = inspected;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String[] getDescription() {
        return description;
    }

    public void setDescription(String[] description) {
        this.description = description;
    }

    public String[] getSender() {
        return sender;
    }

    public void setSender(String[] sender) {
        this.sender = sender;
    }

    public String[] getReceiver() {
        return receiver;
    }

    public void setReceiver(String[] receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "container{" +
                "IDNumber=" + IDNumber +
                ", weight=" + weight +
                ", country='" + country + '\'' +
                ", inspected=" + inspected +
                ", priority=" + priority +
                ", description=" + Arrays.toString(description) +
                ", sender=" + Arrays.toString(sender) +
                ", receiver=" + Arrays.toString(receiver) +
                '}';
    }
    boolean repeated (int IDNumber, Hub H[]){
        int t=0;
        for (int a=0; a<3; a++){
            for (int i=0; i<12; i++){
                for (int j=0; j<10; j++){
                    if(H[a].c[i][j].IDNumber==IDNumber) t++;
                }
            }
        }
        if (t>0) return true;
            else return false;
    }
    void stack(container c, Hub H[]){
        int m=4, b=0;
        int con=0, i=0, j=2, a=0;
        if(!repeated(c.IDNumber, H)){
        if(c.priority==1){
            for(a=0; a<3; a++){
                b=a;
                for (i=0; i<10; i++){
                if(H[a].c[0][i]==null) {
                    H[a].c[0][i]=c;
                    con++;
                    a=m;
                    break;
                }
            }}
            a=b;
            if (con>0) System.out.println("The container "+c+" has been stock in the hub "+a+" in the place "+0+", "+i);
                else System.out.println("The column of the priority of the container "+c+"is null");
        }
        else if(c.priority==2){
            for(a=0; a<3; a++){
                b=a;
                for (i=0; i<10; i++){
                    if(H[a].c[1][i]==null) {
                        H[a].c[1][i]=c;
                        con++;
                        a=m;
                        break;
                    }
                }
            }
            a=b;
            if (con>0) System.out.println("The container "+c+" has been stock in the hub "+a+" in the place "+1+", "+i);
            else System.out.println("The column of the priority of the container "+c+"is null");
        }
        else if(c.priority==3){
            for(a=0; a<3; a++){
                b=a;
                for(j=2; j<12; j++){
                    for (i=0; i<10; i++){
                        if(H[a].c[j][i]==null) {
                            H[a].c[j][i]=c;
                            con++;
                            a=m;
                            break;
                        }
                    }}
            }
            a=b;
            if (con>0) System.out.println("The container "+c+" has been stock in the hub "+a+" in the place "+j+", "+i);
            else System.out.println("The columns of the priority of the container "+c+"are null");
        }
        else System.out.println("Error. Wrong number of priority");
    }
    else System.out.println("Error. That ID number is repeated");
    }
    void remove(container cc, Hub H[], int column){
        int j=0, con=0, a=0, m=4, b=0;
            for (a=0; a<3; a++){
                b=a;
            for (j=0; j<10; j++){
                if (H[a].c[column][j]==cc) {
                    con++;
                    a=m;
                    break;
                }
            }}
        a=b;
        if(con>0){
            H[a].c[column][j]=null;
            System.out.println("Container removed. Changing the position of its upper containers one position down...");
            for(int ii=column; ii<11; ii++){
                H[a].c[ii][j]=H[a].c[ii+1][j];
            }
        }
        else System.out.println("The container "+cc+"is not in the  column"+column+" of the hub "+H);
    }
    void display(container cc, Hub H[], int IDNumber){
        int i=0, j=0, con=0, m=4, b=0, a=0;
        for (a=0; a<3; a++){
            b=a;
        for (i=0; i<12; i++){
            for(j=0; j<10; j++){
                if(H[a].c[i][j].IDNumber==cc.IDNumber) {
                    con++;
                    a=m;
                    break;
                }
            }
        }}
        a=b;
        if(con>0){cc.toString();}
        else System.out.println("The container "+cc+"is not in any hub");
    }
    void calculate(String countryNumber, Hub H){
        int cont=0, total=0, a=0;
        for (a=0; a<3; a++){
        for (int i=0; i<12; i++){
            for (int j=0; j<10; j++){
                if(H.c[i][j].country.equals(countryNumber)) {
                    total++;
                    cont++;
                }
            }
        }
        System.out.println("There are "+cont+"containers from the country "+countryNumber+" in the hub "+a);
        cont=0;
        }
        System.out.println("There are "+total+"containers from the country "+countryNumber+"counting all the hubs");
    }
    void plan(Hub H[]){
        for(int a=0; a<3; a++){
            for (int i=0; i<12; i++){
                for (int j=0; j<10; j++){
                    if(H[a].c[i][j]==null) System.out.println("N ");
                    else System.out.println(H[a].c[i][j].IDNumber+" ");
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
    private JButton tfUnpile;
    private JTextField tfColumnNumber;
    private JButton tfshowContainerDescription;
    private JTextArea tfContainerDescription;
    private JButton tfNumberOfContainers;
    private JTextField tfPutNumberHere;
    private JComboBox comboBox1=new JComboBox();
    private JComboBox comboBox2;
    private JRadioButton a1RadioButton;
    private JTextField tfStateHubPlan;
    private JCheckBox tfCheckBox;
    private JRadioButton a2RadioButton;
    private JRadioButton a3RadioButton;
    private JPanel tfCompanyLogo;
    private JPanel mainPanel;
}
