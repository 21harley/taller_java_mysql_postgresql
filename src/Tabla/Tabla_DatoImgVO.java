package Tabla;

import DAO.DatoImgDAO;
import VO.DatoImg;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Tabla_DatoImgVO{

    DatoImgDAO dao = new DatoImgDAO();
    int in=0;
    ArrayList<DatoImg> list = null;
    
    public void visualizar_DatoImgVO(JTable tabla,int pos){
        list = dao.Listar_DatoImgVO();
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        dt.addColumn("idRegistro");
        dt.addColumn("nombre");
        dt.addColumn("latitud");
        dt.addColumn("longitud");
        dt.addColumn("Foto");
        
        DatoImg vo = new DatoImg();

        if(list.size() > 0&&pos>-1&&pos<=list.size()){
                Object fila[] = new Object[5];
                vo = list.get(pos);
                fila[0] = vo.getIdRegistro();
                fila[1] = vo.getNombre();
                fila[2] = vo.getLatitud();
                fila[3] = vo.getLongitud();
                try{
                    byte[] bi = vo.getFoto();
                    InputStream in = new ByteArrayInputStream(bi);
                    BufferedImage image = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                    fila[4] = new JLabel(imgi);

                }catch(Exception ex){
                    fila[4] = new JLabel("No imagen");
                }
                dt.addRow(fila);
            
            in=1;
        }else if(list.size()==0){
            Object fila[] = new Object[5];
            fila[0] = "";
            fila[1] = "";
            fila[2] = "";
            fila[3] = "";
            fila[4] = "";
            dt.addRow(fila); 
            in=-1;
        }
         tabla.setModel(dt);
         tabla.setRowHeight(60);
    }
    
    public int getIn(){
        return this.in;
    }
    public int getSice(){
        return list.size();
    }
    public ArrayList<DatoImg> getList(){
        return list;
    }
}


