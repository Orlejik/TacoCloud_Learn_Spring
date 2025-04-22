package com.art.demo4.Data;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "order_id")
    private Long id;

    private String tacoId;
    @NotBlank(message = "Delivery name is required")
    private String deliveryName;
    @NotBlank(message = "Delivery name is required")
    private String deliveryStreet;
    @NotBlank(message = "Delivery name is required")
    private String deliveryCity;
    @NotBlank(message = "Delivery name is required")
    private String deliveryState;
    @NotBlank(message = "Delivery name is required")
    private String deliveryZip;
//    @CreditCardNumber(message = "not a valid credit card number")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message = "Must be formatted MM/YY")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "invalid CVV")
    private String ccCVV;
    private Date placedAt = new Date();

    @ManyToMany(fetch = FetchType.LAZY)  // Change from @OneToMany to @ManyToMany
    @JoinTable(
            name = "order_with_tacos",  // Custom join table name
            joinColumns = @JoinColumn(name = "order_id"),  // FK for Taco
            inverseJoinColumns = @JoinColumn(name = "taco_id")  // FK for Ingredient
    )
    private List<Taco> tacos = new ArrayList<>();

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

//    public @CreditCardNumber(message = "not a valid credit card number") String getCcNumber() {
//        return ccNumber;
//    }

    public @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message = "Must be formatted MM/YY") String getCcExpiration() {
        return ccExpiration;
    }

    public @Digits(integer = 3, fraction = 0, message = "invalid CVV") String getCcCVV() {
        return ccCVV;
    }
}
