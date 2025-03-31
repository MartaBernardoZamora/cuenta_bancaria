package dev.martabernardo.cuenta.cuenta;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CuentaTest {
    @Test
    @DisplayName("test consignar")
    void testConsignar() {
        Cuenta cuenta = new Cuenta(100f);
        cuenta.consignar(50f);
        assertThat(cuenta.getSaldo(), is(150.00f));
    }
}
