package com.lusnia.kolokwium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTextArea;

class Srednia implements Runnable{
    JTextArea res;
    Srednia(JTextArea label){
        res=label;
    }
    
    @Override
    public void run(){
        try{
            ArrayList<String> studenci = new ArrayList<>();
            ArrayList<Float> oceny = new ArrayList<>();
            ArrayList<Integer> liczba = new ArrayList<>();
            BufferedReader fr = new BufferedReader(new FileReader("studenci.csv"));
            String linia;
            while((linia=fr.readLine())!=null){
                String[] split = linia.split(";");
                String student=split[1]+" "+split[0];
                if(studenci.contains(student)){
                    int index=studenci.indexOf(student);
                    oceny.set(index,oceny.get(index)+Float.valueOf(split[3]));
                    liczba.set(index,liczba.get(index)+1);
                }
                else{
                    studenci.add(student);
                    oceny.add(Float.valueOf(split[3]));
                    liczba.add(1);
                }
            }
            fr.close();
            String result="";
            for(int i=0;i<studenci.size();i++){
                result+=studenci.get(i)+": "+String.format("%.2f",oceny.get(i)/liczba.get(i))+"\n";
            }
            synchronized(res){
                res.setText(result);
            }
        }
        catch(IOException ex){
            System.out.println("IOException");
        }
    }
}

class Piec implements Runnable{
    JTextArea res;
    Piec(JTextArea label){
        res=label;
    }
    
    @Override
    public void run(){
        try{
            ArrayList<String> studenci = new ArrayList<>();
            ArrayList<Integer> liczba = new ArrayList<>();
            BufferedReader fr = new BufferedReader(new FileReader("studenci.csv"));
            String linia;
            while((linia=fr.readLine())!=null){
                String[] split = linia.split(";");
                String student=split[1]+" "+split[0];
                if(!studenci.contains(student)){
                    studenci.add(student);
                    liczba.add(0);
                }
                if(Integer.parseInt(split[3])==5){
                    int index=studenci.indexOf(student);
                    liczba.set(index,liczba.get(index)+1);
                }
            }
            fr.close();
            String result="";
            for(int i=0;i<studenci.size();i++){
                result+=studenci.get(i)+": "+Float.toString(liczba.get(i))+"\n";
            }
            synchronized(res){
                res.setText(result);
            }
        }
        catch(IOException ex){
            System.out.println("IOException");
        }
    }
}

public class lusnia extends javax.swing.JFrame {
    FileWriter fw;
    
    public lusnia() {
        initComponents();
        try{
            File file = new File("studenci.csv");
            if(!file.exists()){
                file.createNewFile();
            }
            fw = new FileWriter(file,true);
        }
        catch(IOException ex){
            System.out.println("IOException");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TextArea = new javax.swing.JTextArea();
        SaveButton = new javax.swing.JButton();
        CheckButton = new javax.swing.JButton();
        MeanInfoLabel = new javax.swing.JLabel();
        GradesInfoLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        MeanResultArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        GradesResultArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Program gr. 2");

        TextArea.setColumns(20);
        TextArea.setRows(5);
        jScrollPane1.setViewportView(TextArea);

        SaveButton.setText("Zapisz");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        CheckButton.setText("Stan wiedzy");
        CheckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckButtonActionPerformed(evt);
            }
        });

        MeanInfoLabel.setText("Srednie studentow:");

        GradesInfoLabel.setText("Liczba ocen 5:");

        MeanResultArea.setColumns(20);
        MeanResultArea.setRows(5);
        jScrollPane2.setViewportView(MeanResultArea);

        GradesResultArea.setColumns(20);
        GradesResultArea.setRows(5);
        jScrollPane3.setViewportView(GradesResultArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(SaveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CheckButton)
                .addGap(93, 93, 93))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MeanInfoLabel)
                        .addGap(124, 124, 124)
                        .addComponent(GradesInfoLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(CheckButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MeanInfoLabel)
                    .addComponent(GradesInfoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        try{
            fw.append(TextArea.getText()+"\n");
            fw.flush();
        }
        catch(IOException ex){
            System.out.println("IOException");
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void CheckButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckButtonActionPerformed
        Thread srednia = new Thread(new Srednia(MeanResultArea));
        Thread piec = new Thread(new Piec(GradesResultArea));
        srednia.start();
        piec.start();
        
    }//GEN-LAST:event_CheckButtonActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lusnia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CheckButton;
    private javax.swing.JLabel GradesInfoLabel;
    private javax.swing.JTextArea GradesResultArea;
    private javax.swing.JLabel MeanInfoLabel;
    private javax.swing.JTextArea MeanResultArea;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextArea TextArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
