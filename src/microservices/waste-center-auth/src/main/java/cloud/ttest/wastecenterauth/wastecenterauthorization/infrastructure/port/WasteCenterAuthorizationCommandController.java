package cloud.ttest.wastecenterauth.wastecenterauthorization.infrastructure.port;

import cloud.ttest.share.core.application.ApiResponse2xx;
import cloud.ttest.share.core.infrastructure.bus.IMediator;
import cloud.ttest.wastecenterauth.wastecenterauthorization.application.command.create.CreateWasteCenterAuthorizationCommand;
import cloud.ttest.wastecenterauth.wastecenterauthorization.application.command.create.CreateWasteCenterAuthorizationMessage;
import cloud.ttest.wastecenterauth.wastecenterauthorization.application.command.create.CreateWasteCenterAuthorizationRequest;
import cloud.ttest.wastecenterauth.wastecenterauthorization.application.command.delete.DeleteWasteCenterAuthorizationCommand;
import cloud.ttest.wastecenterauth.wastecenterauthorization.application.command.delete.DeleteWasteCenterAuthorizationMessage;
import cloud.ttest.wastecenterauth.wastecenterauthorization.application.command.update.UpdateWasteCenterAuthorizationCommand;
import cloud.ttest.wastecenterauth.wastecenterauthorization.application.command.update.UpdateWasteCenterAuthorizationMessage;
import cloud.ttest.wastecenterauth.wastecenterauthorization.application.command.update.UpdateWasteCenterAuthorizationRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authnumber")
@Tag(name = "Command Waste Center Authorization", description = " Waste Center Authorization API. Contains the " +
        "command operations  that can be performed on a Waste CenterAuthorization Entity.")
public class WasteCenterAuthorizationCommandController {

    private final IMediator mediator;

    public WasteCenterAuthorizationCommandController(IMediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<ApiResponse2xx<CreateWasteCenterAuthorizationMessage>> create(
            @RequestBody CreateWasteCenterAuthorizationRequest request) {
        CreateWasteCenterAuthorizationCommand createCommand = new CreateWasteCenterAuthorizationCommand(request);
        CreateWasteCenterAuthorizationMessage response = mediator.send(createCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.CREATED));
    }

    @PutMapping
    public ResponseEntity<ApiResponse2xx<UpdateWasteCenterAuthorizationMessage>> update(
            @RequestBody UpdateWasteCenterAuthorizationRequest request) {
        UpdateWasteCenterAuthorizationCommand updateCommand = new UpdateWasteCenterAuthorizationCommand(request);
        UpdateWasteCenterAuthorizationMessage response = mediator.send(updateCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.CREATED));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse2xx<DeleteWasteCenterAuthorizationMessage>> update(
            @NotBlank @PathVariable("id") Long id) {
        DeleteWasteCenterAuthorizationCommand updateCommand = new DeleteWasteCenterAuthorizationCommand(id);
        DeleteWasteCenterAuthorizationMessage response = mediator.send(updateCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.NO_CONTENT));
    }



}
