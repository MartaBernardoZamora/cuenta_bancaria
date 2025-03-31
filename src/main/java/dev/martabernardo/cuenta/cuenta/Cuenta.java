package dev.martabernardo.cuenta.cuenta;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cuenta")
public class Cuenta {

    protected float saldo;
    protected float tasaAnual;

    public Cuenta(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = 0.08f;
    }

    public void consignar(float consigna) {
        saldo += consigna;
    }

    public void retirar(float retirada) {
        if (retirada > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        saldo -= retirada;
    }

    public void calcularInteresMensual() {
        float interesMensual = Math.round(tasaAnual / 12 * saldo * 100f)/100f;
        saldo += interesMensual;
    }

    public void getExtractoMensual() {
        calcularInteresMensual();
    }

}
