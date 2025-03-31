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

    public Cuenta(float saldo) {
        this.saldo = saldo;
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

}
