/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.filtro;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *(A) Filtrado de redundancias: suprime del plano los puntos consecutivos que sean repetidos.
 * @author 2101751
 */
@Service
public class FiltroDeRedundancias implements BluePrintsFiltro{

    
    public Blueprint filtrar(Blueprint bp) {
        Blueprint bpfiltrado = new Blueprint(bp.getAuthor(), bp.getName());
        List<Point> points= bp.getPoints();
        Point[] pntsSinRedundacia = null;
        
        for(int i=0; i<points.size()-1;i++){
            if(points.get(i).equals(points.get(i+1))){
                points.remove(i+1);
                bpfiltrado.addPoint(points.get(i));
            }
        }
        
        return bpfiltrado;
    }
    
}
