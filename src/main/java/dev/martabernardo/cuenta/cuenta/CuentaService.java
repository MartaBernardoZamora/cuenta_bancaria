package dev.martabernardo.cuenta.cuenta;

import org.springframework.stereotype.Service;

@Service

public class CuentaService {

    private CuentaRepository cuentaRepository;

    public CuentaService(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public String createExtractoMensual(String numeroCuenta) {
        Cuenta cuenta = cuentaRepository.findById(numeroCuenta).orElse(null);
        cuenta.getExtractoMensual();
        StringBuilder newExtracto = new StringBuilder();
        newExtracto.append("Saldo: ").append(cuenta.getSaldo()).append("\n");
        newExtracto.append("Tasa anual: ").append(cuenta.getTasaAnual()).append("\n");
        newExtracto.append("Consignaciones: ").append(cuenta.getConsignaciones()).append("\n");
        newExtracto.append("Retiros: ").append(cuenta.getRetiradas()).append("\n");
        newExtracto.append("Comisión mensual: ").append(cuenta.getComisionMensual()).append("\n");

        String extracto = newExtracto.toString();
        return extracto;        
    }

}
