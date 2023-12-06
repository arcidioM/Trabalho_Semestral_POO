package com.sbmicrocredito;

import com.sbmicrocredito.view.TelaInicial;

/**
 *A <code>SbMicrocredito</code> representa o elo de ligacao entre
 * objectos Clientes e Funcionarios, esta classe leva_nos a todo o acesso do sistema.
 * Este sistema consiste em um tipo de empréstimo financeiro de pequeno valor concedido
 * a indivíduo ou pequenos empreendedores e pequenas empresas que tem a dificuldade de cessar
 * crédito convencional devido a falta de histórico de crédito ou recursos. Os <i>Clientes</i> sao
 * individuos que trarao servicos para organizacao e <i> Funcionarios</i> sao colaboradores que executaram os
 * servicos para um melhor desenpenho.
 * 
 * @author Arcidio Bernardo Munguambe Junior
 * @author Antonio Paulo Quibe
 * @version 1.3
 * @version 1.0
 * 
 */
public class SbMicrocredito {

    public static void main(String[] args) {
        /**
         * Faz a chamada da classe TelaInicial para que o sistema possa iniciar com as suas actividades.
         */
        new TelaInicial();
    }
}
