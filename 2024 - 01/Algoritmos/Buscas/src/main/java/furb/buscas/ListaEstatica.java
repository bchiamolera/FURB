/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.buscas;

/**
 *
 * @author Bernardo Chiamolera
 */
public class ListaEstatica<T> extends ListaAbstract<T> {

    @Override
    public void inserir(T valor) {
        int _tamanho = this.getTamanho();
        T[] _info = this.getInfo();
        
        if (_tamanho >= _info.length) {
            redimensionar();
            _info = this.getInfo();
        }
        _info[_tamanho - 1] = valor;
        this.setTamanho(_tamanho + 1);
    }

    @Override
    public int buscar(T valor) {
        T[] _info = this.getInfo();
        int _tamanho = this.getTamanho();
        
        for (int i = 0; i < _tamanho; i++) {
            if (_info[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }
    
}
