package cloud.ttest.wastecenterauth.wastecenterauthorization.infrastructure.port;


import cloud.ttest.share.core.application.ApiResponse2xx;
import cloud.ttest.share.core.domain.MessagePaginatedResponse;
import cloud.ttest.share.core.infrastructure.bus.IMediator;
import cloud.ttest.wastecenterauth.wastecenterauthorization.application.query.getall.GetAllWasteCenterAuthorizationQuery;
import cloud.ttest.wastecenterauth.wastecenterauthorization.application.query.getbyid.GetByIdWasteCenterAuthorizationQuery;
import cloud.ttest.wastecenterauth.wastecenterauthorization.application.WasteCenterAuthorizationResponse;
import cloud.ttest.wastecenterauth.wastecenterauthorization.application.query.getbylist.GetByListWasteCenterAuthorizationQuery;
import cloud.ttest.share.core.application.GetByListWasteCenterAuthorizationRequest;
import cloud.ttest.share.core.application.GetByListWasteCenterAuthorizationResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authnumber")
@Tag(name = "Query Waste CenterAuthorization", description = " Waste Center Authorization API. Contains the query " +
        "operations that can be performed on a Waste Center Authorization Entity.")
public class WasteCenterAuthorizationQueryController {

    private final IMediator mediator;

    public WasteCenterAuthorizationQueryController(IMediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping
    public ResponseEntity<MessagePaginatedResponse> getAll(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "authorizationNumber") String sortBy,
            @RequestParam(defaultValue = "asc") String sortType) {
        GetAllWasteCenterAuthorizationQuery query = new GetAllWasteCenterAuthorizationQuery(pageNo,pageSize,sortBy,sortType);
        MessagePaginatedResponse pageResponse = mediator.send(query);
        return ResponseEntity.ok(pageResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse2xx<WasteCenterAuthorizationResponse>> getById(@NotBlank @PathVariable Long id) {
        GetByIdWasteCenterAuthorizationQuery query = new GetByIdWasteCenterAuthorizationQuery(id);
        WasteCenterAuthorizationResponse response = mediator.send(query);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }

    @PostMapping("/list")
    public ResponseEntity<GetByListWasteCenterAuthorizationResponse> getById(
            @RequestBody GetByListWasteCenterAuthorizationRequest request
    ) {
        GetByListWasteCenterAuthorizationQuery query = new GetByListWasteCenterAuthorizationQuery(request.getIds());
        GetByListWasteCenterAuthorizationResponse response = mediator.send(query);
        return ResponseEntity.ok(response);
    }


}
