package cloud.tteams.comment.comment.domain;

import java.util.List;

public class WasteManagerEntity {
    private final Long id;
    private final String nombre;
    private final String nif;
    // private WasteManagerAddressEntity wasteManagerAddressEntity;
    // Referencia a las autorizaciones por ID
    private final List<Long> listOfWasteCenterAuthorizationIds;
    private final Boolean isEnabled;

    public WasteManagerEntity(Long id, String nombre, String nif, List<Long> listOfWasteCenterAuthorizationIds, Boolean isEnabled) {
        this.id = id;
        this.nombre = nombre;
        this.nif = nif;
        this.listOfWasteCenterAuthorizationIds = listOfWasteCenterAuthorizationIds;
        this.isEnabled = isEnabled;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNif() {
        return nif;
    }

    public List<Long> getListOfWasteCenterAuthorizationIds() {
        return listOfWasteCenterAuthorizationIds;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }
}
