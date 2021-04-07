/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.io.*;
//import javax.swing.JOptionPane;
import java.util.*;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 *
 * @author ricar
 */
public class Parser {
    public static ArrayList<String> separados = new ArrayList<String>();
    public String txt="";
    static String[] operadores= new String[100];
    static int nO=0;
    static String[] id= new String[100];
    static int nId=0;
    static String[] numerosE=new String[100];
    static int nNuE=0;
    static String[] numerosD=new String[100];
    static int nNuD=0;
    static String[] loquesobra= new String[100];
    static int nloquesobra=0;
    static String[] limitante= new String[100];
    static int nlimitante=0;
    static String[] palabrasReservadas= new String[100];
    static int nPR=0;
    static String[] separaditos= new String[101];
    static int nS=0;
    static String[] tSeparaditos=new String[100];
    static int t;
    static int contador=0;
    static int aux;
    
    public String buscarArchivo(){
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File archivo = fc.getSelectedFile();
        
        try{
            FileReader fr = new FileReader(archivo);
            BufferedReader br= new BufferedReader(fr);
            
            String brread;
            
            while((brread=br.readLine()) != null ){
                if(!(brread.equals(""))){
                   txt = txt + brread+"$";   
                }
            }          
               
        }catch(IOException er){
            System.out.println("No se encontro el documento de texto");
        }
          /*  */
        return txt;    
    }
    
