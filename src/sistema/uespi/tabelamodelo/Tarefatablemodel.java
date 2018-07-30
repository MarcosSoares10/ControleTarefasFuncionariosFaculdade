/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.uespi.tabelamodelo;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sistema.uespi.modelo.Tarefa;

/**
 *
 * @author Marquinhos
 */
public class Tarefatablemodel extends AbstractTableModel{
    private final List<Tarefa> tarefas;
    
    public Tarefatablemodel(List<Tarefa> tarefa){
    this.tarefas = tarefa;
    }

    @Override
    public int getRowCount() {
     return tarefas.size();
     }

    @Override
    public int getColumnCount() {
        return 5;
        }

    @Override
    public Object getValueAt(int indicelinha, int indicecoluna ) {
        Tarefa tarefa = tarefas.get(indicelinha);
        switch(indicecoluna){
               case 0: return tarefa.getIdTarefa();
               case 1: return tarefa.getAssunto();
               case 2: return tarefa.getDatafinal();
               case 3: return tarefa.getNomeDepart();
               case 4: return tarefa.getEstado_tarefa();
               
               
        
        }
        return null;
        }
    
    @Override
	public String getColumnName(int coluna){
		switch (coluna) {
			case 0: return "Id";
			case 1: return "Nome";
                        case 2: return "Prazo Final";
                        case 3: return "Departamento";
                        case 4: return "Estado da Tarefa";
					}
		return "";
	}

    /**
     * @return the tarefas
     */
    public Tarefa getTarefa(int ind){
    return tarefas.get(ind);
    
    }
    
}
