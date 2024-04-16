package cloud.ttest.wastemanagement.wastemanageraddress.infrastructure.port;


import cloud.ttest.share.core.application.ApiResponse2xx;
import cloud.ttest.share.core.domain.MessagePaginatedResponse;
import cloud.ttest.share.core.infrastructure.bus.IMediator;
import cloud.ttest.wastemanagement.wastemanageraddress.application.WasteManagerAddressResponse;
import cloud.ttest.wastemanagement.wastemanageraddress.application.query.getall.GetAllWasteManagerAddressQuery;
import cloud.ttest.wastemanagement.wastemanageraddress.application.query.getbyid.GetByIdWasteManagerAddressQuery;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wastemanager/address")
@Tag(name = "Query Waste Manager Address", description = " Waste Manager Address API. Contains the query operations " +
        "that can be performed on a Waste Manager Address Entity.")
public class WasteManagerAddressQueryController {

    private final IMediator mediator;

    public WasteManagerAddressQueryController(IMediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping
    public ResponseEntity<MessagePaginatedResponse> getAll(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortType) {
        GetAllWasteManagerAddressQuery query = new GetAllWasteManagerAddressQuery(pageNo,pageSize,sortBy,sortType);
        MessagePaginatedResponse pageResponse = mediator.send(query);
        return ResponseEntity.ok(pageResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse2xx<WasteManagerAddressResponse>> getById(@NotBlank @PathVariable Long id) {
        GetByIdWasteManagerAddressQuery query = new GetByIdWasteManagerAddressQuery(id);
        WasteManagerAddressResponse response = mediator.send(query);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }


}
