package cloud.ttest.wastemanagement.wastemanager.infrastructure.port;

import cloud.ttest.share.core.application.ApiResponse2xx;
import cloud.ttest.share.core.infrastructure.bus.IMediator;
import cloud.ttest.wastemanagement.wastemanager.application.command.create.CreateWasteManagerCommand;
import cloud.ttest.wastemanagement.wastemanager.application.command.create.CreateWasteManagerMessage;
import cloud.ttest.wastemanagement.wastemanager.application.command.create.CreateWasteManagerRequest;
import cloud.ttest.wastemanagement.wastemanager.application.command.delete.DeleteWasteManagerCommand;
import cloud.ttest.wastemanagement.wastemanager.application.command.delete.DeleteWasteManagerMessage;
import cloud.ttest.wastemanagement.wastemanager.application.command.update.UpdateWasteManagerCommand;
import cloud.ttest.wastemanagement.wastemanager.application.command.update.UpdateWasteManagerMessage;
import cloud.ttest.wastemanagement.wastemanager.application.command.update.UpdateWasteManagerRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wastemanager")
@Tag(name = "Command Waste Manager", description = " Waste Manager API. Contains the command operations " +
        "that can be performed on a Waste Manager Entity.")
public class WasteManagerCommandController {

    private final IMediator mediator;

    public WasteManagerCommandController(IMediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<ApiResponse2xx<CreateWasteManagerMessage>> create(
            @RequestBody CreateWasteManagerRequest request) {
        CreateWasteManagerCommand createCommand = new CreateWasteManagerCommand(request);
        CreateWasteManagerMessage response = mediator.send(createCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.CREATED));
    }

    @PutMapping
    public ResponseEntity<ApiResponse2xx<UpdateWasteManagerMessage>> update(
            @RequestBody UpdateWasteManagerRequest request) {
        UpdateWasteManagerCommand updateCommand = new UpdateWasteManagerCommand(request);
        UpdateWasteManagerMessage response = mediator.send(updateCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.CREATED));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse2xx<DeleteWasteManagerMessage>> update(
            @NotBlank @PathVariable("id") Long id) {
        DeleteWasteManagerCommand updateCommand = new DeleteWasteManagerCommand(id);
        DeleteWasteManagerMessage response = mediator.send(updateCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.NO_CONTENT));
    }



}
