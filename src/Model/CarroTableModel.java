package Model;

import Entity.Carro;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CarroTableModel extends AbstractTableModel {

    private List<Carro> carros;
    private String[] colunas = new String[]{
        "Id", "Nome", "Marca", "Chassis", "Placa", "Kilometragem", "Status", "Valor Dia", "Data Retirada", "Data Devolução", "CPF Cliente"};

    public CarroTableModel(List<Carro> carros) {
        this.carros = carros;
    }

    public CarroTableModel() {
        this.carros = new ArrayList<Carro>();
    }

    public int getRowCount() {
        return carros.size();
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

    public void setValueAt(Carro aValue, int rowIndex) {
        Carro carro = carros.get(rowIndex);
        carro.setId(aValue.getId());
        carro.setNome(aValue.getNome());
        carro.setMarca(aValue.getMarca());
        carro.setChassis(aValue.getChassis());
        carro.setPlaca(aValue.getPlaca());
        carro.setKilometragem(aValue.getKilometragem());
        carro.setStatus(aValue.getStatus());
        carro.setValorDia(aValue.getValorDia());
        carro.setDataRetirada(aValue.getDataRetirada());
        carro.setDataDevolucao(aValue.getDataDevolucao());
        carro.setClienteId(aValue.getClienteId());
        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3);
        fireTableCellUpdated(rowIndex, 4);
        fireTableCellUpdated(rowIndex, 5);
        fireTableCellUpdated(rowIndex, 6);
        fireTableCellUpdated(rowIndex, 7);
        fireTableCellUpdated(rowIndex, 8);
        fireTableCellUpdated(rowIndex, 9);
        fireTableCellUpdated(rowIndex, 10);

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Carro carro = carros.get(rowIndex);
        switch (columnIndex) {
            case 0:
                carro.setId((Integer) aValue);
            case 1:
                carro.setNome(aValue.toString());
            case 2:
                carro.setMarca(aValue.toString());
            case 3:
                carro.setChassis(aValue.toString());
            case 4:
                carro.setPlaca(aValue.toString());
            case 5:
                carro.setKilometragem((Double) aValue);
            case 6:
                carro.setStatus((Integer) aValue);
            case 7:
                carro.setValorDia((Double) aValue);
            case 8:
                carro.setDataRetirada((Date) aValue);
            case 9:
                carro.setDataDevolucao((Date) aValue);
            case 10:
                carro.setClienteId(aValue.toString());
            default:
                System.err.println("Índice da coluna inválido");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Carro carroSelecionado = carros.get(rowIndex);
        String valueObject = null;
        switch (columnIndex) {
            case 0:
                valueObject = carroSelecionado.getId().toString();
                break;
            case 1:
                valueObject = carroSelecionado.getNome();
                break;
            case 2:
                valueObject = carroSelecionado.getMarca();
                break;
            case 3:
                valueObject = carroSelecionado.getChassis();
                break;
            case 4:
                valueObject = carroSelecionado.getPlaca();
                break;
            case 5:
                valueObject = carroSelecionado.getKilometragem().toString();
                break;
            case 6:
                valueObject = carroSelecionado.getStatus().toString();
                break;
            case 7:
                valueObject = carroSelecionado.getValorDia().toString();
                break;
            case 8:
                if (carroSelecionado.getDataRetirada() != null) {
                    valueObject = carroSelecionado.getDataRetirada().toString();
                }
                break;
            case 9:
                if (carroSelecionado.getDataDevolucao() != null) {
                    valueObject = carroSelecionado.getDataDevolucao().toString();
                }
                break;
            case 10:
                valueObject = carroSelecionado.getClienteId().toString();
                break;
            default:
                System.err.println("Índice inválido para propriedade do bean Carro.class");
        }
        return valueObject;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Carro get(int indiceLinha) {
        return carros.get(indiceLinha);
    }

    public void add(Carro u) {
        carros.add(u);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void remove(int indiceLinha) {
        carros.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addList(List<Carro> novosCarros) {
        int tamanhoAntigo = getRowCount();
        carros.addAll(novosCarros);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    public void clear() {
        carros.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return carros.isEmpty();
    }
}
