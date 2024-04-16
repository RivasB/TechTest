package cloud.ttest.wastemanagement.wastemanager.infrastructure.port;


import cloud.ttest.share.core.application.ApiResponse2xx;
import cloud.ttest.share.core.domain.MessagePaginatedResponse;
import cloud.ttest.share.core.infrastructure.bus.IMediator;
import cloud.ttest.wastemanagement.wastemanager.application.WasteManagerResponse;
import cloud.ttest.wastemanagement.wastemanager.application.query.getall.GetAllWasteManagerQuery;
import cloud.ttest.wastemanagement.wastemanager.application.query.getbyid.GetByIdWasteManagerQuery;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wastemanager")
@Tag(name = "Query Waste Manager", description = " Waste Manager API. Contains the query operations " +
        "that can be performed on a Waste Manager Entity.")
public class WasteManagerQueryController {

    private final IMediator mediator;

    public WasteManagerQueryController(IMediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping
    public ResponseEntity<MessagePaginatedResponse> getAll(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortType) {
        GetAllWasteManagerQuery query = new GetAllWasteManagerQuery(pageNo,pageSize,sortBy,sortType);
        MessagePaginatedResponse pageResponse = mediator.send(query);
        return ResponseEntity.ok(pageResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse2xx<WasteManagerResponse>> getById(@NotBlank @PathVariable Long id) {
        GetByIdWasteManagerQuery query = new GetByIdWasteManagerQuery(id);
        WasteManagerResponse response = mediator.send(query);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }


}
