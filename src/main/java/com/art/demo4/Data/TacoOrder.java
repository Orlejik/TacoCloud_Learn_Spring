package com.art.demo4.Data;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Getter
@Setter
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "order_id", nullable = false, unique = true)
    private Long id;
    @Column(name = "order_placed", nullable = false)
    private Date placedAt;
    @NotBlank(message = "Delivery name is required")
    @Column(name = "delivery_name")
    private String deliveryName;
    @NotBlank(message = "Delivery name is required")
    @Column(name = "deliveryStreet")
    private String deliveryStreet;
    @NotBlank(message = "Delivery name is required")
    @Column(name = "deliveryCity")
    private String deliveryCity;
    @NotBlank(message = "Delivery name is required")
    @Column(name = "deliveryState")
    private String deliveryState;
    @NotBlank(message = "Delivery name is required")
    @Column(name = "deliveryZipPostalCode")
    private String deliveryZip;
    @CreditCardNumber(message = "not a valid credit card number")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message = "Must be formatted MM/YY")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "invalid CVV")
    private String ccCVV;

    @OneToMany
    private List<Taco> tacos = new ArrayList<>();
//    private Taco tacos;

    public void addTaco(Taco taco){
        this.tacos.add(taco);
    }

    public @NotBlank(message = "Delivery name is required") String getDeliveryName() {
        return deliveryName;
    }

    public @NotBlank(message = "Delivery name is required") String getDeliveryStreet() {
        return deliveryStreet;
    }

    public @NotBlank(message = "Delivery name is required") String getDeliveryCity() {
        return deliveryCity;
    }

    public @NotBlank(message = "Delivery name is required") String getDeliveryState() {
        return deliveryState;
    }

    public @NotBlank(message = "Delivery name is required") String getDeliveryZip() {
        return deliveryZip;
    }

    public @CreditCardNumber(message = "not a valid credit card number") String getCcNumber() {
        return ccNumber;
    }

    public @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message = "Must be formatted MM/YY") String getCcExpiration() {
        return ccExpiration;
    }

    public @Digits(integer = 3, fraction = 0, message = "invalid CVV") String getCcCVV() {
        return ccCVV;
    }

    public List<Taco> getTacos() {
        return tacos;
    }
}
