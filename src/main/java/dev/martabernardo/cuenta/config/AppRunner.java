package dev.martabernardo.cuenta.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dev.martabernardo.cuenta.cuenta.CuentaService;

@Component
public class AppRunner implements CommandLineRunner {

    private CuentaService cuentaService;

    public AppRunner(CuentaService cuentaService) {
        this.cuentaService = cuentaService;        
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Cuenta 1294703658");
        System.out.println(cuentaService.createExtractoMensual("1294703658"));
        
        System.out.println("Cuenta 7341592086");
        System.out.println(cuentaService.createExtractoMensual("7341592086")); 
    }

}
