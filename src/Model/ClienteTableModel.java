package Model;

import Entity.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ClienteTableModel extends AbstractTableModel {

    private List<Cliente> clientes;
    private String[] colunas = new String[]{
        "Nome", "RG", "CPF", "CNH"};

    public ClienteTableModel(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ClienteTableModel() {
        this.clientes = new ArrayList<Cliente>();
    }

    public int getRowCount() {
        return clientes.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public void setValueAt(Cliente aValue, int rowIndex) {
        Cliente cliente = clientes.get(rowIndex);
        cliente.setNome(aValue.getNome());
        cliente.setRg(aValue.getNome());
        cliente.setCpf(aValue.getNome());
        cliente.setCnh(aValue.getNome());
        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Cliente carro = clientes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                carro.setNome(aValue.toString());
            case 1:
                carro.setRg(aValue.toString());
            case 2:
                carro.setCpf(aValue.toString());
            case 3:
                carro.setCnh(aValue.toString());
            default:
                System.err.println("Índice da coluna inválido");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente carroSelecionado = clientes.get(rowIndex);
        String valueObject = null;
        switch (columnIndex) {
            case 0:
                valueObject = carroSelecionado.getNome().toString();
                break;
            case 1:
                valueObject = carroSelecionado.getRg().toString();
                break;
            case 2:
                valueObject = carroSelecionado.getCpf().toString();
                break;
            case 3:
                valueObject = carroSelecionado.getCnh().toString();
                break;
            default:
                System.err.println("Índice inválido para propriedade do bean Cliente.class");
        }
        return valueObject;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Cliente get(int indiceLinha) {
        return clientes.get(indiceLinha);
    }

    public void add(Cliente u) {
        clientes.add(u);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void remove(int indiceLinha) {
        clientes.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addList(List<Cliente> novosClientes) {
        int tamanhoAntigo = getRowCount();
        clientes.addAll(novosClientes);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    public void clear() {
        clientes.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return clientes.isEmpty();
    }
}
