package dev.martabernardo.cuenta.cuenta;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.junit.jupiter.api.DisplayName;

import java.util.Optional;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
public class CuentaServiceTest {
    @Mock
    private CuentaRepository repository;

    @Test
    @DisplayName("test createExtractoMensual")
    void testCreateExtractoMensual() {
       Cuenta cuenta = new Cuenta(100f, 0.08f);
       cuenta.consignar(40f);
       cuenta.retirar(5f);
       CuentaService cuentaService = new CuentaService(repository);

       when(repository.findById(cuenta.getNumeroCuenta())).thenReturn(Optional.of(cuenta));

       String extractoMensual = cuentaService.createExtractoMensual(cuenta.getNumeroCuenta());

       
       assertThat(extractoMensual, containsString("Saldo: 135.9"));
       assertThat(extractoMensual, containsString("Tasa anual: 0.08"));
       assertThat(extractoMensual, containsString("Consignaciones: 1"));
       assertThat(extractoMensual, containsString("Retiros: 1"));
       assertThat(extractoMensual, containsString("Comisión mensual: 0.0"));

    }

}
