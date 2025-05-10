package demo.lab4_20206303.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Entity
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public @NotBlank(message = "La dirección es obligatoria") @Size(min = 10) String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank(message = "La dirección es obligatoria") @Size(min = 10) String address) {
        this.address = address;
    }

    public @NotBlank(message = "El nombre es obligatorio") @Size(min = 5, max = 100) String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "El nombre es obligatorio") @Size(min = 5, max = 100) String name) {
        this.name = name;
    }

    public @Pattern(regexp = "\\d{9}", message = "El teléfono debe tener exactamente 9 dígitos") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Pattern(regexp = "\\d{9}", message = "El teléfono debe tener exactamente 9 dígitos") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 5, max = 100)
    private String name;

    @NotBlank(message = "La dirección es obligatoria")
    @Size(min = 10)
    private String address;

    @Pattern(regexp = "\\d{9}", message = "El teléfono debe tener exactamente 9 dígitos")
    private String phoneNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
