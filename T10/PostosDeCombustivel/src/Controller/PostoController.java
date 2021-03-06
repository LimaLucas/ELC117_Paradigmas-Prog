package Controller;

import View.*;
import Model.TablePosto;
import Model.Posto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

/**
 *
 * @author LucasLima
 */
public class PostoController implements ActionListener {
    
    public PostoController(){}
    
    public void inicializaDados(TablePosto tablePostos){
        
        Posto P = new Posto();
        
        try{
            String strFile = "src\\Files\\dados.csv";

            BufferedReader br = new BufferedReader( new FileReader(strFile));
            String strLine = "";
            StringTokenizer st = null;
            int lineNumber = 0;

            while((strLine = br.readLine()) != null){
                lineNumber++;
                st = new StringTokenizer(strLine, ",");
                
                if(lineNumber == 1){
                    while(st.hasMoreTokens()){
                        st.nextToken();
                    }
                }else{

                    P = new Posto(Integer.parseInt(st.nextToken()), st.nextToken(), st.nextToken(), st.nextToken(), 
                                  st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
                    
                    if(P != null)
                        tablePostos.add(P);
                }
            }
        }catch(Exception e){
            System.out.println("Exceção durante leitura de arquivo CSV: " + e);
        };
    }
    
    public void visualizaPosto(TablePosto tablePostos, int indice){
        PostoView PV = new PostoView(tablePostos.select(indice));
        PV.setVisible(true);
        // Desabilita Botões
        PV.getBtnSalvar().setEnabled(false);
        PV.getBtnCarregar().setEnabled(false);
        PV.getBtnLimpar().setEnabled(false);
        
        // Desabilita edição dos campos de texto
        PV.getTxtBairro().setEditable(false);
        PV.getTxtBandeira().setEditable(false);
        PV.getTxtCep().setEditable(false);
        PV.getTxtCnpj().setEditable(false);
        PV.getTxtEndereco().setEditable(false);
        PV.getTxtNome().setEditable(false);
        PV.getTxtRazao().setEditable(false);
    }
    
    public void excluirPosto(TablePosto tablePostos, int indice){
        if(tablePostos.select(indice) != null)
            tablePostos.remove(indice);
    }
    
    public TablePosto editarPosto(TablePosto tablePostos, int indice){
        // Implementar o que falta
        
        return tablePostos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
