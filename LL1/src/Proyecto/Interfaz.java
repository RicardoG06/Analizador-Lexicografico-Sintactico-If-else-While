/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.util.regex.Pattern;

/**
 *
 * @author ricar
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    public String texto;
    Parser parser = new Parser();
    public int i= 0;
    public int cont = 1;
    
    public Interfaz() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    public void mostrarAreaTexto(String t){
        
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)!='$'){
            Texto1.append(String.valueOf(t.charAt(i)));    
            }else{
                Texto1.append("\n");
            }
            
        }
    }
    
    
    
    
    
    
    public void mostrarDatos( ){
        
        int i;
        
        if(Parser.nO!=0){
        
            Texto2.append("Los operadores: ");
        i=0;
        
        while(i!=Parser.nO){
            Texto2.append(Parser.operadores[i]);
            
                if(i!=(Parser.nO-1)){
                    
                     Texto2.append(",");
                }
                
        i++;       
        }
        Texto2.append("\nLa cantidad de operadores son: "+Parser.nO);
        }else{
            Texto2.append("No existen operadores.");
            
        }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Texto2.append("\n");
        if(Parser.nlimitante!=0){
        
            Texto2.append("Los limitantes: ");
        i=0;
        
        while(i!=Parser.nlimitante){
            Texto2.append(Parser.limitante[i]);
            
                if(i!=(Parser.nlimitante-1)){
                    
                     Texto2.append(" , ");
                }
                
        i++;       
        }
        Texto2.append("\nLa cantidad de limitantes son: "+Parser.nlimitante);
        }else{
            Texto2.append("No existen limitantes.");
            
        }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Texto2.append("\n");
        if(Parser.nPR!=0){
        
            Texto2.append("Las palabras reservadas son: ");
        i=0;
        
        while(i!=Parser.nPR){
            Texto2.append(Parser.palabrasReservadas[i]);
            
                if(i!=(Parser.nPR-1)){
                    
                     Texto2.append(",");
                }
                
        i++;       
        }
        Texto2.append("\nLa cantidad de palabras reservadas son: "+Parser.nPR);
        }else{
            Texto2.append("No existen palabras reservadas.");
            
        }
        
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Texto2.append("\n");
        if(Parser.nId!=0){
        
            Texto2.append("Los ID son: ");
        i=0;
        
        while(i!=Parser.nId){
            Texto2.append(Parser.id[i]);
            
                if(i!=(Parser.nId-1)){
                    
                     Texto2.append(",");
                }
                
        i++;       
        }
        Texto2.append("\nLa cantidad de ID son: "+Parser.nId);
        }else{
            Texto2.append("No existen ID.");
            
        }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Texto2.append("\n");
        if(Parser.nNuE!=0){
        
            Texto2.append("Los numeros enteros son: ");
        i=0;
        
        while(i!=Parser.nNuE){
            Texto2.append(Parser.numerosE[i]);
            
                if(i!=(Parser.nNuE-1)){
                    
                     Texto2.append(",");
                }
                
        i++;       
        }
        Texto2.append("\nLa cantidad de numeros enteros son: "+Parser.nNuE);
        }else{
            Texto2.append("No existen numeros enteros.");
            
        }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
        Texto2.append("\n");
        if(Parser.nNuD!=0){
        
            Texto2.append("Los numeros decimales son: ");
        i=0;
        
        while(i!=Parser.nNuD){
            Texto2.append(Parser.numerosD[i]);
            
                if(i!=(Parser.nNuD-1)){
                    
                     Texto2.append(",");
                }
                
        i++;       
        }
        
        Texto2.append("\nLa cantidad de numeros decimales son: "+Parser.nNuD);
        }else{
            Texto2.append("No existen numeros decimales.");
            
        }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////                
        
        Texto2.append("\n");
        if(Parser.nloquesobra!=0){
        
            Texto2.append("Los que no estan clasificados son: ");
        i=0;
        
        while(i!=Parser.nloquesobra){
            if(Parser.loquesobra[i]!= "$"){
                
            
            Texto2.append(Parser.loquesobra[i]);
            
                if(i!=(Parser.nloquesobra-1)){
                    
                     Texto2.append(", ");
                }
            }    
        i++;       
        }
        Texto2.append("\nLa cantidad de no clasificados son: "+Parser.nloquesobra);
        }else{
            Texto2.append("No sobra nada.");
            
        }
        
        System.out.println(Parser.separados);

        
    }
    
    //Parser
    
    public void S(){
        if (i < Parser.separados.size()){
        switch (Parser.separados.get(i)) {
            case "if":
                I();
                break;
            case "while":
                W();
                break;
            default:
                Texto3.append("\nError en la linea " + cont + ", se inicializa con un while o un if");
                cont++;
                break;
        }
        }
    }    
    public void I(){
        if (i < Parser.separados.size()){
        if(Parser.separados.get(i).equals("if")){
            i++;
            if(Parser.separados.get(i).equals("(")){
               i++; 
               if(Parser.separados.get(i).equals(")")){
                    i++;
                    if(Parser.separados.get(i).equals("$")){
                        i++; 
                        Texto3.append("\nLinea " + cont + " correcta");
                        cont++;
                        D();
                    }
                    else if(Parser.separados.get(i).equals("{")){
                        i++;
                        if(Parser.separados.get(i).equals("$")){
                            i++; 
                            Texto3.append("\nLinea " + cont + " correcta");
                            cont++;
                            B();
                        }}
                    else{
                        Texto3.append("\nError en la linea " + cont + " .Luego de un parentesis debe seguir un corchete");
                        cont++;
                        }       
               }
               else{
                    Texto3.append("\nError en la linea " + cont + " .No has colocado un ')' en el if");
                    cont++;
                    }
            }
            else{
               Texto3.append("\nError en la linea " + cont + " . Has colocado mal los corchetes"); 
               cont++;
            }
        }
    }
    }
    
    public void W(){
        if (i < Parser.separados.size()){
        if(Parser.separados.get(i).equals("while")){
            i++;
            if(Parser.separados.get(i).equals("(")){
               i++; 
               if(Parser.separados.get(i).equals(")")){
                    i++;
                    if(Parser.separados.get(i).equals("$")){
                        i++; 
                        Texto3.append("\nLinea " + cont + " correcta");
                        cont++;
                        D();
                    }
                    else if(Parser.separados.get(i).equals("{")){
                        i++;
                        if(Parser.separados.get(i).equals("$")){
                            i++; 
                            Texto3.append("\nLinea " + cont + " correcta");
                            cont++;
                            B();
                        }}
                    else{
                        Texto3.append("\nError en la linea " + cont + " .Luego de un parentesis debe seguir un corchete");
                        cont++;
                        }       
               }
               else{
                    Texto3.append("\nError en la linea " + cont + " .No has colocado un ')' en el while");
                    cont++;
                    }
            }
            else{
               Texto3.append("\nError en la linea " + cont + " . Has colocado mal los parentesis"); 
               cont++;
            }
        }
    }
    }
    
    public void D(){
        if (i < Parser.separados.size()){
        if (Parser.separados.get(i).equals("{")){
            i++;
            if(Parser.separados.get(i).equals("$")){
                i++; 
                Texto3.append("Linea " + cont + " correcta");
                cont++;}
            else if(Parser.separados.get(i).equals("if")|| Parser.separados.get(i).equals("while") || Parser.separados.get(i).equals("}") ){
                B();
            }
            else if(Pattern.matches("[a-zA-Z]+", Parser.separados.get(i))){
                B();
            }
            else{
                Texto3.append("\nError en la linea " + cont + " .Debe seguir una sentencia valida");
                cont++;
            }
        }
        else{
            Texto3.append("\nError en la linea " + cont + " . Luego de un parentesis , sigue un corchete"); 
            cont++;
        }
    }
    }
    public void B(){
        if (i < Parser.separados.size()){
        if(Pattern.matches("[a-zA-Z]+", Parser.separados.get(i)) && !"while".equals(Parser.separados.get(i)) && !"if".equals(Parser.separados.get(i))){
            i++;
            if(Parser.separados.get(i).equals("=")){
                i++;
                if(Character.toString(Parser.separados.get(i).charAt(0)).matches("[0-9]+")){
                    i++;
                    if(Parser.separados.get(i).equals(";")){
                        i++;
                        if(Parser.separados.get(i).equals("}")){
                            i++;
                            if(Parser.separados.get(i).equals("$")){
                                i++;
                                Texto3.append("\nLinea " + cont + " correcta");
                                cont++;
                                B();
                            }
                            else if(Parser.separados.get(i).equals("}")){
                                i++;
                                if(Parser.separados.get(i).equals("$")){
                                    i++;
                                    Texto3.append("\nLinea " + cont + " correcta");
                                    cont++;
                                    Y();
                                }
                                else{
                                    Texto3.append("\nError en la linea " + cont + " .No pueden seguir mas palabras en la linea");
                                    cont++;
                                }
                            }
                            else{
                                Texto3.append("\nError en la linea " + cont + " . Falta un corchete para cerrar el enunciado");
                                cont++;
                            }
                        }
                        else if(Parser.separados.get(i).equals("$")) {
                                i++;
                                Texto3.append("\nLinea " + cont + " correcta");
                                cont++;
                                B(); }
                        else{
                            Texto3.append("\nError en la linea " + cont + " . la linea debe acabar en ';' o '}' , no pueden seguir palabras"); 
                            cont++;
                        }
                    }
                    else{
                        Texto3.append("\nError en la linea " + cont + " . Todo texto acaba en ';'"); 
                        cont++;
                    }
                }
                else{
                    Texto3.append("\nError en la linea " + cont + " . El valor guardado en el id debe ser numerico"); 
                    cont++; 
                }
            }
            else{
                Texto3.append("\nError en la linea " + cont + " . Luego de un ID debe seguir un '='"); 
                cont++;
            }
        }
        else if(Parser.separados.get(i).equals("if")){
            I();
        }
        else if(Parser.separados.get(i).equals("while")){
            W();
        }
        else if(Parser.separados.get(i).equals("}")){
            i++;
            if(Parser.separados.get(i).equals("$")){
                i++;
                Texto3.append("\nLinea " + cont + " correcta");
                cont++;
                Y(); 
            }
            else if(Parser.separados.get(i).equals("else")){
                Y();
            }
            else{
                Texto3.append("\nError en la linea " + cont + " . No puede seguir mas palabras"); 
                cont++;
            }
           
        }
        else if (Parser.separados.get(i).equals("else")){
            Y();
        }
        else{
            Texto3.append("\nError en la linea " + cont + " . Palabra indeterminada"); 
            cont++;
        }
    }
    }
    
    public void Y(){
        if (i < Parser.separados.size()){
        if (Parser.separados.get(i).equals("else")){
            i++;
            if (Parser.separados.get(i).equals("$")){
                i++;
                Texto3.append("\nLinea " + cont + " correcta");
                cont++;
                D();
            }
            else if(Parser.separados.get(i).equals("{")){
                i++;
                if (Parser.separados.get(i).equals("$")){
                    i++;
                    Texto3.append("\nLinea " + cont + " correcta");
                    cont++;
                    B();
                }
                else{
                    B(); 
                }
            }
            else{
                Texto3.append("\nError en la linea " + cont + " . Falta determinar corchetes");
                cont++;
            }
        }
        else if(Parser.separados.get(i).equals("}")){
            i++;
            if (Parser.separados.get(i).equals("$")){
                i++;
                Texto3.append("\nLinea " + cont + " correcta");
                cont++;
                Y();
            }
        else{
           Texto3.append("\nError en la linea " + cont + " . Palabras incoherentes");
           cont++;
        }
    }
    }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Boton_AbrirArchivo = new javax.swing.JButton();
        Boton_AnalizarL = new javax.swing.JButton();
        Boton_Limpiar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Texto1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        Texto2 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        Boton_AnalizarS = new javax.swing.JButton();
        Boton_Limpiar2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Texto3 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Analizador Lexico");

        Boton_AbrirArchivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Boton_AbrirArchivo.setText("Abrir Archivo");
        Boton_AbrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_AbrirArchivoActionPerformed(evt);
            }
        });

        Boton_AnalizarL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Boton_AnalizarL.setText("Analizar");
        Boton_AnalizarL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_AnalizarLActionPerformed(evt);
            }
        });

        Boton_Limpiar1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Boton_Limpiar1.setText("Limpiar");
        Boton_Limpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_Limpiar1ActionPerformed(evt);
            }
        });

        Texto1.setColumns(20);
        Texto1.setRows(5);
        jScrollPane1.setViewportView(Texto1);

        Texto2.setColumns(20);
        Texto2.setRows(5);
        jScrollPane2.setViewportView(Texto2);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Analizador Sintactico");

        Boton_AnalizarS.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Boton_AnalizarS.setText("Analizar");
        Boton_AnalizarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_AnalizarSActionPerformed(evt);
            }
        });

        Boton_Limpiar2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Boton_Limpiar2.setText("Limpiar");
        Boton_Limpiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_Limpiar2ActionPerformed(evt);
            }
        });

        Texto3.setColumns(20);
        Texto3.setRows(5);
        jScrollPane3.setViewportView(Texto3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(238, 238, 238))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(225, 225, 225))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Boton_AbrirArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Boton_AnalizarL)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                                        .addComponent(Boton_Limpiar1))
                                    .addComponent(jScrollPane2)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Boton_AnalizarS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Boton_Limpiar2)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Boton_AbrirArchivo)
                    .addComponent(Boton_AnalizarL)
                    .addComponent(Boton_Limpiar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Boton_AnalizarS)
                    .addComponent(Boton_Limpiar2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Boton_AbrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_AbrirArchivoActionPerformed
        
        Parser parser = new Parser();
        texto = parser.buscarArchivo();
        mostrarAreaTexto(texto);
        System.out.println(texto);
    }//GEN-LAST:event_Boton_AbrirArchivoActionPerformed

    private void Boton_AnalizarLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_AnalizarLActionPerformed
        parser.evaluar(texto);
        mostrarDatos();
    }//GEN-LAST:event_Boton_AnalizarLActionPerformed

    private void Boton_AnalizarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_AnalizarSActionPerformed
        S();
    }//GEN-LAST:event_Boton_AnalizarSActionPerformed

    private void Boton_Limpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_Limpiar1ActionPerformed
      Texto1.setText("");
      Texto2.setText("");
    }//GEN-LAST:event_Boton_Limpiar1ActionPerformed

    private void Boton_Limpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_Limpiar2ActionPerformed
      Texto3.setText("");
    }//GEN-LAST:event_Boton_Limpiar2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_AbrirArchivo;
    private javax.swing.JButton Boton_AnalizarL;
    private javax.swing.JButton Boton_AnalizarS;
    private javax.swing.JButton Boton_Limpiar1;
    private javax.swing.JButton Boton_Limpiar2;
    private javax.swing.JTextArea Texto1;
    private javax.swing.JTextArea Texto2;
    private javax.swing.JTextArea Texto3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
