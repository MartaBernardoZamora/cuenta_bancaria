package dev.martabernardo.cuenta.cuenta;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CuentaTest {

    Cuenta cuenta;

    @BeforeEach
    void setUp() throws Exception {
        cuenta = new Cuenta(100f, 0.08f);
    }
    @Test
    @DisplayName("test consignar")
    void testConsignar() {
        cuenta.consignar(50f);
        assertThat(cuenta.getSaldo(), is(150.00f));
    }
    @Test
    @DisplayName("test retirar")
    void testRetirar() {
        cuenta.retirar(50f);
        assertThat(cuenta.getSaldo(), is(50.00f));
    }
    @Test
    @DisplayName("test retirar insuficiente")
    void testRetirarInsuficiente() {    
        assertThrows(IllegalArgumentException.class, () -> {
            cuenta.retirar(150f);
        });
        assertThat(cuenta.getSaldo(), is(100.00f));
    }
    @Test
    @DisplayName("test calcular interés mensual")
    void testCalcularInteresMensual() {
        cuenta.calcularInteresMensual();
        assertThat(cuenta.getSaldo(), is(100.67f));
    }
    @Test
    @DisplayName("test extracto mensual")
    void testGetExtractoMensual() {
        cuenta.getExtractoMensual();
        assertThat(cuenta.getSaldo(), is(100.67f));
    }
    @Test
    @DisplayName("test generar numero de cuenta")
    void testGenerarNumeroCuenta() {
        assertThat(cuenta.generarNumeroCuenta().length(), is(10));
    }
    @Test
    @DisplayName("test contar consignaciones")
    void testContarConsignaciones() {
        cuenta.consignar(50f);
        assertThat(cuenta.getConsignaciones(), is(1));
    }
    @Test
    @DisplayName("test contar retiradas")
    void testContarRetiradas() {
        cuenta.retirar(50f);
        assertThat(cuenta.getRetiradas(), is(1));
    }
}
