package dev.martabernardo.cuenta.cuenta;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Random;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cuentas")
public class Cuenta {
    @Id
    @Column(name = "numero_cuenta", unique = true, length = 10, nullable = false)
    protected String numeroCuenta;

    protected float saldo;

    @Column(name = "tasa_anual")
    protected float tasaAnual;
    protected int consignaciones;
    protected int retiradas;

    @Column(name = "comision_mensual")
    protected float comisionMensual;

    public Cuenta(float saldo, float tasaAnual) {
        this.numeroCuenta = generarNumeroCuenta();
        this.saldo = saldo;
        this.tasaAnual = 0.08f;
        this.consignaciones = 0;
        this.retiradas = 0;
        this.comisionMensual = 0.00f;
    }

    public void consignar(float consigna) {
        saldo += consigna;
        consignaciones++;
    }

    public void retirar(float retirada) {
        if (retirada > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        saldo -= retirada;
        retiradas++;
    }

    public void calcularInteresMensual() {
        float interesMensual = Math.round(tasaAnual / 12 * saldo * 100f)/100f;
        saldo += interesMensual;
    }

    public void getExtractoMensual() {
        saldo -= comisionMensual;
        calcularInteresMensual();
    }
    public String generarNumeroCuenta() {
        Random random = new Random();
        long numero = 1000000000L + (long)(random.nextDouble() * 8999999999L);
        return String.valueOf(numero);
    }

}