    public void evaluar(String txt){
        
    String[] operadoresB={"=","{","}","(",")"};    
    String[] palabrasReservadasB={"if","while","else"};    
    String[] numerosB={"0","1","2","3","4","5","6","7","8","9"};
    String[] limitantesB={";",","};
    
    String txtx=txt;
    System.out.println(txt);

    txtx=txtx.substring(0, txtx.length()-1);
    
            while(txt.length()>0){
                
                while(txt.charAt(0)==' '){//elimina los primeros espacios
                txt=txt.substring(1);
                }
                
                t=scanner(txt).length();
                separaditos[contador]=scanner(txt);
                
                txt=txt.substring(t);
                contador++;
            }
            
            for(int i=0;i<contador;i++){
                tSeparaditos[i]=separaditos[i];
            }
            for(int i=0;i<contador;i++){
                separados.add(i,tSeparaditos[i]);
            }
            
            
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Usar una copia del array separado, usaremos el tSeparadito para la evaluacion
    aux=contador;
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    for(int i=0;i<aux;i++){
        
        for (int op=0;op<operadoresB.length;op++) {
           
            if(tSeparaditos[i].equals(operadoresB[op])){
                
                operadores[nO]=tSeparaditos[i];
                nO++;
                
                tSeparaditos=eliminacion(tSeparaditos,i);
                aux--;
                i--;
                op=0;
            }   
        }        
            
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   

    for(int i=0;i<aux;i++){
        
        for (int li=0;li<limitantesB.length;li++) {
           
            if(tSeparaditos[i].equals(limitantesB[li])){
                
                limitante[nlimitante]=tSeparaditos[i];
                nlimitante++;
                
                tSeparaditos=eliminacion(tSeparaditos,i);
                aux--;
                i--;
                li=0;
            }   
        }        
            
    }
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    for(int j=0;j<aux;j++){
        
        for(int pr=0;pr<palabrasReservadasB.length;pr++){
            
           if(tSeparaditos[j].equals(palabrasReservadasB[pr])) {
              
               palabrasReservadas[nPR]=tSeparaditos[j];
               nPR++;
                    
               tSeparaditos=eliminacion(tSeparaditos,j);
               aux--;
               if(j!=0){
                        j--; 
                    }
               pr=0;
               if(tSeparaditos==null){
                   pr=palabrasReservadasB.length;
                   j=aux;
               }
           }
           
        }
        
    }
    
    for(int k=0;k<aux;k++){
        
        if((tSeparaditos[k].charAt(0)>='a' && tSeparaditos[k].charAt(0)<='z') || (tSeparaditos[k].charAt(0)>='A' && tSeparaditos[k].charAt(0)<='Z')){
            
            id[nId]=tSeparaditos[k];
            nId++;
                    
            tSeparaditos=eliminacion(tSeparaditos,k);
            aux--;
            k--;
            
        }
        
    }
    
    for(int l=0;l<aux;l++){
        
        for(int nn=0;nn<numerosB.length;nn++){
        
            if(tSeparaditos[l].charAt(0)==numerosB[nn].charAt(0)){
            
                int i1=0;
                boolean bandera=true;
                boolean key;
                
                while(tSeparaditos[l].charAt(i1)!='.' && bandera){
                    i1++;
                    if(i1==tSeparaditos[l].length()){
                        bandera=false;
                        i1--;
                    }
                }
                key=tSeparaditos[l].charAt(i1)!='.';
                
                if(key==true){
                    numerosE[nNuE]=tSeparaditos[l];
                    nNuE++;
                    
                    tSeparaditos=eliminacion(tSeparaditos,l);
                    aux--;
                    if(l!=0){
                        l--; 
                    }else{
                        l=0;
                        }
                    nn=0;
                }
                if(key==false){
                    numerosD[nNuD]=tSeparaditos[l];
                    nNuD++;
                    
                    tSeparaditos=eliminacion(tSeparaditos,l);
                    aux--;
                    if(l!=0){
                            l--; 
                        }else{
                            l=0;
                        }
                    nn=0;
                }
                
            }
            
        }
        
    } 
    
    for(int efe=0;efe<aux;efe++){
        if(tSeparaditos[efe].equals("$")){
        }else{
            loquesobra[efe]=tSeparaditos[efe];
        
            nloquesobra++;  
        }
        
    }
    
        
    System.out.print("La lineas son : ");
    for(int i=0;i<txtx.length();i++){
        if(txtx.charAt(i)=='$'){
            System.out.print(" // ");
        }else{
         System.out.print(txtx.charAt(i));      
        }
        
    }
        System.out.println("");    
        System.out.println("\n");
       
        /*Interfaz i = new Interfaz();
        i.mostrarDatos(operadores, nO,limitante,nlimitante,palabrasReservadas,nPR,id,nId,numerosE,nNuE,numerosD,nNuD,loquesobra,nloquesobra);*/
    }

public String scanner(String fuentetexto){
        
    String txt=fuentetexto;
    
    String token="";    
    int vi=0;
    boolean key=true;
    
        while(txt.charAt(vi)==' '){//ignora los primeros espacios
        vi++;
        }
    
    char c=txt.charAt(vi);
    if (vi >= txt.length()) {
	     c = '$';  // fin de cadena
	  }
        
        if ((c>='a' && c<='z') || (c>='A' && c<='Z')){ //Letra
            while (((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9')) && key) {
                
              token= token+Character.toString(c);
              vi++;
              if((vi)!=txt.length()){
              c=txt.charAt(vi);    
              }else{
                  key=false;
              }
              
              
            }

        }else if (c>='0' && c<='9')	{  // Numero
                
		  while (((c>='0' && c<='9') || (c=='.') && key)){
                        
			 token = token+c;
			 vi++;
                         if((vi)!=txt.length()){
                         c=txt.charAt(vi);    
                        }else{
                             
                        key=false;
                        }
                        
                         if(txt.charAt(vi-1)=='.' &&((txt.charAt(vi)>='a' && txt.charAt(vi)<='z') || (txt.charAt(vi)>='A' && txt.charAt(vi)<='Z') )){
                            
                          token=token.substring(0,(vi-1));
                         }
                            
                            
                            
                         
		  }
            } else if (c=='(' || c==')' || c=='=' || c=='*' || c=='/' || c=='-' || c=='+' || c=='<' || c=='>' || c==';' || c==',' || c=='{' || c=='}' ){  // Operador
                        
                        token = Character.toString(c);
                        
			if ((c=='-' && txt.charAt(vi+1)=='-') || (c=='+' && txt.charAt(vi+1)=='+') || (c=='<' && txt.charAt(vi+1)=='=') || (c=='>' && txt.charAt(vi+1)=='=') || (c=='<' && txt.charAt(vi+1)=='<') || (c=='>' && txt.charAt(vi+1)=='>') ){
			
                            token = token + Character.toString(txt.charAt(vi+1));
                            vi++;
			}
                        
                    }else if (c=='$') { // fin de cadena
                                     token = Character.toString(c);
                          }	 

    return token;
    }

public String[] eliminacion(String[] array,int vActual){
        
        
        while(array[vActual+1]!=null){
            
            array[vActual]=array[vActual+1];
            vActual++;
        }
        if(array[vActual+1]==null){
            array[vActual]= null;
        }
    return array;    
        
    }

}